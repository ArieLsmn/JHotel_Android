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
    private int currentUserId, banyakHari = 0, idHotel;
    private double tariff = 0;
    private String roomNumber = " ";

    @Override
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
                final int durasiHari = Integer.parseInt(durasiInput.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        double total = durasiHari * tariff;
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
                final int durasiHari = Integer.parseInt(durasiInput.getText().toString());

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
                BuatPesananRequest pesananRequest = new BuatPesananRequest(String.valueOf(durasiHari),responseListener);
                RequestQueue queue = Volley.newRequestQueue(BuatPesananActivity.this);
                queue.add(pesananRequest);
            }
        });
    }
}