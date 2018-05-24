package com.example.arialesmana.jhotel_android_arialesmana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import org.json.*;
import java.util.*;

import android.view.View;
import android.widget.*;

import static com.android.volley.toolbox.Volley.newRequestQueue;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Hotel> listHotel = new ArrayList<>();
    private ArrayList<Room> listRoom = new ArrayList<>();
    private HashMap<Hotel, ArrayList<Room>> childMapping = new HashMap<>();
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    HashMap<String, Hotel> hotelHashMap = new HashMap<>();
    HashMap<String, ArrayList<Room>> roomsMap = new HashMap<>();
    private int currentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button pesanan = (Button) findViewById(R.id.pesanan);

        Intent passInt = getIntent();
        Bundle passBun = passInt.getExtras();
        if(passBun!=null){
            currentUserId = passBun.getInt("id_customer");
        }

        expListView = (ExpandableListView) findViewById(R.id.expandHotel);
        refreshList();

        pesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pesananInt = new Intent(MainActivity.this, SelesaiPesananActivity.class);
                pesananInt.putExtra("id_customer", currentUserId);
                MainActivity.this.startActivity(pesananInt);
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
                    Lokasi l = new Lokasi(lokasi.getDouble("x"), lokasi.getDouble("y"), lokasi.getString("deskripsi"));
                    Hotel h = new Hotel(e.getInt("id"),e.getString("nama"),l,e.getInt("bintang"));
                    listHotel.add(h);
                    for (int i = 0; i < jsonResponse.length(); i++) {
                        JSONObject room = jsonResponse.getJSONObject(i);
                        Room room1 = new Room(room.getString("nomorKamar"),room.getString("statusKamar"),room.getDouble("dailyTariff"),room.getString("tipeKamar"));
                        listRoom.add(room1);
                    }

                    childMapping.put(listHotel.get(0), listRoom);
                    listAdapter = new MenuListAdapter(MainActivity.this, listHotel, childMapping);
                    expListView.setAdapter(listAdapter);
                    expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                                                            @Override
                                                            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                                                                Room selected = childMapping.get(listHotel.get(groupPosition)).get(childPosition);
                                                                Intent intent = new Intent(MainActivity.this, BuatPesananActivity.class);
                                                                intent.putExtra("id_customer", currentUserId);
                                                                intent.putExtra("nomorKamar", selected.getNomorKamar());
                                                                intent.putExtra("dailyTariff", selected.getDailyTariff());
                                                                intent.putExtra("id_hotel", listHotel.get(groupPosition).getID());
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
        RequestQueue queue = newRequestQueue(MainActivity.this);
        queue.add(menuRequest);
    }


}
