package com.example.arialesmana.jhotel_android_arialesmana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import org.json.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
private ArrayList<Hotel> listHotel = new ArrayList<Hotel>();
private ArrayList<Room> listRoom = new ArrayList<Room>();
private HashMap<Hotel, ArrayList<Room>> childMapping = new HashMap<Hotel, ArrayList<Room>>();


    public void refreshList(){
        Response.Listener<String> responseListener = new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray jsonResponse = new JSONArray(response);
                    JSONObject e = jsonResponse.getJSONObject (0).getJSONObject("hotel");
                    JSONObject lokasi = e.getJSONObject("lokasi");
                    JSONObject nama = e.getJSONObject("nama");
                    JSONObject bintang = e.getJSONObject("bintang");

                    Lokasi lokasi1 = new Lokasi(1,1,"Depok");
                    Hotel hotel1 = new Hotel(e.getInt("id"),e.getString("nama"),lokasi1,e.getInt("bintang"));
                    listHotel.add(hotel1);

                    Room room1=new Room(hotel1,e.getString("nomor_kamar"));

                    childMapping.put(listHotel.get(0),listRoom);
                }
                catch (JSONException e){
                }
            }
        };
    }
}
