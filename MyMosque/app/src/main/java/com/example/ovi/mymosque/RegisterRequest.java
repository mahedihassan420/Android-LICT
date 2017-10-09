package com.example.ovi.mymosque;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ovi on 9/27/17.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://mymosque.hisoftltd.com/insertMember.php";
    private Map<String, String> params;

    public RegisterRequest(String first_name, String last_name, String email, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("first_name", first_name);
        params.put("last_name", last_name + "");
        params.put("email", email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
