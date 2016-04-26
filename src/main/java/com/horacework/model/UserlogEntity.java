package com.horacework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by HoraceChan on 2016/4/19.
 */
@Entity
@Table(name = "userlog", schema = "parking", catalog = "")
public class UserlogEntity {
    private int logId;
    private String userId;
    private Timestamp loginTime;
    private String deviceId;
    private int isLoginOut;
    private Timestamp logoutTime;

    public void setIsLoginOut(byte isLoginOut) {
        this.isLoginOut = isLoginOut;
    }

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
    @Column(name = "loginTime", nullable = false)
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "deviceId", nullable = false, length = 36)
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "isLoginOut", nullable = false)
    public int getIsLoginOut() {
        return isLoginOut;
    }

    public void setIsLoginOut(int isLoginOut) {
        this.isLoginOut = isLoginOut;
    }

    @Basic
    @Column(name = "logoutTime", nullable = true)
    public Timestamp getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Timestamp logoutTime) {
        this.logoutTime = logoutTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserlogEntity that = (UserlogEntity) o;

        if (logId != that.logId) return false;
        if (isLoginOut != that.isLoginOut) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (loginTime != null ? !loginTime.equals(that.loginTime) : that.loginTime != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (logoutTime != null ? !logoutTime.equals(that.logoutTime) : that.logoutTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + isLoginOut;
        result = 31 * result + (logoutTime != null ? logoutTime.hashCode() : 0);
        return result;
    }
}
