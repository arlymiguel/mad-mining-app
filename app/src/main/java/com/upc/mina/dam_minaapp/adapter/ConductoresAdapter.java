package com.upc.mina.dam_minaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.upc.mina.dam_minaapp.R;
import com.upc.mina.dam_minaapp.model.Conductores;

import java.util.List;

public class ConductoresAdapter extends ArrayAdapter<Conductores> {

    List<Conductores> conductores;

    public ConductoresAdapter( Context context, List<Conductores> conductores) {
        super(context, 0,conductores);
        this.conductores = conductores;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Conductores conductores = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_conductor, parent, false);
        }
        TextView tvNombre =  convertView.findViewById(R.id.txtNombre);
        TextView tvRol = convertView.findViewById(R.id.txtRol);

        tvNombre.setText(conductores.getName()+" "+conductores.getLastname());
        tvRol.setText(conductores.getRole());

        return convertView;
    }

}
