package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_third_phase extends AppCompatActivity {

    private ImageView imageCentral;
    private Button buttonOption1, buttonOption2, buttonOption3, buttonOption4;
    private String correctAnswer = "APITO"; // Nome correto para esta fase

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_phase);

        imageCentral = findViewById(R.id.image_central);
        buttonOption1 = findViewById(R.id.button_option_1);
        buttonOption2 = findViewById(R.id.button_option_2);
        buttonOption3 = findViewById(R.id.button_option_3);
        buttonOption4 = findViewById(R.id.button_option_4);

        // Defina a imagem e os nomes das opções
        imageCentral.setImageResource(R.drawable.apito); // Adicione sua imagem
        buttonOption1.setText("BOLA");
        buttonOption2.setText("APITO");
        buttonOption3.setText("GELO");
        buttonOption4.setText("BOLO");

        // Configure listeners para os botões
        View.OnClickListener optionClickListener = v -> {
            Button clickedButton = (Button) v;
            String selectedOption = clickedButton.getText().toString();

            if (selectedOption.equals(correctAnswer)) {
                Toast.makeText(activity_third_phase.this, "Correto! Próxima fase.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(activity_third_phase.this, ActivityQuatroPhase.class));
            } else {
                Toast.makeText(activity_third_phase.this, "Tente novamente!", Toast.LENGTH_SHORT).show();
            }
        };

        buttonOption1.setOnClickListener(optionClickListener);
        buttonOption2.setOnClickListener(optionClickListener);
        buttonOption3.setOnClickListener(optionClickListener);
        buttonOption4.setOnClickListener(optionClickListener);
    }
}
