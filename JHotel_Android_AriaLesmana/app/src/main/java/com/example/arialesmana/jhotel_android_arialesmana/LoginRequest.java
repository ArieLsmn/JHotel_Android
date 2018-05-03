package com.example.arialesmana.jhotel_android_arialesmana;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.*;

public class LoginRequest extends StringRequest {
    private static final String Login_URL = "http://10.5.79.32/logincust";
    private Map<String, String> params;
    public LoginRequest(String email, String password,
                           Response.Listener<String> listener) {
        super(Method.POST, Login_URL, listener, null);
        params = new HashMap<>();
        params.put("email",email);
        params.put("password", password);

    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}