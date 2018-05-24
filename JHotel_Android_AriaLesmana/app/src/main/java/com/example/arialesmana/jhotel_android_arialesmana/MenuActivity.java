package com.example.arialesmana.jhotel_android_arialesmana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private int currentUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b!=null){
            currentUserId = b.getInt("id_customer");
        }

        final Button roomClick = (Button) findViewById(R.id.infoRoom);
        final Button pesanClick = (Button) findViewById(R.id.pesan);
        final Button hotelClick = (Button) findViewById(R.id.hotel);

        roomClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent roomInt = new Intent(MenuActivity.this, RoomActivity.class);
                roomInt.putExtra("id_customer", currentUserId);
                MenuActivity.this.startActivity(roomInt);
            }
        });
        hotelClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotelInt = new Intent(MenuActivity.this, HotelActivity.class);
                hotelInt.putExtra("id_customer", currentUserId);
                MenuActivity.this.startActivity(hotelInt);
            }
        });
        pesanClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainInt = new Intent(MenuActivity.this, MainActivity.class);
                mainInt.putExtra("id_customer", currentUserId);
                MenuActivity.this.startActivity(mainInt);
            }
        });

    }
}


