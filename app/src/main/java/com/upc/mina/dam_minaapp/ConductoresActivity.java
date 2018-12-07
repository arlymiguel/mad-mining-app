package com.upc.mina.dam_minaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.upc.mina.dam_minaapp.adapter.ConductorAdapter;
import com.upc.mina.dam_minaapp.adapter.ConductoresAdapter;
import com.upc.mina.dam_minaapp.model.Conductores;
import com.upc.mina.dam_minaapp.model.Vehiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConductoresActivity extends AppCompatActivity {

    ListView listViewConductores;
    ImageView imvPhone , imvMensage;
    List<Conductores> conductores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductores);
        listViewConductores = findViewById(R.id.lstConductores);
        imvPhone = findViewById(R.id.iconPhone);
        imvMensage = findViewById(R.id.iconMessage);

        ServicesImp service = RetrofitInstance.getRetrofitInstance().create(ServicesImp.class);
        Call<List<Conductores>> call = service.conductores();
        call.enqueue(new Callback<List<Conductores>>() {
            @Override
            public void onResponse(Call<List<Conductores>> call, Response<List<Conductores>> response) {
                conductores = response.body();
//                ConductoresAdapter conductoresAdapter = new ConductoresAdapter(ConductoresActivity.this,conductores);
                ConductorAdapter conductoresAdapter = new ConductorAdapter(ConductoresActivity.this,conductores);
                listViewConductores.setAdapter(conductoresAdapter);
            }

            @Override
            public void onFailure(Call<List<Conductores>> call, Throwable t) {
                Toast.makeText(ConductoresActivity.this,"ERROR",Toast.LENGTH_LONG).show();
                Toast.makeText(ConductoresActivity.this,"ok",Toast.LENGTH_LONG).show();
            }
        });

    }
}
