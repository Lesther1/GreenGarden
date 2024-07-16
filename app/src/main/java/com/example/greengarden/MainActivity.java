package com.example.greengarden;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Datos datos;
    public TextView tvTotalArboles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        datos = new Datos();
        tvTotalArboles = findViewById(R.id.total_arboles);

        ImageView nuevo = findViewById(R.id.btn_nuevo_arbol);
        nuevo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TreeActivity.class);
                    startActivity(intent);
                }
            });

        ImageView concejos = findViewById(R.id.btn_concejos);
        concejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConcejosActivity.class);
                startActivity(intent);
            }
        });

        ImageView lista = findViewById(R.id.btn_mis_arboles);
        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MisArbolesActivity.class);
                startActivity(intent);
            }
        });

        ImageView codos = findViewById(R.id.btn_codos);
        codos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Co2Activity.class);
                startActivity(intent);
            }
        });
        ConsultaTotalArboles();
    }

    public void ConsultaTotalArboles() {
        int totalArboles = datos.Total();
        tvTotalArboles.setText("Llevas un total de " + totalArboles + " arboles plantados ");
    }
}