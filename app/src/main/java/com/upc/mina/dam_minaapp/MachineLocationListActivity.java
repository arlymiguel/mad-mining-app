package com.upc.mina.dam_minaapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.upc.mina.dam_minaapp.adapter.MachineAdapter;
import com.upc.mina.dam_minaapp.adapter.VehiculoAdapter;
import com.upc.mina.dam_minaapp.model.Machine;
import com.upc.mina.dam_minaapp.model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MachineLocationListActivity extends AppCompatActivity {

    ListView lvMachineList;

    private List<Vehiculo> vehiculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_location_list);

        lvMachineList = findViewById(R.id.machineList);

        ServicesImp service = RetrofitInstance.getRetrofitInstance().create(ServicesImp.class);
        Call<List<Vehiculo>> call = service.vehiculos();

        call.enqueue(new Callback<List<Vehiculo>>() {
            @Override
            public void onResponse(Call<List<Vehiculo>> call, Response<List<Vehiculo>> response) {
                vehiculos = response.body();
                VehiculoAdapter vehiculoAdapter = new VehiculoAdapter(MachineLocationListActivity.this,vehiculos);
                lvMachineList.setAdapter(vehiculoAdapter);
            }

            @Override
            public void onFailure(Call<List<Vehiculo>> call, Throwable t) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MachineLocationListActivity.this);
                alertDialogBuilder.setMessage("ERROR CON EL SERVICIO")
                        .setCancelable(false)
                        .setTitle("ERROR")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }
}
