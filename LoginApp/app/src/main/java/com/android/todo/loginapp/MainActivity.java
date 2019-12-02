package com.android.todo.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button signIn;
    private Button logIn;
    private Button seeLogedUser;

    private Intent intent;
    private static final int ACTIVITY_RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logIn = findViewById(R.id.button2);
        signIn = findViewById(R.id.button);
        seeLogedUser = findViewById(R.id.button3);

        signIn.setOnClickListener(action -> {

            intent = new Intent(this, ActivityLogin.class);
            startActivityForResult(intent, ACTIVITY_RESULT_CODE);

        });

        seeLogedUser.setOnClickListener(e -> {
            Intent see = new Intent(this, PrijavljeniKorisniciActivity.class);
            startActivity(see);
        });

        logIn.setOnClickListener(e -> {
            Intent log = new Intent(this, PrijavaActivity.class);
            startActivity(log);
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(resultCode == Activity.RESULT_OK && requestCode == ACTIVITY_RESULT_CODE){
            super.onActivityResult(requestCode, resultCode, data);
            Korisnik k = new Korisnik();

            k.setIme(data.getStringExtra("ime"));
            k.setPrezime(data.getStringExtra("prezime"));
            k.setSifra(data.getStringExtra("sifra"));
            k.setJmbg(data.getStringExtra("jmbg"));

            Repository.addKorisnik(k);

        }
    }


}
