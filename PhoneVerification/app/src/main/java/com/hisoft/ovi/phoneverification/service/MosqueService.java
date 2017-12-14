package com.hisoft.ovi.phoneverification.service;

import android.content.Context;

import com.hisoft.ovi.phoneverification.model.MobileVerification;
import com.hisoft.ovi.phoneverification.model.UserDetails;
import com.hisoft.ovi.phoneverification.utility.AppBaseUrl;

/**
 * Created by Ovi on 12/6/2017.
 */

public class MosqueService extends BaseService {
    public MosqueService(Context context) {
        super(context);
    }

    public MosqueService(Context context, IServiceResultListener serviceResultListener) {
        super(context, serviceResultListener);
    }

    public void setUserLogin(String mobileNumber){
        MobileVerification mobileVerification = new MobileVerification();
        setPostRequest(AppBaseUrl.LOGIN_URL+"&user_unique_id="+mobileNumber,"",mobileVerification,"USER_LOGIN",true,"GET",false);
    }

    public void setUserDetails(UserDetails userDetails){
        setPostRequest(AppBaseUrl.USER_DETAILS,userDetails.toString(),userDetails,"USER_DETAILS",true,"POST",false);
    }
}
