package com.upc.mina.dam_minaapp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.upc.mina.dam_minaapp.R;
import com.upc.mina.dam_minaapp.model.Machine;

import java.util.ArrayList;
import java.util.List;

public class MachineAdapter extends ArrayAdapter<Machine> {

    public MachineAdapter(Context context, List<Machine> machines) {
       super(context, 0, machines);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Machine user = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_machine, parent, false);
        }
        TextView tvPlaca = (TextView) convertView.findViewById(R.id.txtPlaca);
//        TextView tvPiloto = (TextView) convertView.findViewById(R.id.txtPiloto);
        tvPlaca.setText(user.getPlaca());
//        tvPiloto.setText(user.getPiloto());
        return convertView;
   }
}