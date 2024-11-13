package com.example.afage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityDozePhase extends AppCompatActivity {

    // Declaração das variáveis
    TextView frase1, frase2, frase3;
    EditText resposta1, resposta2, resposta3;
    Button buttonVerify;

    // Frases corretas (sem "ç" e acentos)
    String[] correctPhrases = {
            "o quarto precisa ser limpo",
            "coma a comida na mesa",
            "vamos comer a sobremesa"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doze_phase);

        // Referenciar os elementos do layout
        frase1 = findViewById(R.id.textViewFrase1);
        frase2 = findViewById(R.id.textViewFrase2);
        frase3 = findViewById(R.id.textViewFrase3);

        resposta1 = findViewById(R.id.editTextResposta1);
        resposta2 = findViewById(R.id.editTextResposta2);
        resposta3 = findViewById(R.id.editTextResposta3);

        buttonVerify = findViewById(R.id.button_verify);

        // Definir as frases no TextView
        frase1.setText("O QUARTO PRECISA SER LIMPO");
        frase2.setText("COMA A COMIDA NA MESA");
        frase3.setText("VAMOS COMER A SOBREMESA");

        // Verificar respostas ao clicar no botão
        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
    }

    private void checkAnswers() {
        // Obter respostas do usuário
        String[] userAnswers = {
                resposta1.getText().toString().trim(),
                resposta2.getText().toString().trim(),
                resposta3.getText().toString().trim()
        };

        EditText[] editTexts = {resposta1, resposta2, resposta3};
        boolean isCorrect = true;

        // Verificar cada resposta e mudar a cor para verde se estiver correta
        for (int i = 0; i < correctPhrases.length; i++) {
            if (userAnswers[i].equalsIgnoreCase(correctPhrases[i])) {
                editTexts[i].setTextColor(Color.GREEN);
            } else {
                editTexts[i].setTextColor(Color.RED);
                isCorrect = false;
            }
        }

        // Mensagem de sucesso ou erro
        if (isCorrect) {
            Toast.makeText(this, "Parabens, voce acertou todas as frases!", Toast.LENGTH_SHORT).show();
            // Avançar para a próxima fase, se existir
            startActivity(new Intent(ActivityDozePhase.this, ActivityDozePhase.class)); // Ajuste conforme necessário
        } else {
            Toast.makeText(this, "Algumas respostas estao incorretas. Tente novamente!", Toast.LENGTH_SHORT).show();
        }
    }
}
