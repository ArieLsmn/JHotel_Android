package com.example.arialesmana.jhotel_android_arialesmana;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;
import java.util.*;

public class BuatPesananRequest extends StringRequest {
    private static final String Pesan_URL = "http://192.168.1.2:8080/bookpesanan";
    private Map<String, String> params;
    public BuatPesananRequest(String durasiHari,Response.Listener<String> listener) {
        super(Method.POST, Pesan_URL, listener, null);
        params = new HashMap<>();
        params.put("durasi", durasiHari);

    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

