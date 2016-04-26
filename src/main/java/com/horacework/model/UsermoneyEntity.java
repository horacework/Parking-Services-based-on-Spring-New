package com.horacework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by HoraceChan on 2016/4/26.
 */
@Entity
@Table(name = "usermoney", schema = "parking", catalog = "")
public class UsermoneyEntity {
    private int logId;
    private String userId;
    private int type;
    private int figure;
    private int remain;
    private Timestamp currentTime;

    @Id
    @Column(name = "logId", nullable = false)
    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "userId", nullable = false, length = 36)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "figure", nullable = false)
    public int getFigure() {
        return figure;
    }

    public void setFigure(int figure) {
        this.figure = figure;
    }

    @Basic
    @Column(name = "remain", nullable = false)
    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
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

        UsermoneyEntity that = (UsermoneyEntity) o;

        if (logId != that.logId) return false;
        if (type != that.type) return false;
        if (figure != that.figure) return false;
        if (remain != that.remain) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (currentTime != null ? !currentTime.equals(that.currentTime) : that.currentTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + figure;
        result = 31 * result + remain;
        result = 31 * result + (currentTime != null ? currentTime.hashCode() : 0);
        return result;
    }
}
