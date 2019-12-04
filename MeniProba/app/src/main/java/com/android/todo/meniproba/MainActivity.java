package com.android.todo.meniproba;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner comboBox;
    private TextView txtView;
    private Button dugme;
    private TextView ispis;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        comboBox = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.proizvodi, android.R.layout.simple_spinner_dropdown_item);
        comboBox.setAdapter(adapter);

        txtView = findViewById(R.id.textView);
        dugme = findViewById(R.id.button);
        ispis = findViewById(R.id.textView3);
        edit = findViewById(R.id.editText);



        ugasi();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        });

        dugme.setOnClickListener(e -> {
            new AlertDialog.Builder(this)
                    .setTitle("Potvrdi")
                    .setMessage("Da li ste sigurni da zelite da kupite izabrani proizvod")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(R.string.da, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                           String pr = comboBox.getSelectedItem().toString();
                           ispis.setTextColor(Color.BLUE);
                           ispis.setText("Uspesno ste kupili proizvod: " + pr);
                           ispis.setVisibility(View.VISIBLE);
                        }
                    })

                    .setNegativeButton(R.string.ne, (dialog, which) -> {
                        ispis.setTextColor(Color.RED);
                        ispis.setText("Zao nam je sto niste kupili proizvod");
                        ispis.setVisibility(View.VISIBLE);
                    })

                    .setIcon(R.drawable.korpa)
                    .show();
        });

        if(savedInstanceState != null){
            String vrednost = (String) savedInstanceState.get("vrednost");
            edit.setText(vrednost);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("vrednost", edit.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){

        super.onRestoreInstanceState(savedInstanceState);

        String vr = (String) savedInstanceState.get("vrednost");

        edit.setText(vr);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    private void ugasi(){
        comboBox.setVisibility(View.INVISIBLE);
        txtView.setVisibility(View.INVISIBLE);
        dugme.setVisibility(View.INVISIBLE);
        ispis.setVisibility(View.INVISIBLE);
    }

    private void upali(){
        comboBox.setVisibility(View.VISIBLE);
        txtView.setVisibility(View.VISIBLE);
        dugme.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.dodaj) {
            upali();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
