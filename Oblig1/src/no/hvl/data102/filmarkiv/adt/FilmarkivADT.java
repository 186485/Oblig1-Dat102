package no.hvl.data102.filmarkiv.adt;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public interface FilmarkivADT {
/**
 * 
 * @param nr
 * @return
 */
	Film finnFilm(int nr);
/**
 * 
 * @param Finn filmen du leter etter
 */
	void leggTilFilm(Film nyFilm);
/**
 * 
 * @param Legg til filmen din i arkivet
 * @return
 */
	boolean slettFilm(int filmnr);
/**
 * 
 * @param Slette filmen fra arkivet
 * @return
 */
	Film[] soekTittel(String delstreng);
/**
 * 
 * @param Søke etter filmen i arkivet
 * @return
 */
	Film[] soekProdusent(String delstreng);
/**
 * Søke etter film basert på produsent
 * @param sjanger
 * @return
 */
	int antall(Sjanger sjanger);
/**
 * Antall filmer i arkivet
 * @return
 */
	int antall();
}
