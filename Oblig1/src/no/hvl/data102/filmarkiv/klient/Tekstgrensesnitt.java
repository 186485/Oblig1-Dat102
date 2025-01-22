package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import javax.swing.JOptionPane;

public class Tekstgrensesnitt {
    private Scanner scanner = new Scanner(System.in);

    // Leser inn opplysninger om brukeren velger legg til film
    public Film lesFilm() {
      try { 
        int filmnr = Integer.parseInt(JOptionPane.showInputDialog("Oppgi filmnr:"));
        String produsent = JOptionPane.showInputDialog("Oppgi produsenten av filmen:");
        String tittel = JOptionPane.showInputDialog("Oppgi tittelen på filmen:");
        int lanseringsår = Integer.parseInt(JOptionPane.showInputDialog("Oppgi årstall:"));

        String[] sjangre = {"ACTION", "DRAMA", "COMEDY", "HORROR", "THRILLER"};
        String valgtSjanger = (String) JOptionPane.showInputDialog(
                null,
                "Velg sjanger:",
                "Sjanger",
                JOptionPane.QUESTION_MESSAGE,
                null,
                sjangre,
                sjangre[0]
        );
        Sjanger sjanger = Sjanger.valueOf(valgtSjanger.toUpperCase());
        
        String filmselskap = JOptionPane.showInputDialog("Filmselskap til filmen:");
        Film film = new Film(filmnr, produsent, tittel, lanseringsår, sjanger, filmselskap);
        JOptionPane.showMessageDialog(null,"Filmen registrert i arkivet");
        return film;
        
    } catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Feil i inndata. Prøv igjen.");
        return null;
    }
    }

    // Skriver ut en film med alle opplysninger på skjerm
    public void skrivUtFilm(Film film) {
        if (film != null) {
            System.out.println("Filmnummer: " + film.getFilmnr());
            System.out.println("Produsent: " + film.getProdusent());
            System.out.println("Tittel: " + film.getTittel());
            System.out.println("Lanseringsår: " + film.getLansering());
            System.out.println("Sjanger: " + film.getSjanger());
            System.out.println("Filmselskap: " + film.getFilmSelskap());
        } else {
            System.out.println("Filmen finnes ikke.");
        }
    }

    // Skriver ut alle filmer med et spessielt kodeord i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng);
        if (filmer != null && filmer.length > 0) {
            for (Film film : filmer) {
                skrivUtFilm(film);
            }
        } else {
            System.out.println("Ingen filmer funnet med kodeordet");
        }
    }

    // Skriver ut alle filmer av en produsent
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekProdusent(delstreng);
        if (filmer != null && filmer.length > 0) {
            for (Film film : filmer) {
                skrivUtFilm(film);
            }
        } else {
            System.out.println("Ingen filmer funnet fra produsenten.");
        }
    }

    // Skriver ut oversikt over alle filmer i arkivet(antall)
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Totalt antall filmer: " + arkiv.antall());
        
        Sjanger[] sjangere = Sjanger.values();
        for (Sjanger sjanger : sjangere) {
            int antallIGruppe = arkiv.antall(sjanger);
            System.out.println(sjanger + ": " + antallIGruppe);
        }
    }
}
