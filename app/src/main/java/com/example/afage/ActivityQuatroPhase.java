package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityQuatroPhase extends AppCompatActivity {

    private ImageView imageMain;
    private Button buttonOption1, buttonOption2, buttonOption3, buttonOption4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quatro_phase);

        imageMain = findViewById(R.id.image_main_quatro);
        buttonOption1 = findViewById(R.id.button_option1_quatro);
        buttonOption2 = findViewById(R.id.button_option2_quatro);
        buttonOption3 = findViewById(R.id.button_option3_quatro);
        buttonOption4 = findViewById(R.id.button_option4_quatro);

        // Configurar a resposta correta (exemplo: a resposta correta é o botão 4)
        final Button correctButton = buttonOption4;
        setButtonListeners(correctButton);
    }

    private void setButtonListeners(final Button correctButton) {
        View.OnClickListener listener = v -> {
            if (v == correctButton) {
                startActivity(new Intent(ActivityQuatroPhase.this, ActivityFivePhase.class));
                Toast.makeText(this, "Resposta correta!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Tente novamente!", Toast.LENGTH_SHORT).show();
            }
        };

        buttonOption1.setOnClickListener(listener);
        buttonOption2.setOnClickListener(listener);
        buttonOption3.setOnClickListener(listener);
        buttonOption4.setOnClickListener(listener);
    }
}
