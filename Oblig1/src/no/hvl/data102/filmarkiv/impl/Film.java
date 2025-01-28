package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
    
    private int Filmnr;
    private String Produsent;
    private String Tittel;
    private int Lansering;
    private Sjanger sjanger;
    private String FilmSelskap;

  
    public Film() {
    }

    public Film(int filmnr, String produsent, String tittel, int lansering, Sjanger sjanger, String filmselskap) {
        this.Filmnr = filmnr;
        this.Produsent = produsent;
        this.Tittel = tittel;
        this.Lansering = lansering;
        this.sjanger = sjanger;
        this.FilmSelskap = filmselskap;
    }

    public int getFilmnr() {
        return Filmnr;
    }
    public void setFilmnr(int filmnr) {
        Filmnr = filmnr;
    }

    public String getProdusent() {
        return Produsent;
    }
    public void setProdusent(String produsent) {
        Produsent = produsent;
    }

    public String getTittel() {
        return Tittel;
    }
    public void setTittel(String tittel) {
        Tittel = tittel;
    }

    public int getLansering() {
        return Lansering;
    }
    public void setLansering(int lansering) {
        Lansering = lansering;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }
    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmSelskap() {
        return FilmSelskap;
    }
    public void setFilmSelskap(String filmSelskap) {
        FilmSelskap = filmSelskap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Filmnr);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Film other = (Film) obj;
        return Filmnr == other.Filmnr;
    }
    
}
