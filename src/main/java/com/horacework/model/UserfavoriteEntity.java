package com.horacework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by HoraceChan on 2016/4/26.
 */
@Entity
@Table(name = "userfavorite", schema = "parking", catalog = "")
public class UserfavoriteEntity {
    private String id;
    private String markerId;
    private String userId;
    private Timestamp currentTime;
    private Timestamp cancelTime;
    private byte isCancel;

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "markerId", nullable = false, length = 36)
    public String getMarkerId() {
        return markerId;
    }

    public void setMarkerId(String markerId) {
        this.markerId = markerId;
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
    @Column(name = "currentTime", nullable = false)
    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    @Basic
    @Column(name = "cancelTime", nullable = true)
    public Timestamp getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Timestamp cancelTime) {
        this.cancelTime = cancelTime;
    }

    @Basic
    @Column(name = "isCancel", nullable = false)
    public byte getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(byte isCancel) {
        this.isCancel = isCancel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserfavoriteEntity that = (UserfavoriteEntity) o;

        if (isCancel != that.isCancel) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (markerId != null ? !markerId.equals(that.markerId) : that.markerId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (currentTime != null ? !currentTime.equals(that.currentTime) : that.currentTime != null) return false;
        if (cancelTime != null ? !cancelTime.equals(that.cancelTime) : that.cancelTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (markerId != null ? markerId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (currentTime != null ? currentTime.hashCode() : 0);
        result = 31 * result + (cancelTime != null ? cancelTime.hashCode() : 0);
        result = 31 * result + (int) isCancel;
        return result;
    }
}
