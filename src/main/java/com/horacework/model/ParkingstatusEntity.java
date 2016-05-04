package com.horacework.model;

import javax.persistence.*;

/**
 * Created by HoraceChan on 2016/5/4.
 */
@Entity
@Table(name = "parkingstatus", schema = "parking", catalog = "")
public class ParkingstatusEntity {
    private String logId;
    private int status;
    private String markerId;

    @Id
    @Column(name = "logId", nullable = false, length = 36)
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingstatusEntity that = (ParkingstatusEntity) o;

        if (status != that.status) return false;
        if (logId != null ? !logId.equals(that.logId) : that.logId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = logId != null ? logId.hashCode() : 0;
        result = 31 * result + status;
        return result;
    }

    @Basic
    @Column(name = "markerId", nullable = false, length = 36)
    public String getMarkerId() {
        return markerId;
    }

    public void setMarkerId(String markerId) {
        this.markerId = markerId;
    }
}
