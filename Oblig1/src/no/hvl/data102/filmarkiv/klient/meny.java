package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import javax.swing.JOptionPane;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv; 
    }

    public void start() {
        // Legger til filmer i arkivet før programmet starter
        leggTilForhaandsdefinerteFilmer();

        // Hva vil brukeren gjøre, spørre i dialogboks
        boolean fortsett = true;
        while (fortsett) {
            // Dialogboks
            String valgStr = JOptionPane.showInputDialog(null, 
                "Velg et alternativ:\n" +
                "1: Legg til film\n" +
                "2: Finn film\n" +
                "3: Slett film\n" +
                "4: Søk etter film med tittel\n" +
                "5: Søk etter film med produsent\n" +
                "6: Vis antall filmer i arkivet\n" +
                "0: Avslutt\n" +
                "Ditt valg:");

            if (valgStr == null || valgStr.isEmpty()) {
                break; // Hvis brukeren trykker på Avbryt
            }

            int valg = Integer.parseInt(valgStr);

            switch (valg) {
                case 1:
                    // Leser ny film
                    Film nyFilm = tekstgr.lesFilm();
                    filmarkiv.leggTilFilm(nyFilm);
                    break;
                case 2:
                    String filmnrStr = JOptionPane.showInputDialog("Oppgi filmnummer for å finne filmen:");
                    int filmnr = Integer.parseInt(filmnrStr);
                    Film film = filmarkiv.finnFilm(filmnr);
                    tekstgr.skrivUtFilm(film);
                    break;
                case 3:
                    String slettFilmnrStr = JOptionPane.showInputDialog("Oppgi filmnummer for å slette filmen:");
                    int slettFilmnr = Integer.parseInt(slettFilmnrStr);
                    boolean slettet = filmarkiv.slettFilm(slettFilmnr);
                    if (slettet) {
                        JOptionPane.showMessageDialog(null, "Filmen ble slettet.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Fant ikke filmen.");
                    }
                    break;
                case 4:
                    String tittelDelstreng = JOptionPane.showInputDialog("Skriv delstreng i tittel:");
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tittelDelstreng);
                    break;
                case 5:
                    String produsentDelstreng = JOptionPane.showInputDialog("Skriv delstreng i produsent:");
                    tekstgr.skrivUtFilmProdusent(filmarkiv, produsentDelstreng);
                    break;
                case 6:
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;
                case 0:
                    fortsett = false; // Avslutter programmet
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ugyldig valg. Prøv igjen.");
            }
        }
    }

    // Legg til noen filmer fra start
    private void leggTilForhaandsdefinerteFilmer() {
        Film film1 = new Film(1, "Niki Marvin", "Frihetens Regn", 1994, Sjanger.THRILLER, "Castle rock Entertainment");
        Film film2 = new Film(2, "Paramount", "The Godfather", 1972, Sjanger.DRAMA, "Paramount");
        Film film3 = new Film(3, "Lars Petter", "Hvordan bli en reser i Java", 2025, Sjanger.COMEDY, "HVL");
        Film film4 = new Film(4, "Prebz og Dennis", "Minecraft survivalgames", 2016, Sjanger.COMEDY, "NOOBWORK");
        Film film5 = new Film(5, "Addexio", "Julekalender", 2019, Sjanger.COMEDY, "Bjørn Eriksen");
        Film film6 = new Film(6, "Gyatte etaten", "Skibbidi skatt", 2024, Sjanger.HORROR, "Jeg betaler faen meg aldri");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);
        filmarkiv.leggTilFilm(film6);
    }
}
