package com.ww.springbootlearn.json.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * 测试日期json序列化、反序列化
 * @author wanggw
 * @date 2022-01-20 00:04:57
 */
public class Message implements Serializable {

    private static final long serialVersionUID = -7741928306375999513L;

    private String text;

    private LocalDate date;

    private LocalTime time;

    private LocalDateTime timestamp;

    private Date dateUtil;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Date getDateUtil() {
        return dateUtil;
    }

    public void setDateUtil(Date dateUtil) {
        this.dateUtil = dateUtil;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", timestamp=" + timestamp +
                ", dateUtil=" + dateUtil +
                '}';
    }
}
