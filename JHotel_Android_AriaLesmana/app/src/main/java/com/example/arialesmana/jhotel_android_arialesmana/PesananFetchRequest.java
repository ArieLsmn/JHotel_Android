package com.example.arialesmana.jhotel_android_arialesmana;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.*;


public class PesananFetchRequest extends StringRequest {
    private static final String Fetch_URL = "http://10.0.2.2:8080/pesanancustomer";
    private Map<String, String> params;
    public PesananFetchRequest(String id_customer, Response.Listener<String> listener) {
        super(Method.GET, Fetch_URL+id_customer, listener, null);
        params = new HashMap<>();
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

