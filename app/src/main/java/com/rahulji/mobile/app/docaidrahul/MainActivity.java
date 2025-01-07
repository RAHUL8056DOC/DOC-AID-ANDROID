package com.rahulji.mobile.app.docaidrahul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText edtEmail, edtPass;
    TextView frgtPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail= findViewById(R.id.edtEmail);
        edtPass= findViewById(R.id.edtPassword);
        frgtPass= findViewById(R.id.frgtPass);
        btnLogin= findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtEmail.getText().toString().isEmpty()) {
                    if (!edtPass.getText().toString().isEmpty()) {
                        Intent dash = new Intent(MainActivity.this, Home.class);
                        dash.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(dash);
                        finish();
                    }else
                        Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            }
        });

    }
}