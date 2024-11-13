package com.example.afage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityElevenPhase extends AppCompatActivity {

    EditText editText1, editText2, editText3;
    Button buttonVerify;

    // Frases corretas que o jogador deve escrever
    String[] correctPhrases = {
            "O CACHORRO LATIU PARA O GATO",
            "O MENINO BRINCAVA COM A BOLA",
            "A LUA BRILHA NO ALTO"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven_phase);

        // Referenciar os campos de texto
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        buttonVerify = findViewById(R.id.button_verify);

        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPhrases();
            }
        });
    }

    private void checkPhrases() {
        EditText[] editTexts = {editText1, editText2, editText3};
        String[] userPhrases = {
                editText1.getText().toString().trim().toUpperCase(),
                editText2.getText().toString().trim().toUpperCase(),
                editText3.getText().toString().trim().toUpperCase()
        };

        boolean allCorrect = true;

        for (int i = 0; i < correctPhrases.length; i++) {
            if (userPhrases[i].equals(correctPhrases[i])) {
                editTexts[i].setTextColor(Color.GREEN); // Se a frase estiver correta, fica verde
            } else {
                editTexts[i].setTextColor(Color.RED); // Se estiver errada, fica vermelha
                allCorrect = false;
            }
        }

        if (allCorrect) {
            Toast.makeText(this, "Parabéns! Todas as frases estão corretas!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ActivityElevenPhase.this, ActivityDozePhase.class));
        } else {
            Toast.makeText(this, "Algumas frases estão incorretas. Tente novamente!", Toast.LENGTH_SHORT).show();
        }
    }
}
