package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referência ao botão de início pelo ID
        Button startButton = findViewById(R.id.button_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        // Referência ao botão de Selecionador de Fases
        Button phaseSelectorButton = findViewById(R.id.button_phase_selector);
        phaseSelectorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciando a atividade do seletor de fases
                Intent intent = new Intent(MainActivity.this, PhaseSelectorActivity.class);
                startActivity(intent);
            }
        });
    }
}
