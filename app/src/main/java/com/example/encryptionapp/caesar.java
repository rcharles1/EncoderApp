package com.example.encryptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class caesar extends AppCompatActivity {

    TextView CaesarCipherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar);
        Intent intent = getIntent();
        String message_input = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        CaesarCipherView = findViewById(R.id.caesar_textView);

        String Cipher = CaesarEncryption.encrypt(message_input);

        CaesarCipherView.setText(String.format("The Ciphertext is %s", Cipher));

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}