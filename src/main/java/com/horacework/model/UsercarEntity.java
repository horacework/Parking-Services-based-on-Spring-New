package com.horacework.model;

import javax.persistence.*;

/**
 * Created by HoraceChan on 2016/4/26.
 */
@Entity
@Table(name = "usercar", schema = "parking", catalog = "")
public class UsercarEntity {
    private String carId;
    private String userId;
    private String plate;
    private byte isDel;

    @Id
    @Column(name = "carId", nullable = false, length = 36)
    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
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
    @Column(name = "plate", nullable = false, length = 10)
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Basic
    @Column(name = "isDel", nullable = false)
    public byte getIsDel() {
        return isDel;
    }

    public void setIsDel(byte isDel) {
        this.isDel = isDel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsercarEntity that = (UsercarEntity) o;

        if (isDel != that.isDel) return false;
        if (carId != null ? !carId.equals(that.carId) : that.carId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (plate != null ? !plate.equals(that.plate) : that.plate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carId != null ? carId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (plate != null ? plate.hashCode() : 0);
        result = 31 * result + (int) isDel;
        return result;
    }
}
