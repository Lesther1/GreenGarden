package com.example.greengarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MisArbolesActivity extends AppCompatActivity {
    private Datos datos;
    private ListView listaArboles;
    private ArrayAdapter<String> arbolesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mis_arboles);
        datos = new Datos();
        inicializarDatos();

        String[] items = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        Spinner spinner = findViewById(R.id.spiner_mes_form);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        listaArboles = findViewById(R.id.lista_arboles);
        arbolesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        listaArboles.setAdapter(arbolesAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mesSeleccionado = (String) parent.getItemAtPosition(position);
                mostrarArbolesPorMes(mesSeleccionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada
            }
        });

        Button volver = findViewById(R.id.btn_volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MisArbolesActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void mostrarArbolesPorMes(String mes) {
        List<Object[]> arbolesPorMes = datos.obtenerArbolesPorMes(mes);
        List<String> arbolesInfo = new ArrayList<>();
        for (Object[] arbol : arbolesPorMes) {
            String info = "Fecha: " + arbol[1] + ", Especie: " + arbol[2] + ", Ubicación: " + arbol[3] + ", Salud: " + arbol[4];
            arbolesInfo.add(info);
        }
        arbolesAdapter.clear();
        arbolesAdapter.addAll(arbolesInfo);
        arbolesAdapter.notifyDataSetChanged();
    }

    private void inicializarDatos() {
        datos.agregarDatosArbol("Enero", "2024-01-15", "Roble", "Parque", "Buena");
        datos.agregarDatosArbol("Febrero", "2024-02-20", "Pino", "Jardín", "Regular");
        datos.agregarDatosArbol("Enero", "2024-01-25", "Cerezo", "Bosque", "Excelente");
    }
}