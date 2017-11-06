package com.hisoft.ovi.databse;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ovi on 11/4/2017.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://mosque.epizy.com/connection.php";
    private Map<String, String> params;

    public RegisterRequest(String firstname, String lastname , String email, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("firstname",firstname);
        params.put("lastname ",lastname);
        params.put("email",email);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
