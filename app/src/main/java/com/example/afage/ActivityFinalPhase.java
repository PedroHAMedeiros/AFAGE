package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityFinalPhase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_phase);

        Button buttonBackToMenu = findViewById(R.id.button_back_to_menu);
        buttonBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Voltar para o menu principal
                Intent intent = new Intent(ActivityFinalPhase.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
