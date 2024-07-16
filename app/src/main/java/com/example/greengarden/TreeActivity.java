package com.example.greengarden;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class TreeActivity extends AppCompatActivity {
    private Datos datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tree);

        datos = new Datos();
        String[] items = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        Spinner spinner = findViewById(R.id.spiner_mes_form);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button plantar = findViewById(R.id.btn_plantar);
        plantar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fecha = findViewById(R.id.et_fecha_plantacion);
                EditText especie = findViewById(R.id.et_especia);
                EditText ubicacion = findViewById(R.id.et_ubicacion);
                EditText salud = findViewById(R.id.et_salud);
                String mes = spinner.getSelectedItem().toString();

                String fechaPlantacion = fecha.getText().toString();
                String especieArbol = especie.getText().toString();
                String ubicacionArbol = ubicacion.getText().toString();
                String saludArbol = salud.getText().toString();

                datos.agregarDatosArbol(mes, fechaPlantacion, especieArbol, ubicacionArbol, saludArbol);

                Toast.makeText(TreeActivity.this, "Datos del árbol guardados", Toast.LENGTH_SHORT).show();
            }
        });


        Button volver = findViewById(R.id.btn_volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TreeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}