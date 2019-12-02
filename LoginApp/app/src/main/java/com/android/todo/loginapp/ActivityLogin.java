package com.android.todo.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActivityLogin extends AppCompatActivity {

    private Button reg;

    private EditText name;
    private EditText prez;
    private EditText jmbg;
    private EditText sifra;

    private Intent data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicijalizuj();

        reg.setOnClickListener(action -> {

            data =  new Intent(this, MainActivity.class);

            String ime = name.getText().toString();
            String prezime = prez.getText().toString();
            String s = sifra.getText().toString();
            String jmb = jmbg.getText().toString();

            data.putExtra("ime", ime);
            data.putExtra("prezime", prezime);
            data.putExtra("sifra", s);
            data.putExtra("jmbg", jmb);

            setResult(Activity.RESULT_OK, data);
            finish();
        });

    }

    private void inicijalizuj(){
        reg = findViewById(R.id.btnReg);
        name = findViewById(R.id.txtName);
        prez = findViewById(R.id.txtPrez);
        sifra = findViewById(R.id.txtSifra);
        jmbg = findViewById(R.id.txtSifra);
    }
}
