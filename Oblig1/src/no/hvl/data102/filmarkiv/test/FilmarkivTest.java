package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {

    @Test
    void testLeggTilFilm() {
        Filmarkiv2 arkiv = new Filmarkiv2(); //Må eventuelt bruke tabell her om man skal teste med tabell versjonen

        Film film1 = new Film(1, "Prod1", "Tittel1", 2021, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film(2, "Prod2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        assertEquals(2, arkiv.antall(), "Antall filmer 2.");
        assertEquals(film1, arkiv.finnFilm(1), "Film 1 ikke lagt til");
        assertEquals(film2, arkiv.finnFilm(2), "Film 2 ikke lagt til");
    }

    @Test
    void testSlettFilm() {
        Filmarkiv2 arkiv = new Filmarkiv2(); //Må eventuelt bruke tabell her om man skal teste med tabell versjonen

        Film film1 = new Film(1, "Prod1", "Tittel1", 2021, Sjanger.ACTION, "Film1");
        Film film2 = new Film(2, "Prod2", "Tittel2", 2022, Sjanger.COMEDY, "Film2");
        Film film3 = new Film(3, "Prod2", "Tittel2", 2022, Sjanger.COMEDY, "Film3");
        Film film4 = new Film(4, "Prod2", "Tittel2", 2022, Sjanger.COMEDY, "Film4");
        Film film5 = new Film(5, "Prod2", "Tittel2", 2022, Sjanger.COMEDY, "Film5");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);
        arkiv.leggTilFilm(film4);
        arkiv.leggTilFilm(film5);

        // Slett film1 og sjekk antall
        assertTrue(arkiv.slettFilm(2), "Film 2 ikke slettet.");
        assertTrue(arkiv.slettFilm(3), "Film 3 ikke slettet.");
        assertEquals(3, arkiv.antall(), "Antall filmer burde være 3");
        assertNull(arkiv.finnFilm(2), "Film 2 skal være null etter sletting.");
        assertNull(arkiv.finnFilm(3), "Film 3 skal være null etter sletting.");

    }
    

    @Test
    void testSoekTittel() {
        Filmarkiv2 arkiv = new Filmarkiv2(); //Må eventuelt bruke tabell her om man skal teste med tabell versjonen

        Film film1 = new Film(1, "Prod1", "Tittel1", 2021, Sjanger.ACTION, "Film1");
        Film film2 = new Film(2, "Prod2", "Tittel2", 2022, Sjanger.COMEDY, "Film2");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        
        
        Film[] resultater = arkiv.soekTittel("Tittel1");
        assertNotNull(resultater, "Søkeresultat ikke være null.");
        assertEquals(1, resultater.length, "Antall treff 1.");
        assertEquals(film1, resultater[0], "Søkeresultatet feil.");
    }
 
    @Test
    void testSoekProdusent() {
        Filmarkiv2 arkiv = new Filmarkiv2();

        Film film1 = new Film(1, "Prod1", "Tittel1", 2021, Sjanger.ACTION, "Film1");
        Film film2 = new Film(2, "Prod2", "Tittel2", 2022, Sjanger.COMEDY, "Film2");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        Film[] resultater = arkiv.soekProdusent("Prod2");
        assertNotNull(resultater, "Søkeresultat ikke være null.");
        assertEquals(1, resultater.length, "Antall skal være 1.");
        assertEquals(film2, resultater[0], "Søkeresultatet feil.");
    }

    @Test
    void testAntall() {
        Filmarkiv2 arkiv = new Filmarkiv2();

        Film film1 = new Film(1, "Prod1", "Tittel1", 2021, Sjanger.ACTION, "Film1");
        Film film2 = new Film(2, "Prod2", "Tittel2", 2022, Sjanger.COMEDY, "Film2");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);

        assertEquals(2, arkiv.antall(), "Antall filmer skal vøre 2.");
    }

    @Test
    void testAntallSjanger() {
        Filmarkiv2 arkiv = new Filmarkiv2();

        Film film1 = new Film(1, "Prod1", "Tittel1", 2021, Sjanger.ACTION, "Film1");
        Film film2 = new Film(2, "Prod2", "Tittel2", 2022, Sjanger.ACTION, "Film2");
        Film film3 = new Film(3, "Prod3", "Tittel3", 2023, Sjanger.COMEDY, "Film3");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);

        assertEquals(2, arkiv.antall(Sjanger.ACTION), "Antall ACTION-filmer 2.");
        assertEquals(1, arkiv.antall(Sjanger.COMEDY), "Antall COMEDY-filmer 1.");
    }
}
