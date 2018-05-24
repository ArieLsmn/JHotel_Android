package com.example.arialesmana.jhotel_android_arialesmana;


import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;
import com.android.volley.Response;

public class RoomRequest extends StringRequest{
    private static final String Room_URL = "http://10.0.2.2:8080/databaserooms";
    private Map<String, String> params;

    public RoomRequest(Response.Listener<String> listener) {
        super(Request.Method.GET, Room_URL, listener, null);
        params = new HashMap<>();
    }
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
