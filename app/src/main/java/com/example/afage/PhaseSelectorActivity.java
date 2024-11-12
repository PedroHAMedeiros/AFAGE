package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class PhaseSelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase_selector);

        // Configurando os botões para cada fase
        Button buttonPhase1 = findViewById(R.id.button_phase1);
        Button buttonPhase2 = findViewById(R.id.button_phase2);
        Button buttonPhase3 = findViewById(R.id.button_phase3);
        Button buttonPhase4 = findViewById(R.id.button_phase4);
        Button buttonPhase5 = findViewById(R.id.button_phase5);
        Button buttonPhase6 = findViewById(R.id.button_phase6);
        Button buttonPhase7 = findViewById(R.id.button_phase7);
        Button buttonPhase8 = findViewById(R.id.button_phase8);

        // Ir para Fase 1
        buttonPhase1.setOnClickListener(v -> {
            Intent intent = new Intent(PhaseSelectorActivity.this, MainActivity2.class);
            startActivity(intent);
        });

        // Ir para Fase 2
        buttonPhase2.setOnClickListener(v -> {
            Intent intent = new Intent(PhaseSelectorActivity.this, NextPhaseActivity.class);
            startActivity(intent);
        });

        // Ir para Fase 3
        buttonPhase3.setOnClickListener(v -> {
            Intent intent = new Intent(PhaseSelectorActivity.this, activity_third_phase.class);
            startActivity(intent);
        });

        // Ir para Fase 4
        buttonPhase4.setOnClickListener(v -> {
            Intent intent = new Intent(PhaseSelectorActivity.this, ActivityQuatroPhase.class);
            startActivity(intent);
        });

        // Ir para Fase 5
        buttonPhase5.setOnClickListener(v -> {
            Intent intent = new Intent(PhaseSelectorActivity.this, ActivityFivePhase.class);
            startActivity(intent);
        });
        // Ir para Fase 6
        buttonPhase6.setOnClickListener(v -> {
            Intent intent = new Intent(PhaseSelectorActivity.this, ActivitySixPhase.class);
            startActivity(intent);
        });
        // Ir para Fase 7
        buttonPhase7.setOnClickListener(v -> {
            Intent intent = new Intent(PhaseSelectorActivity.this, ActivitySevenPhase.class);
            startActivity(intent);
        });
        // Ir para Fase 8
        buttonPhase8.setOnClickListener(v -> {
            Intent intent = new Intent(PhaseSelectorActivity.this, ActivityOitoPhase.class);
            startActivity(intent);
        });

    }
}
