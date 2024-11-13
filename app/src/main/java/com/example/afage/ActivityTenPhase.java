package com.example.afage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityTenPhase extends AppCompatActivity {

    EditText editText1, editText2, editText3, editText4;
    Button buttonVerify;

    // Respostas corretas
    String[] correctAnswers = {"bolo", "dedo", "bola", "gelo"}; // Substitua pelos nomes corretos das imagens

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_phase);

        // Referenciar os campos de texto
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        buttonVerify = findViewById(R.id.button_verify);

        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });
    }

    private void checkAnswers() {
        EditText[] editTexts = {editText1, editText2, editText3, editText4};
        String[] userAnswers = {
                editText1.getText().toString().trim().toLowerCase(),
                editText2.getText().toString().trim().toLowerCase(),
                editText3.getText().toString().trim().toLowerCase(),
                editText4.getText().toString().trim().toLowerCase()
        };

        boolean isCorrect = true;

        // Verificar cada resposta e mudar a cor do texto para verde se estiver correto
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i].equals(correctAnswers[i])) {
                editTexts[i].setTextColor(Color.GREEN); // Muda a cor para verde se correto
            } else {
                editTexts[i].setTextColor(Color.RED); // Muda a cor para vermelho se incorreto
                isCorrect = false;
            }
        }

        // Mensagem de sucesso ou erro
        if (isCorrect) {
            Toast.makeText(this, "Parabéns, você acertou todas as respostas!", Toast.LENGTH_SHORT).show();
            // Avançar para a próxima fase (ajuste conforme necessário)
            startActivity(new Intent(ActivityTenPhase.this, ActivityElevenPhase.class));
        } else {
            Toast.makeText(this, "Algumas respostas estão incorretas. Tente novamente!", Toast.LENGTH_SHORT).show();
        }
    }
}
