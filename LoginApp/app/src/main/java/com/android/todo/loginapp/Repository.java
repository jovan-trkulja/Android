package com.android.todo.loginapp;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private static List<Korisnik> korisnici;

    static {
        korisnici = new ArrayList<>();
    }

    public static void addKorisnik(Korisnik k){
        korisnici.add(k);
    }

    public static List<Korisnik> getKorisnici(){
        return korisnici;
    }

    public static Korisnik findKorisnik(String sifra, String jmbg){

        return korisnici.stream()
                        .filter(e -> e.getSifra().equals(sifra) && e.getJmbg().equals(jmbg))
                        .findFirst()
                        .orElse(null);
    }

}
