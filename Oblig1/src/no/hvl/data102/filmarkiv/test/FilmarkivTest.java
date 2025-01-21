package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {

	@Test
	void testFilmarkiv() {
		fail("Ikke implementert");
	}

	@Test
	void testHvisFull() {
		 // Opprett et filmarkiv med kapasitet for 2 filmer
	    Filmarkiv arkiv = new Filmarkiv(2);

	    // Legg til to filmer (arkivet blir fullt)
	    Film film1 = new Film(1, "Produsent1", "Tittel1", 2021, Sjanger.ACTION, "Filmselskap1");
	    Film film2 = new Film(2, "Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");
	    arkiv.leggTilFilm(film1);
	    arkiv.leggTilFilm(film2);

	    // Sjekk at antallet filmer er 2 før vi prøver å legge til en tredje
	    assertEquals(2, arkiv.antall(), "Antall filmer burde være 2 før utvidelse.");

	    // Legg til en tredje film som burde utvide kapasiteten
	    Film film3 = new Film(3, "Produsent3", "Tittel3", 2023, Sjanger.DRAMA, "Filmselskap3");
	    arkiv.leggTilFilm(film3);

	    // Sjekk at arkivet nå har 3 filmer, som betyr at kapasiteten har blitt utvidet
	    assertEquals(3, arkiv.antall(), "Arkivet ble ikke utvidet etter å ha lagt til en tredje film.");
	}

	@Test
	void testFinnFilm() {
		fail("Not yet implemented");
	}

	@Test
	void testLeggTilFilm() {
		fail("Not yet implemented");
	}

	@Test
	void testSlettFilm() {
		fail("Not yet implemented");
	}

	@Test
	void testSoekTittel() {
        Filmarkiv arkiv = new Filmarkiv(5);

        Film film1 = new Film(1, "Produsent1", "Action Movie", 2021, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film(2, "Produsent2", "Comedy Movie", 2022, Sjanger.COMEDY, "Filmselskap2");
        Film film3 = new Film(3, "Produsent3", "Action Adventure", 2023, Sjanger.ACTION, "Filmselskap3");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);

        Film[] resultater = arkiv.soekTittel("Action");

        assertEquals(2, resultater.length, "Antallet filmer som matcher søket er feil.");
        assertTrue(resultater[0].getTittel().contains("Action"), "Filmen 1 er ikke riktig.");
        assertTrue(resultater[1].getTittel().contains("Action"), "Filmen 2 er ikke riktig.");
	}

	@Test
	void testSoekProdusent() {
		Filmarkiv arkiv = new Filmarkiv(10);
		 	Film film1 = new Film(1, "OLA", "Action Movie", 2021, Sjanger.ACTION, "Filmselskap1");
	        Film film2 = new Film(2, "OLA", "Comedy Movie", 2022, Sjanger.COMEDY, "Filmselskap2");
	        Film film3 = new Film(2, "STIG", "Comedy Movie", 2022, Sjanger.COMEDY, "Filmselskap2");
	        Film film4 = new Film(3, "BERNT", "Action Adventure", 2023, Sjanger.ACTION, "Filmselskap3");

	        arkiv.leggTilFilm(film1);
	        arkiv.leggTilFilm(film2);
	        arkiv.leggTilFilm(film3);
	        arkiv.leggTilFilm(film4);


	        Film[] resultater = arkiv.soekProdusent("OLA");

	        assertEquals(2, resultater.length, "Antallet filmer som matcher søket er feil.");
	        assertTrue(resultater[0].getProdusent().contains("OLA"), "Filmen 1 er ikke riktig.");
	        assertTrue(resultater[1].getProdusent().contains("OLA"), "Filmen 2 er ikke riktig.");
	}

	@Test
	void testAntallSjanger() {
		fail("Not yet implemented");
	}

	@Test
	void testAntall() {
		Filmarkiv arkiv = new Filmarkiv(10);
	 	Film film1 = new Film(1, "OLA", "Action Movie", 2021, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film(2, "OLA", "Comedy Movie", 2022, Sjanger.COMEDY, "Filmselskap2");
        Film film3 = new Film(2, "STIG", "Comedy Movie", 2022, Sjanger.COMEDY, "Filmselskap2");	
        
        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);
        
        assertEquals(3, arkiv.antall(), "Antall filmer i arkivet er ikke riktig");
	}

}
