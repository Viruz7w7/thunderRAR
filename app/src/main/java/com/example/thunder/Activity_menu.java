package com.example.thunder;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void men_venta(View view){
        Toast.makeText(this, "para la siguiente actualizacion", Toast.LENGTH_SHORT).show();
    }
    public void men_comunidad(View view){
        Toast.makeText(this, "para la siguiente actualizacion", Toast.LENGTH_SHORT).show();
    }
    public void men_logistica(View view){
        Toast.makeText(this, "para la siguiente actualizacion", Toast.LENGTH_SHORT).show();
    }
    public void men_reporte(View view){
        Toast.makeText(this, "para la siguiente actualizacion", Toast.LENGTH_SHORT).show();
    }
}