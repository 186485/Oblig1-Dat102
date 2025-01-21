package no.hvl.data102.filmarkiv.impl;
import no.hvl.data102.filmarkiv.adt.*;

public class Filmarkiv implements FilmarkivADT {
    private int antall;
    private Film[] tabell;

    public Filmarkiv(int maksAntall) {
        this.tabell = new Film[maksAntall];
    }

    public void hvisFull() {
        if (antall >= tabell.length) {
            int lengde = tabell.length * 2; // Dobbel størrelse
            Film[] temp = new Film[lengde];

            for (int i = 0; i < tabell.length; i++) {
                temp[i] = tabell[i];
            }

            tabell = temp;
        }
    }

    public boolean erLedig() {
        return antall < tabell.length;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (tabell[i].getFilmnr() == nr) {
                return tabell[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (erLedig()) {
            tabell[antall] = nyFilm;
            this.antall++;
        } else {
            hvisFull();
            tabell[antall] = nyFilm;
            this.antall++;
        }
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (tabell[i].getFilmnr() == filmnr) {
                tabell[i] = tabell[antall - 1];
                tabell[antall - 1] = null; 
                antall--; 
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
    	
        Film[] resultater = new Film[tabell.length];
        int plassering= 0;
        
        for (int i = 0; i < antall; i++) {
            if (tabell[i].getTittel().contains(delstreng)) { 
                resultater[plassering] = tabell[i];
                plassering++;
            }
        }
        
        Film[] endeligResultat = new Film[plassering];
        System.arraycopy(resultater, 0, endeligResultat, 0, plassering);

        return endeligResultat;
    }
    @Override
    public Film[] soekProdusent(String delstreng) {
    	Film[] resultater = new Film[tabell.length];
        int plassering= 0;
        
        for (int i = 0; i < antall; i++) {
            if (tabell[i].getProdusent().contains(delstreng)) { 
                resultater[plassering] = tabell[i];
                plassering++;
            }
        }
        
        Film[] endeligResultat = new Film[plassering];
        System.arraycopy(resultater, 0, endeligResultat, 0, plassering);

        return endeligResultat;
    }

    @Override
    public int antall(Sjanger sjanger) {
    	return this.antall;
    }

    @Override
    public int antall() {
        return antall;
    }
}
