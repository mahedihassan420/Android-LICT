package com.hisoft.ovi.phoneverification.model;

import com.hisoft.ovi.phoneverification.service.DTOBase;

/**
 * Created by Invariant on 11/5/17.
 */

public class MobileVerification extends DTOBase {
    private Boolean exist;
    private String selector;
    private String validator;

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }
}
