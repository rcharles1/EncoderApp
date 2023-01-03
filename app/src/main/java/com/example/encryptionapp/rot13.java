package com.example.encryptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class rot13 extends AppCompatActivity {

    TextView rot13CipherView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rot13);
        Intent intent = getIntent();
        String message_input = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        rot13CipherView = findViewById(R.id.rot13textView);

        String Cipher =rot13Encryption.encrypt(message_input);

        rot13CipherView.setText(String.format("The Ciphertext is %s", Cipher));
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }
}