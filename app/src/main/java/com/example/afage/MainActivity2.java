package com.example.afage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextUrso, editTextUrubu, editTextOculos, editTextEstrela, editTextEspelho, editTextAviao;

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

        // Adicionar TextWatcher a cada EditText
        editTextUrso.addTextChangedListener(new CustomTextWatcher());
        editTextUrubu.addTextChangedListener(new CustomTextWatcher());
        editTextOculos.addTextChangedListener(new CustomTextWatcher());
        editTextEstrela.addTextChangedListener(new CustomTextWatcher());
        editTextEspelho.addTextChangedListener(new CustomTextWatcher());
        editTextAviao.addTextChangedListener(new CustomTextWatcher());
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

            // Se todas as letras estiverem corretas, avançar para a próxima fase
            Toast.makeText(this, "Parabéns! Você avançou para a próxima fase!", Toast.LENGTH_SHORT).show();
            // Aqui você pode iniciar a próxima fase, como iniciar uma nova Activity ou atualizar o layout
        }
    }

    private class CustomTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            checkForNextPhase(); // Verifica se deve avançar após cada mudança
        }
    }
}

