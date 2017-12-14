package com.hisoft.ovi.phoneverification.utility;

/**
 * Created by Invariant on 10/8/17.
 */

public class AppBaseUrl {

    public static final String APP_KEY="403980bcb9e9e6cdec515230791af8b0ab1aaa244b58a8d99152673aa22197e0&";
    public static final String BASE_URL="http://siliconbanglasoft.com/amar_brand/apis/";

    public static final String LOGIN_URL=BASE_URL+"Api_Login/ask_token_init?app_key="+APP_KEY;
    public static final String USER_DETAILS=BASE_URL+"Api_Login/addMember";
    public static final String Organization_DETAILS=BASE_URL+"Api_Organization/org_details?";




    public static final String FIREBASE_STORE_URL= "gs://developmentproject-68bbb.appspot.com";
    public static final String GOOGLE_PLACE="https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
}
