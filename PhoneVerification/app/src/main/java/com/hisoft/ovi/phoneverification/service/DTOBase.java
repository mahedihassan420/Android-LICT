package com.hisoft.ovi.phoneverification.service;

import java.io.Serializable;

public class DTOBase implements Serializable {
    protected String ststus;
    protected String status;
    protected String msg;

    public String getStstus() {
        return ststus;
    }

    public void setStstus(String ststus) {
        this.ststus = ststus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
