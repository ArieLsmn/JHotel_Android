package com.example.arialesmana.jhotel_android_arialesmana;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.*;

public class MenuRequest extends StringRequest {
    private static final String Menu_URL = "http://10.5.79.32:8080/vacantrooms";
    //private Map<String, String> params;
    public MenuRequest (Response.Listener<String> listener){
        super(Method.GET, Menu_URL, listener, null);
        /*public ArrayList<Room> vacantRooms(){
            return DatabaseRoom.getVacantRooms();
        }*/
    }

}
