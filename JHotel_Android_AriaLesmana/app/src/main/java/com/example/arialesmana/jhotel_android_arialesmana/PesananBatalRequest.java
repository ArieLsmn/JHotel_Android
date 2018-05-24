package com.example.arialesmana.jhotel_android_arialesmana;

import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;
import com.android.volley.Response;

public class PesananBatalRequest extends StringRequest {
    private static final String Cancel_URL = "http://10.0.2.2:8080/cancelpesanan";
    private Map<String, String> params;

    public PesananBatalRequest(String id_pesanan, Response.Listener<String> listener) {
        super(Method.POST, Cancel_URL, listener, null);
        params = new HashMap<>();
        params.put("id_pesanan",id_pesanan);
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
