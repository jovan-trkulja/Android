package com.android.todo.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrijavaActivity extends AppCompatActivity {

    private Button baton;
    private EditText txtName;
    private EditText txtSifra;

    private TextView viewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijava);

        inicijalizuj();

        baton.setOnClickListener(e -> {

            String sifra = txtName.getText().toString();
            String jmbg = txtSifra.getText().toString();

            Korisnik k = Repository.findKorisnik(sifra, jmbg);

            if(k != null){
                viewText.setText("Uspesno ste se prijavili na sistem");
                viewText.setVisibility(View.VISIBLE);

                viewText.setTextColor(Color.BLUE);

                baton.setVisibility(View.INVISIBLE);
                txtName.setVisibility(View.INVISIBLE);
                txtSifra.setVisibility(View.INVISIBLE);

            } else {
                viewText.setText("Greska prilikom prijavljivanja");
                viewText.setTextColor(Color.RED);
                viewText.setVisibility(View.VISIBLE);
            }
        });
    }

    private void inicijalizuj() {

        baton = findViewById(R.id.button4);
        txtName = findViewById(R.id.txt_log_name);
        txtSifra = findViewById(R.id.txt_sifra_);
        viewText = findViewById(R.id.txtTextSet);
    }
}
