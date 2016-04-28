package com.horacework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by HoraceChan on 2016/4/28.
 */
@Entity
@Table(name = "feedback", schema = "parking", catalog = "")
public class FeedbackEntity {
    private int id;
    private String userId;
    private String telphone;
    private String content;
    private Timestamp currentTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId", nullable = true, length = 36)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "telphone", nullable = true, length = 50)
    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 200)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "currentTime", nullable = false)
    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackEntity that = (FeedbackEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (telphone != null ? !telphone.equals(that.telphone) : that.telphone != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (currentTime != null ? !currentTime.equals(that.currentTime) : that.currentTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (telphone != null ? telphone.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (currentTime != null ? currentTime.hashCode() : 0);
        return result;
    }
}
