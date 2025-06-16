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

public class activity_registro extends AppCompatActivity {

    private EditText reg_usuario,reg_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        reg_usuario = findViewById(R.id.reg_usuario);
        reg_password = findViewById(R.id.reg_password);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void enviar(View view) {
        Intent i = new Intent(this,MainActivity.class);
        Intent i2 = new Intent(this,Activity_menu.class);
        i.putExtra("dato",reg_usuario.getText().toString());
        i.putExtra("dato2",reg_password.getText().toString());
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
}