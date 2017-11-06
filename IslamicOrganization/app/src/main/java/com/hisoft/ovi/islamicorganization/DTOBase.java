package com.hisoft.ovi.islamicorganization;

import java.io.Serializable;


public class DTOBase implements Serializable {
    protected String status;
    protected String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
