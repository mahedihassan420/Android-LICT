package com.hisoft.ovi.islamicorganization;



public interface IServiceResultListener {
    public void OnServiceResult(String method, DTOBase dtoBase, boolean success);
}
