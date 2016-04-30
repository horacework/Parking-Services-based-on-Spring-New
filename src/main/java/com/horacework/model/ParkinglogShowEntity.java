package com.horacework.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by HoraceChan on 2016/4/26.
 */
public class ParkinglogShowEntity {
    private String logId;
    private Timestamp enterTime;
    private Timestamp leaveTime;
    private String plate;
    private String name;

//    public ParkinglogShowEntity(String logId,Timestamp enterTime,Timestamp leaveTime,String plate,String name){
//        super();
//        this.logId = logId;
//        this.enterTime = enterTime;
//        this.leaveTime = leaveTime;
//        this.plate = plate;
//        this.name = name;
//    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public Timestamp getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Timestamp enterTime) {
        this.enterTime = enterTime;
    }

    public Timestamp getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Timestamp leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
