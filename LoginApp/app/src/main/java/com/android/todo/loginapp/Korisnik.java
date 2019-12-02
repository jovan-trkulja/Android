package com.android.todo.loginapp;

public class Korisnik {

    private String ime;
    private String prezime;
    private String sifra;

    private String jmbg;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getJmbg() {
        return jmbg;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", sifra='" + sifra + '\'' +
                ", jmbg=" + jmbg +
                '}';
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
}
