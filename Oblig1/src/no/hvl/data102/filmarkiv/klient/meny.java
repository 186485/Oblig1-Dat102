package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import java.util.Scanner;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        // Legger til filmer i arkivet
        leggTilForhaandsdefinerteFilmer();

        //Hva vil brukeren gjøre
        boolean fortsett = true;
        Scanner scanner = new Scanner(System.in);
        while (fortsett) {
            System.out.println("Velg et alternativ:");
            System.out.println("1: Legg til film");
            System.out.println("2: Finn film");
            System.out.println("3: Slett film");
            System.out.println("4: Søk etter tittel");
            System.out.println("5: Søk etter filmprodusent");
            System.out.println("6: Vis statistikk");
            System.out.println("0: Avslutt");
            System.out.print("Ditt valg: ");
            int valg = scanner.nextInt();
            scanner.nextLine();  // Hopper til neste linje etter brukeren har tastet inn tall

            switch (valg) {
                case 1:
                    Film nyFilm = tekstgr.lesFilm(); // Leser ny film
                    filmarkiv.leggTilFilm(nyFilm);
                    break;
                case 2:
                    System.out.print("Oppgi filmnummer for å finne filmen: ");
                    int filmnr = scanner.nextInt();
                    Film film = filmarkiv.finnFilm(filmnr);
                    tekstgr.skrivUtFilm(film);
                    break;
                case 3:
                    System.out.print("Oppgi filmnummer for å slette filmen: ");
                    int slettFilmnr = scanner.nextInt();
                    boolean slettet = filmarkiv.slettFilm(slettFilmnr);
                    if (slettet) {
                        System.out.println("Filmen ble slettet.");
                    } else {
                        System.out.println("Fant ikke filmen.");
                    }
                    break;
                case 4:
                    System.out.print("Skriv delstreng i tittel: ");
                    String tittelDelstreng = scanner.nextLine();
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tittelDelstreng);
                    break;
                case 5:
                    System.out.print("Skriv delstreng i produsent: ");
                    String produsentDelstreng = scanner.nextLine();
                    tekstgr.skrivUtFilmProdusent(filmarkiv, produsentDelstreng);
                    break;
                case 6:
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;
                case 0:
                    fortsett = false; // Avslutter programmet
                    break;
                default:
                    System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }
        scanner.close();
    }

    // Legg til noen forhåndsdefinerte filmer
    private void leggTilForhaandsdefinerteFilmer() {
        Film film1 = new Film(1, "Niki Marvin", "Frihetens Regn", 1994, Sjanger.THRILLER, "Castle rock Entertainment");
        Film film2 = new Film(2, "Paramount", "The Godfather", 1972, Sjanger.DRAMA, "Paramount");
        Film film3 = new Film(3, "Lars Petter", "Hvordan bli en reser i Java", 2025, Sjanger.COMEDY, "HVL");
        Film film4 = new Film(4, "Prebz og Dennis", "Minecraft survivalgames", 2016, Sjanger.COMEDY, "NOOBWORK");
        Film film5 = new Film(5, "Bjørn Eriksen", "Julekalender", 2019, Sjanger.COMEDY, "Addexio");
        Film film6 = new Film(6, "Gyatte etaten", "Skibbidi skatt", 2024, Sjanger.HORROR, "Jeg betaler faen meg aldri");
        
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);
        filmarkiv.leggTilFilm(film6);
    }
}
