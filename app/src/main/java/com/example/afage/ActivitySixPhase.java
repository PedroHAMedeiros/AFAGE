package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitySixPhase extends AppCompatActivity {

    private EditText editTextTipo1;
    private EditText editTextTipo2;
    private Button buttonVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six_phase);

        editTextTipo1 = findViewById(R.id.editText_tipo1_count);
        editTextTipo2 = findViewById(R.id.editText_tipo2_count);
        buttonVerify = findViewById(R.id.button_verify);

        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tipo1Count = editTextTipo1.getText().toString();
                String tipo2Count = editTextTipo2.getText().toString();

                if (tipo1Count.equals("3") && tipo2Count.equals("2")) {
                    Toast.makeText(ActivitySixPhase.this, "Correto! Avançando para a próxima fase.", Toast.LENGTH_SHORT).show();
                    // Próxima fase (ou fim do jogo)
                } else {
                    Toast.makeText(ActivitySixPhase.this, "Tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
