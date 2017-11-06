package com.hisoft.ovi.islamicorganization;

import android.content.Context;


public class MosqueService extends BaseService {
    public MosqueService(Context context) {
        super(context);
    }

    public MosqueService(Context context, IServiceResultListener serviceResultListener) {
        super(context, serviceResultListener);
    }

    public void LoadIslamicOrganizations(String lat,String lon){
        StringBuilder builder = new StringBuilder();
        builder.append(AppBaseUrl.GOOGLE_PLACE);
        builder.append("location="+lat+","+lon);
        builder.append("&radius=500");
        builder.append("&type=mosque&sensor=true");
        builder.append("&key=AIzaSyCh7ZyMmkczXDetRSeEp6LJ5mEohCruzPk");
        setPostRequest(builder.toString(),"",new GooglePlace(),"MOSQUE",true,"GET",false);
    }

}
