package com.example.thunder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.net.Uri;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private EditText txt_password,txt_usuario;
    private String datoUsuarioRecibido,dato2PasswordRecibido;

    private ImageButton Github, Whatsapp, Autonoma;
    private  final static String GITHUB_URL ="https://github.com/Viruz7w7/thunderRAR";
    private  final static String WHATSAPP_URL ="https://wa.me/929470345";
    private  final static String AUTONOMA_URL ="https://www.autonoma.pe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txt_usuario = findViewById(R.id.txt_usuario);
        txt_password = findViewById(R.id.txt_password);

        datoUsuarioRecibido = getIntent().getStringExtra("dato");
        dato2PasswordRecibido = getIntent().getStringExtra("dato2");

        Github = findViewById(R.id.btGithub);
        Whatsapp = findViewById(R.id.btWhatsapp);
        Autonoma = findViewById(R.id.btAutonoma);

        Github.setOnClickListener(this);
        Whatsapp.setOnClickListener(this);
        Autonoma.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String urlToOpen = null;
        int viewId = v.getId();
        if (viewId == R.id.btGithub){
            urlToOpen = GITHUB_URL;
        }else if (viewId == R.id.btWhatsapp){
            urlToOpen = WHATSAPP_URL;
        }else if (viewId == R.id.btAutonoma){
            urlToOpen = AUTONOMA_URL;
        }
        if (urlToOpen != null){
            intent.setData(Uri.parse(urlToOpen));
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }else{
                Toast.makeText(this, "No se puede abrir el navegador", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
