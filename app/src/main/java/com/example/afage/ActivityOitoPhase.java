package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityOitoPhase extends AppCompatActivity {

    private EditText editTextImage1, editTextImage2, editTextImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oito_phase);

        // Referências aos campos de entrada
        editTextImage1 = findViewById(R.id.editText_image_1_oito);
        editTextImage2 = findViewById(R.id.editText_image_2_oito);
        editTextImage3 = findViewById(R.id.editText_image_3_oito);

        Button buttonVerify = findViewById(R.id.button_verify_oito);
        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRespostas();
            }
        });
    }

    private void verificarRespostas() {
        String resposta1 = editTextImage1.getText().toString();
        String resposta2 = editTextImage2.getText().toString();
        String resposta3 = editTextImage3.getText().toString();

        if (resposta1.equals("2") && resposta2.equals("1") && resposta3.equals("3")) {
            Toast.makeText(this, "Parabéns, você acertou!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ActivityOitoPhase.this, ActivityNinePhase.class));
        } else {
            Toast.makeText(this, "Tente novamente!", Toast.LENGTH_SHORT).show();
        }
    }
}
