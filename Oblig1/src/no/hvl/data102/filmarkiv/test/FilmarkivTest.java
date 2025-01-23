package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {

    @Test
    void testLeggTilFilm() {
        Filmarkiv2 arkiv = new Filmarkiv2();

        Film film1 = new Film(1, "Produsent1", "Tittel1", 2021, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        assertEquals(2, arkiv.antall(), "Antall filmer burde være 2.");
        assertEquals(film1, arkiv.finnFilm(1), "Film 1 ble ikke lagt til korrekt.");
        assertEquals(film2, arkiv.finnFilm(2), "Film 2 ble ikke lagt til korrekt.");
    }

    @Test
    void testSlettFilm() {
        Filmarkiv2 arkiv = new Filmarkiv2();

        Film film1 = new Film(1, "Produsent1", "Tittel1", 2021, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");
        Film film3 = new Film(3, "Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");
        Film film4 = new Film(4, "Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");
        Film film5 = new Film(5, "Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);
        arkiv.leggTilFilm(film4);
        arkiv.leggTilFilm(film5);

        // Slett film1 og sjekk antall
        assertTrue(arkiv.slettFilm(2), "Film 2 ble ikke slettet.");
        assertTrue(arkiv.slettFilm(3), "Film 3 ble ikke slettet.");
        assertEquals(3, arkiv.antall(), "Antall filmer burde være 3 etter sletting.");
        assertNull(arkiv.finnFilm(2), "Film 2 burde være null etter sletting.");
        assertNull(arkiv.finnFilm(3), "Film 3 burde være null etter sletting.");

    }
    

    @Test
    void testSoekTittel() {
        Filmarkiv2 arkiv = new Filmarkiv2();

        Film film1 = new Film(1, "Produsent1", "Tittel1", 2021, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        
        
        Film[] resultater = arkiv.soekTittel("Tittel1");
        assertNotNull(resultater, "Søkeresultat burde ikke være null.");
        assertEquals(1, resultater.length, "Antall treff burde være 1.");
        assertEquals(film1, resultater[0], "Søkeresultatet er feil.");
    }
 
    @Test
    void testSoekProdusent() {
        Filmarkiv2 arkiv = new Filmarkiv2();

        Film film1 = new Film(1, "Produsent1", "Tittel1", 2021, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        Film[] resultater = arkiv.soekProdusent("Produsent2");
        assertNotNull(resultater, "Søkeresultat burde ikke være null.");
        assertEquals(1, resultater.length, "Antall treff burde være 1.");
        assertEquals(film2, resultater[0], "Søkeresultatet er feil.");
    }

    @Test
    void testAntall() {
        Filmarkiv2 arkiv = new Filmarkiv2();

        Film film1 = new Film(1, "Produsent1", "Tittel1", 2021, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        assertEquals(2, arkiv.antall(), "Antall filmer burde være 2.");
    }

    @Test
    void testAntallSjanger() {
        Filmarkiv2 arkiv = new Filmarkiv2();

        Film film1 = new Film(1, "Produsent1", "Tittel1", 2021, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2022, Sjanger.ACTION, "Filmselskap2");
        Film film3 = new Film(3, "Produsent3", "Tittel3", 2023, Sjanger.COMEDY, "Filmselskap3");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);

        assertEquals(2, arkiv.antall(Sjanger.ACTION), "Antall ACTION-filmer burde være 2.");
        assertEquals(1, arkiv.antall(Sjanger.COMEDY), "Antall COMEDY-filmer burde være 1.");
    }
}
