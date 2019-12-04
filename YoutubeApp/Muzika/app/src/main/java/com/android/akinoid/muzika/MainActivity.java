package com.android.akinoid.muzika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button openYT;

    private Spinner comboBox;

    private RadioButton radioNar;
    private RadioButton radioZab;
    private RadioButton radioRock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicijalizuj();

        radioNar.setOnClickListener(e -> {
            comboBox.removeAllViewsInLayout();
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pesmeN, android.R.layout.simple_spinner_dropdown_item);
            comboBox.setAdapter(adapter);

        });

        radioZab.setOnClickListener(e -> {
            comboBox.removeAllViewsInLayout();
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pesmeZ, android.R.layout.simple_spinner_dropdown_item);
            comboBox.setAdapter(adapter);
        });

        radioRock.setOnClickListener(e -> {
            comboBox.removeAllViewsInLayout();
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pesmeR, android.R.layout.simple_spinner_dropdown_item);
            comboBox.setAdapter(adapter);
        });

//        https://www.youtube.com/results?search_query=madonna

        openYT.setOnClickListener(action -> {
            String vrednost = comboBox.getSelectedItem().toString();
            String query = "https://www.youtube.com/results?search_query=" + vrednost;

            Intent yt_play = new Intent(Intent.ACTION_VIEW, Uri.parse(query));
            Intent chooser = Intent.createChooser(yt_play , "Open With");

            if (yt_play.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser);
            }
        });
    }

    private void inicijalizuj(){
        openYT = findViewById(R.id.button);
        comboBox = findViewById(R.id.spinner);
        radioNar = findViewById(R.id.radioNar);
        radioZab = findViewById(R.id.radioZab);
        radioRock = findViewById(R.id.radioRock);
    }
}
