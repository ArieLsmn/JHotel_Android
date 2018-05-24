package com.example.arialesmana.jhotel_android_arialesmana;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.*;


public class BuatPesananActivity extends AppCompatActivity {

    private int currentUserId,banyakHari,idHotel;
    private double tariff;
    private String roomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_pesanan);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b!=null){
            currentUserId = b.getInt("id_customer");
            idHotel = b.getInt("id_hotel");
            tariff = b.getDouble("dailyTariff");
            roomNumber = b.getString("nomorKamar");
        }
        final TextView roomNumberText = (TextView) findViewById(R.id.room_number);
        final TextView tariffText = (TextView) findViewById(R.id.tariff);
        final TextView totalText = (TextView) findViewById(R.id.total_biaya);
        final EditText durasiInput = (EditText) findViewById(R.id.durasi_hari);
        final Button pesanButton = (Button) findViewById(R.id.pesan);
        final Button hitungButton = (Button) findViewById(R.id.hitung);

        pesanButton.setVisibility(View.INVISIBLE);
        roomNumberText.setText(roomNumber);
        tariffText.setText(String.valueOf(tariff));
        totalText.setText("0");
        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                banyakHari = Integer.parseInt(durasiInput.getText().toString());
                totalText.setText(String.valueOf(tariff*banyakHari));
                pesanButton.setVisibility(View.VISIBLE);
                hitungButton.setVisibility(View.INVISIBLE);
            }
        });

        pesanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                final String jumlah_hari = String.valueOf(banyakHari);
                final String id_customer = String.valueOf(currentUserId);
                final String id_hotel = String.valueOf(idHotel);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            if (jsonResponse != null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(BuatPesananActivity.this);
                                builder.setMessage("Pesanan Success").create().show();
                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(BuatPesananActivity.this);
                            builder.setMessage("Pesanan Failed.").create().show();
                        }
                    }
                };
                BuatPesananRequest pesananRequest = new BuatPesananRequest(jumlah_hari, id_customer, id_hotel, roomNumber, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BuatPesananActivity.this);
                queue.add(pesananRequest);
            }
        });
    }
}

/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_pesanan);

        Intent passInt = getIntent();
        Bundle passBun = passInt.getExtras();
        if(passBun!=null){
            currentUserId = passBun.getInt("id_customer");
            idHotel = passBun.getInt("id_hotel");
            tariff = passBun.getDouble("dailyTariff");
            roomNumber = passBun.getString("nomorKamar");
        }

        final TextView roomNumberText = (TextView) findViewById(R.id.room_number);
        final TextView tariffText = (TextView) findViewById(R.id.tariff);
        final TextView totalText = (TextView) findViewById(R.id.total_biaya);
        final EditText durasiInput = (EditText) findViewById(R.id.durasi_hari);
        final Button pesanButton = (Button) findViewById(R.id.pesan);
        final Button hitungButton = (Button) findViewById(R.id.hitung);

        roomNumberText.setText(roomNumber);
        tariffText.setText(String.valueOf(tariff));
        totalText.setText(0);
        pesanButton.setVisibility(View.GONE);



        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                banyakHari = Integer.parseInt(durasiInput.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        double total = banyakHari * tariff;
                        totalText.setText(String.valueOf(total));
                        hitungButton.setVisibility(View.GONE);
                        pesanButton.setVisibility(View.VISIBLE);
                    }
                };
            }
        });
        pesanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                final String durasiHari = durasiInput.getText().toString();
                final String id_customer = String.valueOf(currentUserId);
                final String id_hotel = String.valueOf(idHotel);
                final String nomorKamar = roomNumber;

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            if (jsonResponse != null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(BuatPesananActivity.this);
                                builder.setMessage("Pesanan Success").create().show();
                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(BuatPesananActivity.this);
                            builder.setMessage("Pesanan Failed.").create().show();
                        }
                    }
                };
                BuatPesananRequest pesanRequest = new BuatPesananRequest(durasiHari, id_customer, id_hotel, nomorKamar, responseListener);
                RequestQueue queue = Volley.newRequestQueue(BuatPesananActivity.this);
                queue.add(pesanRequest);
            }
        });
    }
}*/