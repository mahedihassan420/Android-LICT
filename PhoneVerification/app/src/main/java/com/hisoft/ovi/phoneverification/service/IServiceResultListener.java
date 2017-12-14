package com.hisoft.ovi.phoneverification.service;



public interface IServiceResultListener {
    public void OnServiceResult(String method, DTOBase dtoBase, boolean success);
}
