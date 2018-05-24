package com.example.arialesmana.jhotel_android_arialesmana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RoomDetailActivity extends AppCompatActivity {
    private int currentUserId;
    private double tariff;
    private String roomNumber;
    private String status;
    private String tipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b!=null){
            currentUserId = b.getInt("id_customer");
            tariff = b.getDouble("dailyTariff");
            roomNumber = b.getString("nomorKamar");
            status = b.getString("statusKamar");
            tipe = b.getString("tipeKamar");
        }

        final TextView room_number = (TextView) findViewById(R.id.room_number);
        final TextView tarif = (TextView) findViewById(R.id.tariff);
        final TextView statusKamar = (TextView) findViewById(R.id.statusKamarText);
        final TextView tipeKamar = (TextView) findViewById(R.id.tipeKamarText);


        tarif.setText(String.valueOf(tariff));
        room_number.setText(roomNumber);
        statusKamar.setText(status);
        tipeKamar.setText(tipe);
    }
}
