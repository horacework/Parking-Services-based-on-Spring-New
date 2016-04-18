package com.horacework.utils;

import com.sun.org.apache.xpath.internal.operations.String;

public class JsonObj {
    private Object data;
    private int stateCode;
    private long requestTime;
    private String errorStr;
    private int start;
    private int loadMore;

    public JsonObj(Object obj, int stateCode,int loadMore) {
        this.loadMore=loadMore;
        this.data=obj;
        this.stateCode=stateCode;
        this.requestTime=System.currentTimeMillis();
    }
    public static JsonObj getDefaultSuccess(Object obj, int start,int loadMore){
        JsonObj jsonObj =new JsonObj(obj,200,loadMore);
        jsonObj.setStart(start);
        return jsonObj;
    }

    public String getErrorStr() {
        return errorStr;
    }

    public void setErrorStr(String errorStr) {
        this.errorStr = errorStr;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public int getLoadMore() {
        return loadMore;
    }

    public void setLoadMore(int loadMore) {
        this.loadMore = loadMore;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
