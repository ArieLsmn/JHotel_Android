package com.example.arialesmana.jhotel_android_arialesmana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.toolbox.Volley.newRequestQueue;


public class HotelActivity extends AppCompatActivity {
    private int currentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b!=null){
            currentUserId = b.getInt("id_customer");
        }
        refreshList();
    }

    public void refreshList() {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    final TextView namaHotel = (TextView) findViewById(R.id.namaHotelText);
                    final TextView idHotel = (TextView) findViewById(R.id.idHotelText);
                    final TextView bintang = (TextView) findViewById(R.id.bintangText);
                    final TextView koorX = (TextView) findViewById(R.id.koorXText);
                    final TextView koorY = (TextView) findViewById(R.id.koorYText);
                    final TextView desc = (TextView) findViewById(R.id.descText);
                    JSONArray jsonResponse = new JSONArray(response);
                    JSONObject e = jsonResponse.getJSONObject(0).getJSONObject("hotel");
                    JSONObject lokasi = e.getJSONObject("lokasi");
                    namaHotel.setText(e.getString("nama"));
                    idHotel.setText(String.valueOf(e.getInt("id")));
                    bintang.setText(String.valueOf(e.getInt("bintang")));
                    koorX.setText(String.valueOf(lokasi.getDouble("x")));
                    koorY.setText(String.valueOf(lokasi.getDouble("y")));
                    desc.setText(lokasi.getString("deskripsi"));

                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        };
        MenuRequest menuRequest = new MenuRequest(responseListener);
        RequestQueue queue = newRequestQueue(HotelActivity.this);
        queue.add(menuRequest);
    }
}