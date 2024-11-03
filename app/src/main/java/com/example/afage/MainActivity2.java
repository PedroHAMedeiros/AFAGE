package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
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

        // Adicionar TextWatcher a cada EditText
        editTextUrso.addTextChangedListener(new CustomTextWatcher(editTextUrso, "u"));
        editTextUrubu.addTextChangedListener(new CustomTextWatcher(editTextUrubu, "u"));
        editTextOculos.addTextChangedListener(new CustomTextWatcher(editTextOculos, "o"));
        editTextEstrela.addTextChangedListener(new CustomTextWatcher(editTextEstrela, "e"));
        editTextEspelho.addTextChangedListener(new CustomTextWatcher(editTextEspelho, "e"));
        editTextAviao.addTextChangedListener(new CustomTextWatcher(editTextAviao, "a"));

        // Configurar o botão para avançar para a próxima fase
        buttonNextPhase.setOnClickListener(v -> {
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
        private EditText editText;
        private String correctLetter;

        public CustomTextWatcher(EditText editText, String correctLetter) {
            this.editText = editText;
            this.correctLetter = correctLetter;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().equalsIgnoreCase(correctLetter)) {
                editText.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            } else {
                editText.setTextColor(getResources().getColor(android.R.color.black));
            }
            checkForNextPhase();
        }
    }
}









