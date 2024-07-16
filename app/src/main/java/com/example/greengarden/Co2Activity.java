package com.example.greengarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Co2Activity extends AppCompatActivity {
    private Datos datos;
    private TextView tvCo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_co2);
        datos = new Datos();
        inicializarDatos();

        String[] items = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        Spinner spinner = findViewById(R.id.spiner_mes_form);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        tvCo2 = findViewById(R.id.tv_co2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mesSeleccionado = (String) parent.getItemAtPosition(position);
                mostrarCo2PorMes(mesSeleccionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mostrarCo2PorMes("Enero");
            }
        });
        Button volver = findViewById(R.id.btn_volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Co2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void mostrarCo2PorMes(String mes) {
        double co2Producido = datos.calcularCO2PorMes(mes);
        tvCo2.setText("CO2 absorbido en " + mes + ": " + co2Producido + " kg");
    }

    private void inicializarDatos() {
        datos.agregarDatosArbol("Enero", "2024-01-15", "Roble", "Parque", "Buena");
        datos.agregarDatosArbol("Febrero", "2024-02-20", "Pino", "Jardín", "Regular");
        datos.agregarDatosArbol("Enero", "2024-01-25", "Cerezo", "Bosque", "Excelente");
    }
}