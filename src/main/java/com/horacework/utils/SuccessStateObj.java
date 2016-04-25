package com.horacework.utils;

import static com.horacework.utils.JsonUtil.toJson;

public class SuccessStateObj {
    private int stateCode;
    private long requestTime;
    private int start;
    private int loadMore;
    private String msg;
    private Object data;
    //private byte[] encodeData;
    //private String privateKey = MyPrivateKey.getPrivateKey();

    public SuccessStateObj(int state, long time, int start, int hasmore, String msg) {
        this.stateCode = state;
        this.requestTime = time;
        this.start = start;
        this.loadMore = hasmore;
        this.msg = msg;
    }
    public SuccessStateObj(int state, long time, int start, int hasmore, String msg,Object data) throws Exception {
        this(state,time,start,hasmore,msg);
        //新增:Obj data先转String，再转byte[]进行RSA加密，再转回String
        //String privateKey = MyPrivateKey.getPrivateKey();
        //this.encodeData= RSAUtils.encryptByPrivateKey(JsonUtil.toJson(data).getBytes(),privateKey);
        this.data = data;
    }

    public int getState() {
        return stateCode;
    }

    public void setState(int state) {
        this.stateCode = state;
    }

    public long getTime() {
        return requestTime;
    }

    public void setTime(long time) {
        this.requestTime = time;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getHasmore() {
        return loadMore;
    }

    public void setHasmore(int hasmore) {
        this.loadMore = hasmore;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
