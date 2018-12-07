package com.upc.mina.dam_minaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.upc.mina.dam_minaapp.R;
import com.upc.mina.dam_minaapp.model.Vehiculo;

import java.util.List;

public class VehiculoAdapter extends ArrayAdapter<Vehiculo> {

    private List<Vehiculo> vehiculos;

    public VehiculoAdapter( Context context, List<Vehiculo> vehiculos) {
        super(context, 0,vehiculos);
        this.vehiculos = vehiculos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Vehiculo vehiculo = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_machine, parent, false);
        }
        TextView tvPlaca =  convertView.findViewById(R.id.txtPlaca);
        TextView tvModelo = convertView.findViewById(R.id.txtModelo);

        tvPlaca.setText(vehiculo.getPlate().toString());
        tvModelo.setText(vehiculo.getModel().toString());

        return convertView;
    }
}
