package com.upc.mina.dam_minaapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.upc.mina.dam_minaapp.R;
import com.upc.mina.dam_minaapp.model.Conductores;

import java.util.List;

public class ConductorAdapter extends BaseAdapter {

    private Context context;
    private List<Conductores> conductores;

    public ConductorAdapter(Context context, List<Conductores> conductores) {
        this.context = context;
        this.conductores = conductores;
    }

    @Override
    public int getCount() {
        return conductores.size();
    }

    @Override
    public Object getItem(int position) {
        return conductores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return conductores.get(position).getId();
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_conductor, null, true);

            holder.nombre = view.findViewById(R.id.txtNombre);
            holder.rol = view.findViewById(R.id.txtRol);
            holder.phone = view.findViewById(R.id.iconPhone);
            holder.menssage = view.findViewById(R.id.iconMessage);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.nombre.setText(conductores.get(position).getName() + " " + conductores.get(position).getLastname());
        holder.rol.setText(conductores.get(position).getRole());
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = conductores.get(position).getPhonenumber();
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(context, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.menssage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = conductores.get(position).getPhonenumber();
                if(!TextUtils.isEmpty(phoneNo)) {
                    Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNo));
                    context.startActivity(smsIntent);
                }
            }
        });

        return view;
    }

    class ViewHolder{
        TextView nombre,rol;
        ImageView phone,menssage;
    }
}
