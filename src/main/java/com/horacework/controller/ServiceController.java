package com.horacework.controller;

import com.horacework.model.ParkingstatusEntity;
import com.horacework.model.ParkingstatusShowEntity;
import com.horacework.repository.ParkingStatusRepository;
import com.horacework.utils.JsonUtil;
import com.horacework.utils.SuccessStateObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.UUID;


@Controller
@RequestMapping("/service")
public class ServiceController extends BaseController {

    @Autowired
    ParkingStatusRepository mParkingStatusRepository;

    @RequestMapping(value = "/statusCheck",method = RequestMethod.POST)
    public void statusCheck(@RequestParam String logid , @RequestParam String markerid) throws IOException {
        String resultStr;
        String uuid = UUID.randomUUID().toString();
        if (logid.equals("")){
            ParkingstatusEntity statusEntity = new ParkingstatusEntity();
            statusEntity.setLogId(uuid);
            statusEntity.setMarkerId(markerid);
            mParkingStatusRepository.saveAndFlush(statusEntity);
            ParkingstatusShowEntity showStatusEntity = new ParkingstatusShowEntity();
            showStatusEntity.setNewLogId(uuid);
            showStatusEntity.setMarkerId(markerid);
            showStatusEntity.setOldStatus(0);
            resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"首次状态获取成功",showStatusEntity));
        }else {
            ParkingstatusEntity status = mParkingStatusRepository.findOne(logid);
            if (status.getStatus()==0){
                resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"状态无改变"));
            }else {
                ParkingstatusShowEntity returnStatus = new ParkingstatusShowEntity();
                ParkingstatusEntity newStatus = new ParkingstatusEntity();
                newStatus.setLogId(uuid);
                newStatus.setMarkerId(markerid);
                mParkingStatusRepository.saveAndFlush(newStatus);
                returnStatus.setNewLogId(uuid);
                returnStatus.setMarkerId(markerid);
                returnStatus.setOldStatus(status.getStatus());
                resultStr = JsonUtil.toJson(new SuccessStateObj(200,System.currentTimeMillis(),0,0,"状态已经改变",returnStatus));
            }
        }
        response.getWriter().write(resultStr);
    }
}