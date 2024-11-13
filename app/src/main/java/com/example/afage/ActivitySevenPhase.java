package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitySevenPhase extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button buttonVerify;

    // Respostas corretas para as imagens
    int[] correctAnswers = {1, 2, 3}; // Assumindo que a imagem1 é 1, imagem2 é 2, e imagem3 é 3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven_phase);

        // Referenciar os campos de texto
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        buttonVerify = findViewById(R.id.button_verify);

        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
    }

    private void checkAnswers() {
        try {
            int[] userAnswers = {
                    Integer.parseInt(editText1.getText().toString()),
                    Integer.parseInt(editText2.getText().toString()),
                    Integer.parseInt(editText3.getText().toString())
            };

            boolean isCorrect = true;
            for (int i = 0; i < correctAnswers.length; i++) {
                if (userAnswers[i] != correctAnswers[i]) {
                    isCorrect = false;
                    break;
                }
            }

            if (isCorrect) {
                // Se todas as respostas estiverem corretas, avançar para a ActivityOitoPhase
                Toast.makeText(this, "Parabéns, você acertou!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ActivitySevenPhase.this, ActivityOitoPhase.class));
            } else {
                // Mensagem para respostas incorretas
                Toast.makeText(this, "Algumas respostas estão incorretas. Tente novamente!", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, preencha todos os campos com números válidos.", Toast.LENGTH_SHORT).show();
        }
    }
}
