package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextUrso, editTextUrubu, editTextOculos, editTextEstrela, editTextEspelho, editTextAviao;
    private Button buttonNextPhase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Acessar os EditTexts
        editTextUrso = findViewById(R.id.editText_urso);
        editTextUrubu = findViewById(R.id.editText_urubu);
        editTextOculos = findViewById(R.id.editText_oculos);
        editTextEstrela = findViewById(R.id.editText_estrela);
        editTextEspelho = findViewById(R.id.editText_espelho);
        editTextAviao = findViewById(R.id.editText_aviao);

        // Acessar o botão de próxima fase
        buttonNextPhase = findViewById(R.id.button_next_phase);
        buttonNextPhase.setEnabled(false); // Inicia desativado

        // Adicionar TextWatcher a cada EditText
        editTextUrso.addTextChangedListener(new CustomTextWatcher());
        editTextUrubu.addTextChangedListener(new CustomTextWatcher());
        editTextOculos.addTextChangedListener(new CustomTextWatcher());
        editTextEstrela.addTextChangedListener(new CustomTextWatcher());
        editTextEspelho.addTextChangedListener(new CustomTextWatcher());
        editTextAviao.addTextChangedListener(new CustomTextWatcher());

        // Configurar o botão para avançar para a próxima fase
        buttonNextPhase.setOnClickListener(v -> {
            Toast.makeText(this, "Indo para a próxima fase!", Toast.LENGTH_SHORT).show();
            // Inicia a próxima Activity
            startActivity(new Intent(MainActivity2.this, NextPhaseActivity.class));
        });
    }

    private void checkForNextPhase() {
        String letterUrso = editTextUrso.getText().toString().toLowerCase();
        String letterUrubu = editTextUrubu.getText().toString().toLowerCase();
        String letterOculos = editTextOculos.getText().toString().toLowerCase();
        String letterEstrela = editTextEstrela.getText().toString().toLowerCase();
        String letterEspelho = editTextEspelho.getText().toString().toLowerCase();
        String letterAviao = editTextAviao.getText().toString().toLowerCase();

        if (letterUrso.equals("u") && letterUrubu.equals("u") &&
                letterOculos.equals("o") && letterEstrela.equals("e") &&
                letterEspelho.equals("e") && letterAviao.equals("a")) {

            // Ativar o botão para próxima fase se todas as letras estão corretas
            buttonNextPhase.setEnabled(true);
        } else {
            // Desativar o botão se as respostas estiverem incorretas
            buttonNextPhase.setEnabled(false);
        }
    }

    private class CustomTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            checkForNextPhase(); // Verifica se deve ativar o botão de próxima fase
        }
    }
}








