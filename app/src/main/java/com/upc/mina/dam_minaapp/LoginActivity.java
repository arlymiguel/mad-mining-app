package com.upc.mina.dam_minaapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText txtUser;
    private TextInputEditText txtPassword;
    private Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = findViewById(R.id.txtEdt_usuario);
        txtPassword = findViewById(R.id.txtEdt_contraseña);
        btnEnter = findViewById(R.id.btnIngresar);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
                startActivity(intent);*/

                String usuario = txtUser.getText().toString();
                String contraseña = txtPassword.getText().toString();

                ServicesImp service = RetrofitInstance.getRetrofitInstance().create(ServicesImp.class);
                Call<String> call = service.login(usuario,contraseña);

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoginActivity.this);
                        alertDialogBuilder.setMessage("CREDENCIALES INVALIDAS")
                                .setCancelable(false)
                                .setTitle("ERROR")
                                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        txtUser.setText("");
                                        txtPassword.setText("");
                                    }
                                });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                });


            }
        });

    }


}
