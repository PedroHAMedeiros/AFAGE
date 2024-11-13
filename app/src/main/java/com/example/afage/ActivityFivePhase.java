package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityFivePhase extends AppCompatActivity {

    private EditText editTextTipo1, editTextTipo2;
    private Button buttonCheckAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_phase);

        editTextTipo1 = findViewById(R.id.editText_tipo1);
        editTextTipo2 = findViewById(R.id.editText_tipo2);
        buttonCheckAnswer = findViewById(R.id.button_check_answer);

        buttonCheckAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        String tipo1Count = editTextTipo1.getText().toString();
        String tipo2Count = editTextTipo2.getText().toString();

        if (tipo1Count.equals("4") && tipo2Count.equals("5")) {
            Toast.makeText(this, "Resposta correta! Indo para a próxima fase!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ActivityFivePhase.this, ActivitySixPhase.class));
        } else {
            Toast.makeText(this, "Tente novamente!", Toast.LENGTH_SHORT).show();
        }
    }
}
