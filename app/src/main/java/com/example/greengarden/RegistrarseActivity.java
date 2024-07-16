package com.example.greengarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrarseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrarse);

        EditText correo = findViewById(R.id.et_correo);
        EditText pass = findViewById(R.id.et_pass);
        EditText nombre = findViewById(R.id.et_nombre);
        Button registro = findViewById(R.id.btn_registrarse);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correoTexto = correo.getText().toString();
                String passTexto = pass.getText().toString();
                String nombreTexto = pass.getText().toString();

                if (correoTexto.isEmpty() || passTexto.isEmpty()) {
                    Toast.makeText(RegistrarseActivity.this, "Por favor, complete todos campos", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(RegistrarseActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button iniciar = findViewById(R.id.btn_iniciar);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrarseActivity.this, LoginActivity.class);
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