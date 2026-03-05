package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Usar el 'cardCourse' (que en tu XML es el botón de buscar) para ir a Despliegue
        MaterialCardView cardBuscar = findViewById(R.id.btnPlayCourse);
        if (cardBuscar != null) {
            cardBuscar.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Despliegue.class);
                startActivity(intent);
            });
        }

        // 2. Usar el botón de calendario para ir a Calendario
        ImageView btnCalendario = findViewById(R.id.btnCalendario);
        if (btnCalendario != null) {
            btnCalendario.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Calendario.class);
                startActivity(intent);
            });
        }
    }
}