# 事件

Spring提供了以下5种标注事件，我们可以注册相应事件监听器进行处理该事件。

* 1）上下文更新事件（ContextRefreshedEvent）

  在调用ConfigurableApplicationContext接口中的refresh()方法时被触发。

* 2）上下文开始事件（ContextStartedEvent）

  当容器调用ConfigurableApplicationContext的start()方法开始、重新开始容器时触发该事件。

* 3）上下文停止事件（ContextStoppedEvent）

  当容器调用ConfigurableApplicationContext的stop()方法停止容器时触发该事件。

* 4）当上下文关闭事件（ContextClosedEvent）

  当ApplicationContext被关闭时触发该事件，容器被关闭时，其管理的所有单例bean都被销毁。

* 5）请求处理事件（RequestHandledEvent）

  在Web应用中，当一个http请求（request）结束触发该事件。