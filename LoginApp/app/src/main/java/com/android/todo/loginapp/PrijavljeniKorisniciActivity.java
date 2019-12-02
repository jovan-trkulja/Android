package com.android.todo.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class PrijavljeniKorisniciActivity extends AppCompatActivity {

    private ListView viewLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prijavljeni_korisnici);

        viewLista = findViewById(R.id.listView);
        List<Korisnik> lista = Repository.getKorisnici();

        KorisnikAdapter ka = new KorisnikAdapter(lista);
        viewLista.setAdapter(ka);
    }
}
