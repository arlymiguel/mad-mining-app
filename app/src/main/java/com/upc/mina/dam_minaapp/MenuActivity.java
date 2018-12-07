package com.upc.mina.dam_minaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {


    LinearLayout llLocation,llConductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        llLocation = findViewById(R.id.btnLocalitation);
        llConductor = findViewById(R.id.btnPhone1);

        llLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,MachineLocationListActivity.class);
                startActivity(intent);
            }
        });

        llConductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,ConductoresActivity.class);
                startActivity(intent);
            }
        });

    }
}
