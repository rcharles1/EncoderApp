package com.example.encryptionapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_TEXT = "com.example.encryptionapp.EXTRA.TEXT";

    EditText message_input;
    Button caesar_button;
    Button ROT13_button;
    TextView Encryption_Method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message_input = findViewById(R.id.messageInputEditText);
        caesar_button = findViewById(R.id.Caesar_button);
        ROT13_button = findViewById(R.id.rot13_button);
        Encryption_Method = findViewById(R.id.textView);
        
        caesar_button.setOnClickListener(this);
        ROT13_button.setOnClickListener(this);

        message_input.addTextChangedListener(messageTextWatcher);

    }

    private TextWatcher messageTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String message = message_input.getText().toString().trim();

            caesar_button.setEnabled(!message.isEmpty());
            ROT13_button.setEnabled(!message.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Caesar_button:
                    OpenCaesar();
                break;

            case R.id.rot13_button:
                OpenROT13();
                break;
        }
    }

    private void OpenROT13() {
        String message = message_input.getText().toString();
        Intent intent = new Intent(this, rot13.class);
        intent.putExtra(EXTRA_TEXT, message);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    private void OpenCaesar() {
        String message = message_input.getText().toString();
        Intent intent = new Intent(this, caesar.class);
        intent.putExtra(EXTRA_TEXT, message);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}