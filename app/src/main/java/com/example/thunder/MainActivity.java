package com.example.thunder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txt_password,txt_usuario;
    private String datoUsuarioRecibido,dato2PasswordRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txt_usuario = findViewById(R.id.txt_usuario);
        txt_password = findViewById(R.id.txt_password);

        datoUsuarioRecibido = getIntent().getStringExtra("dato");
        dato2PasswordRecibido = getIntent().getStringExtra("dato2");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //metodo para iniciar sesion
    public void inicioSesion (View view){
        String datoUsuario = txt_usuario.getText().toString();
        String datoPassword = txt_password.getText().toString();
        if (datoUsuarioRecibido == null || dato2PasswordRecibido == null){
            Toast.makeText(this, "Datos de registro no encontrados,registrase", Toast.LENGTH_SHORT).show();
            return;
        }
        if (datoUsuario.isEmpty()||datoPassword.isEmpty()){
            Toast.makeText(this, "ingrese su usuario y contraseña", Toast.LENGTH_SHORT).show();
            return;
        }
        if (datoUsuario.equals(datoUsuarioRecibido)&&datoPassword.equals(dato2PasswordRecibido)){

            Intent ini = new Intent(this,Activity_menu.class);
            startActivity(ini);
        }else{
            Toast.makeText(this, "usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para registrarse
    public void registro (View view){
        Intent reg = new Intent(this,activity_registro.class);
        startActivity(reg);
    }
    //metodo para cliente
    public void cliente (View view){
        Intent cli = new Intent(this, activity_cliente.class);
        startActivity(cli);
    }
}
