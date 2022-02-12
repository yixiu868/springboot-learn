# CORS

[跨域资源共享 CORS 详解](http://www.ruanyifeng.com/blog/2016/04/cors.html)

`Cross-origin resource sharing` 跨域资源共享

## 简介

允许浏览器向跨域服务器，发出XMLHttpRequest请求，从而克服AJAX只能同源使用的限制。

CORS需要浏览器和服务器同时支持，目前所有浏览器都支持该功能。所以实现CORS通信的关键是服务器，只要服务器实现了CORS，就可以实现跨域通信。

## 两种请求

### 简单请求

只要同时满足以下两大条件，就属于简单请求

（1）请求方法时以下三种之一：

* HEAD
* GET
* POST

（2）HTTP的头信息不超过以下几种字段：

* Accept
* Accept-Language
* Content-Language
* Last-Event-ID
* Content-Type：只限于三个值application/x-www-form-urlencoded、multipart/form-data、text/plain

凡是不满简单请求条件的都是非简单请求。

对于简单请求，浏览器直接发出CORS请求。具体来说，就是在头信息中，增加一个Origin字段。浏览器发现这次跨域AJAX请求时简单请求，就自动在头信息之中，增加一个Origin字段。

```html
GET /cors HTTP/1.1
Origin: http://api.do.com
Host: api.alice.com
Accept-Language: en-US
Connection: keep-alive
User-Agent: Mozilla/5.0...
```

Origin字段用来说明，本次请求来自哪个源（协议+域名+端口）。服务器根据这个值，决定是否同意这次请求。

如果Origin指定的源，不在许可范围内，服务器会返回一个正常的HTTP回应。浏览器发现，这个回应的头信息没有包含Access-Control-Allow-Origin字段，就知道出错了，从而抛出一个错误。

如果Origin指定的域名在许可范围内，服务端返回的响应，会多出几个头信息字段。

```html
Access-Control-Allow-Origin: http://api.do.com
Access-Control-Allow-Credentials: true
Access-Control-Expose-Headers: FooBar
Content-Type: text/html; charset=utf-8
```

* Access-Control-Allow-Origin

  该字段是必须的，它的值要么是请求时Origin字段的值，要么是一个*，表示接受任意域名的请求。

* Access-Control-Allow-Credentials

  该字段可选。它的值是一个布尔值，是否允许发送Cookie。默认情况下，Cookie不包括在CORS请求之中。设为true，表示服务器明确许可，Cookie可以包含在请求中，一起发给服务器。这个值也只能设为true，如果服务器不要浏览器发送cookie，删除该字段即可。

* Access-Control-Expose-Headers

  该字段可选。CORS请求时，XMLHttpRequest对象的getResponseHeader()方法只能拿到6个基本字段：Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma。如果想拿到其他字段，就必须在Access-Control-Expose-Headers里面指定。

### 非简单请求

非简单请求时那种对服务器有特殊要求的请求，比如请求时PUT或DELETE，或者Content-Type字段的类型时application/json。

非简单请求的CORS请求，会在正式通信之前，增加一次HTTP查询请求，成为“预检”请求。

浏览器先查询服务器，当前网页所在的域名是否在服务器的许可名单之中，以及可以使用哪些HTTP动词和头信息字段。只有得到肯定答复，浏览器才会发出正式的XMLHttpRequest请求，否则就报错。