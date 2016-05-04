package com.horacework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by HoraceChan on 2016/5/4.
 */
@Entity
@Table(name = "parkinglog", schema = "parking", catalog = "")
public class ParkinglogEntity {
    private String logId;
    private String userId;
    private String carId;
    private String markerId;
    private Timestamp enterTime;
    private Timestamp leaveTime;
    private int isOrder;
    private int isComplete;

    @Id
    @Column(name = "logId", nullable = false, length = 36)
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
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
    @Column(name = "carId", nullable = false, length = 36)
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
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
    @Column(name = "enterTime", nullable = false)
    public Timestamp getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Timestamp enterTime) {
        this.enterTime = enterTime;
    }

    @Basic
    @Column(name = "leaveTime", nullable = true)
    public Timestamp getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Timestamp leaveTime) {
        this.leaveTime = leaveTime;
    }

    @Basic
    @Column(name = "isOrder", nullable = false)
    public int getIsOrder() {
        return isOrder;
    }

    public void setIsOrder(int isOrder) {
        this.isOrder = isOrder;
    }

    @Basic
    @Column(name = "isComplete", nullable = false)
    public int getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(int isComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkinglogEntity that = (ParkinglogEntity) o;

        if (isOrder != that.isOrder) return false;
        if (isComplete != that.isComplete) return false;
        if (logId != null ? !logId.equals(that.logId) : that.logId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (carId != null ? !carId.equals(that.carId) : that.carId != null) return false;
        if (markerId != null ? !markerId.equals(that.markerId) : that.markerId != null) return false;
        if (enterTime != null ? !enterTime.equals(that.enterTime) : that.enterTime != null) return false;
        if (leaveTime != null ? !leaveTime.equals(that.leaveTime) : that.leaveTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId != null ? logId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (carId != null ? carId.hashCode() : 0);
        result = 31 * result + (markerId != null ? markerId.hashCode() : 0);
        result = 31 * result + (enterTime != null ? enterTime.hashCode() : 0);
        result = 31 * result + (leaveTime != null ? leaveTime.hashCode() : 0);
        result = 31 * result + isOrder;
        result = 31 * result + isComplete;
        return result;
    }
}
