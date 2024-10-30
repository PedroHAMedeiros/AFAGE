package com.example.afage;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class NextPhaseActivity extends AppCompatActivity {

    private EditText editTextIgreja, editTextIlha, editTextAnel, editTextElefante, editTextOsso, editTextOvelha;
    private Button buttonNextPhase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_phase);

        // Exibir mensagem de boas-vindas
        Toast.makeText(this, "Bem-vindo à Fase 2!", Toast.LENGTH_SHORT).show();

        // Acessar os EditTexts
        editTextIgreja = findViewById(R.id.editText_resposta_fase2);
        editTextIlha = findViewById(R.id.editText_resposta_ilha);
        editTextAnel = findViewById(R.id.editText_resposta_anel);
        editTextElefante = findViewById(R.id.editText_resposta_elefante);
        editTextOsso = findViewById(R.id.editText_resposta_osso);
        editTextOvelha = findViewById(R.id.editText_resposta_ovelha);

        // Configurar o botão de próxima fase
        buttonNextPhase = findViewById(R.id.button_next_phase);
        buttonNextPhase.setEnabled(false); // Desativar o botão inicialmente

        // Adicionar TextWatcher a cada EditText
        editTextIgreja.addTextChangedListener(new CustomTextWatcher());
        editTextIlha.addTextChangedListener(new CustomTextWatcher());
        editTextAnel.addTextChangedListener(new CustomTextWatcher());
        editTextElefante.addTextChangedListener(new CustomTextWatcher());
        editTextOsso.addTextChangedListener(new CustomTextWatcher());
        editTextOvelha.addTextChangedListener(new CustomTextWatcher());

        // Configurar ação do botão para ir para a terceira fase
        buttonNextPhase.setOnClickListener(v -> {
            Toast.makeText(this, "Indo para a próxima fase!", Toast.LENGTH_SHORT).show();
            // Aqui você pode iniciar a terceira Activity
            // Exemplo: startActivity(new Intent(NextPhaseActivity.this, ThirdPhaseActivity.class));
        });
    }

    private void checkForNextPhase() {
        // Pega o texto de cada EditText e converte para letra minúscula
        String letterIgreja = editTextIgreja.getText().toString().toLowerCase();
        String letterIlha = editTextIlha.getText().toString().toLowerCase();
        String letterAnel = editTextAnel.getText().toString().toLowerCase();
        String letterElefante = editTextElefante.getText().toString().toLowerCase();
        String letterOsso = editTextOsso.getText().toString().toLowerCase();
        String letterOvelha = editTextOvelha.getText().toString().toLowerCase();

        // Verifica se as vogais iniciais estão corretas
        if (letterIgreja.equals("i") && letterIlha.equals("i") &&
                letterAnel.equals("a") && letterElefante.equals("e") &&
                letterOsso.equals("o") && letterOvelha.equals("o")) {

            // Ativa o botão de próxima fase se todas as letras estão corretas
            buttonNextPhase.setEnabled(true);
        } else {
            // Desativa o botão se qualquer resposta estiver incorreta
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

