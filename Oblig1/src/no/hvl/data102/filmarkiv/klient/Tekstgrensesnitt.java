package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
    private Scanner scanner = new Scanner(System.in);

    // Leser inn opplysninger om en film fra tastatur og returnerer et Film-objekt
    public Film lesFilm() {
        System.out.print("Filmnummer: ");
        int filmnr = Integer.parseInt(scanner.nextLine());

        System.out.print("Produsent: ");
        String produsent = scanner.nextLine();

        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();

        System.out.print("Lanseringsår: ");
        int lansering = Integer.parseInt(scanner.nextLine());

        System.out.print("Sjanger (ACTION, COMEDY, DRAMA, etc.): ");
        String sjangerStr = scanner.nextLine();
        Sjanger sjanger = Sjanger.valueOf(sjangerStr.toUpperCase());

        System.out.print("Filmselskap: ");
        String filmselskap = scanner.nextLine();

        return new Film(filmnr, produsent, tittel, lansering, sjanger, filmselskap);
    }

    // Skriver ut en film med alle opplysninger på skjerm
    public void skrivUtFilm(Film film) {
        if (film != null) {
            System.out.println("Filmnummer: " + film.getFilmnr());
            System.out.println("Produsent: " + film.getProdusent());
            System.out.println("Tittel: " + film.getTittel());
            System.out.println("Lansering: " + film.getLansering());
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
            System.out.println("Ingen filmer funnet med delstreng i tittelen.");
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
