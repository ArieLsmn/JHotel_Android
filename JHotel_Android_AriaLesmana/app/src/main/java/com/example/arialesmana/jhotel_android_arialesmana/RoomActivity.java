package com.example.arialesmana.jhotel_android_arialesmana;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import android.view.View;

import static com.android.volley.toolbox.Volley.newRequestQueue;

public class RoomActivity extends AppCompatActivity {
    private ArrayList<Hotel> listHotel = new ArrayList<>();
    private ArrayList<Room> listRoom = new ArrayList<>();
    private int currentUserId;
    private int sukses;
    private HashMap<Hotel, ArrayList<Room>> childMapping = new HashMap<>();
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b!=null){
            currentUserId = b.getInt("id_customer");
        }

        expListView = (ExpandableListView) findViewById(R.id.expandHotel);

        refreshList();

        final Button searchClick = (Button) findViewById(R.id.searchButton);
        final EditText searchInput = (EditText) findViewById(R.id.searchInput);
        searchClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String search = searchInput.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONArray jsonResponse = new JSONArray(response);
                            if(jsonResponse!=null) {
                                for (int i = 0; i < jsonResponse.length(); i++) {
                                    JSONObject room = jsonResponse.getJSONObject(i);
                                    if (room.getString("nomorKamar").equals(search)){
                                        Intent intent = new Intent(RoomActivity.this, RoomDetailActivity.class);
                                        intent.putExtra("id_customer", currentUserId);
                                        intent.putExtra("nomorKamar", room.getString("nomorKamar"));
                                        intent.putExtra("tipeKamar", room.getString("tipeKamar"));
                                        intent.putExtra("statusKamar", room.getString("statusKamar"));
                                        intent.putExtra("dailyTariff", room.getDouble("dailyTariff"));
                                        startActivity(intent);
                                        sukses=1;
                                        break;
                                    }
                                    sukses=0;
                                }
                                if (sukses==0){
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RoomActivity.this);
                                    builder.setMessage("Room Tidak Ditemukan")
                                            .create()
                                            .show();
                                }

                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RoomActivity.this);
                            builder.setMessage("Tidak Ada Room")
                                    .create()
                                    .show();
                        }
                    }
                };
                RoomRequest roomRequest = new RoomRequest(responseListener);
                RequestQueue queue = newRequestQueue(RoomActivity.this);
                queue.add(roomRequest);
            }
        });
    }


    public void refreshList() {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonResponse = new JSONArray(response);
                    JSONObject e = jsonResponse.getJSONObject(0).getJSONObject("hotel");
                    JSONObject lokasi = e.getJSONObject("lokasi");
                    Hotel h = new Hotel(e.getInt("id"),e.getString("nama"), new Lokasi(lokasi.getDouble("x"), lokasi.getDouble("y"), lokasi.getString("deskripsi")), e.getInt("bintang"));
                    listHotel.add(h);
                    for (int i = 0; i < jsonResponse.length(); i++) {
                        JSONObject room = jsonResponse.getJSONObject(i);
                        Room room1 = new Room(room.getString("tipeKamar"), room.getString("nomorKamar"), room.getDouble("dailyTariff"), room.getString("statusKamar"));
                        listRoom.add(room1);
                    }

                    childMapping.put(listHotel.get(0), listRoom);
                    listAdapter = new MenuListAdapter(RoomActivity.this, listHotel, childMapping);
                    expListView.setAdapter(listAdapter);
                    expListView.setOnChildClickListener(new OnChildClickListener() {
                                                            @Override
                                                            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                                                                Room selected = childMapping.get(listHotel.get(groupPosition)).get(childPosition);
                                                                Intent intent = new Intent(RoomActivity.this, RoomDetailActivity.class);
                                                                intent.putExtra("id_customer", currentUserId);
                                                                intent.putExtra("nomorKamar", selected.getNomorKamar());
                                                                intent.putExtra("tipeKamar", selected.getTipeKamar());
                                                                intent.putExtra("statusKamar", selected.getStatusKamar());
                                                                intent.putExtra("dailyTariff", selected.getDailyTariff());
                                                                startActivity(intent);
                                                                return false;
                                                            }
                                                        }
                    );
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        };
        MenuRequest menuRequest = new MenuRequest(responseListener);
        RequestQueue queue = newRequestQueue(RoomActivity.this);
        queue.add(menuRequest);
    }
}