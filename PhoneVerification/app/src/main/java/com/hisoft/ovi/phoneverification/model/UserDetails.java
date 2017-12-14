package com.hisoft.ovi.phoneverification.model;

import com.hisoft.ovi.phoneverification.service.DTOBase;

import java.lang.reflect.Field;
import java.net.URLEncoder;

/**
 * Created by Invariant on 10/11/17.
 */

public class UserDetails extends DTOBase {
    private String user_unique_id;
    private String country_code;
    private String first_name;
    private String last_name;
    private String email;
    private String selector;
    private String validator;


    public String getUser_unique_id() {
        return user_unique_id;
    }

    public void setUser_unique_id(String user_unique_id) {
        this.user_unique_id = user_unique_id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        Class<?> thisClass = null;
        try {
            thisClass = Class.forName(this.getClass().getName());

            Field[] aClassFields = thisClass.getDeclaredFields();

            for(Field f : aClassFields){

                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(f.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(f.get(this)+"", "UTF-8"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
        return result.toString();
    }
}
