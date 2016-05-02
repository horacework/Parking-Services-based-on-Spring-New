package com.horacework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by HoraceChan on 2016/5/2.
 */
@Entity
@Table(name = "userorder", schema = "parking", catalog = "")
public class UserorderEntity {
    private String orderId;
    private String markerId;
    private String userId;
    private Timestamp orderTime;
    private Timestamp present;
    private int isDel;

    @Id
    @Column(name = "orderId", nullable = false, length = 36)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
    @Column(name = "orderTime", nullable = false)
    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "present", nullable = false)
    public Timestamp getPresent() {
        return present;
    }

    public void setPresent(Timestamp present) {
        this.present = present;
    }

    @Basic
    @Column(name = "isDel", nullable = false)
    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserorderEntity that = (UserorderEntity) o;

        if (isDel != that.isDel) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (markerId != null ? !markerId.equals(that.markerId) : that.markerId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (orderTime != null ? !orderTime.equals(that.orderTime) : that.orderTime != null) return false;
        if (present != null ? !present.equals(that.present) : that.present != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (markerId != null ? markerId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
        result = 31 * result + (present != null ? present.hashCode() : 0);
        result = 31 * result + isDel;
        return result;
    }
}
