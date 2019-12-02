package com.android.todo.loginapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class KorisnikAdapter extends BaseAdapter {

    private List<Korisnik> lista;

    public KorisnikAdapter(List<Korisnik> lista){
        this.lista = lista;
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView txtName;
        TextView txtPrez;
        TextView sifra;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.jedan_korisnik, parent, false);

        }

        txtName = convertView.findViewById(R.id.txtIme);
        txtPrez = convertView.findViewById(R.id.txtPrezime);
        sifra = convertView.findViewById(R.id.txtSifra);

        txtName.setText(lista.get(position).getIme());
        txtPrez.setText(lista.get(position).getPrezime());
        sifra.setText(lista.get(position).getSifra());

        return convertView;
    }
}
