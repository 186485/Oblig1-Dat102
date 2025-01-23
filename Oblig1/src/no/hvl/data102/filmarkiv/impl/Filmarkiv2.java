package no.hvl.data102.filmarkiv.impl;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT{

	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		this.antall = 0;
		this.start = null;
	}
	
	@Override
	public Film finnFilm(int nr) {
		
		LinearNode<Film> valgt = start;
		while(valgt != null) {
			if(valgt.data.getFilmnr() == nr) {
				return valgt.data;
			}
			valgt = valgt.neste;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(antall == 0) {
		this.start = new LinearNode<Film>(nyFilm);
		//Kode
		//antall++;
		}else {
			//Kode for legge til film om det allerede finnes filmer i noden
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> valgt = start;
		while(valgt != null) {
			if(valgt.data.getFilmnr() == filmnr) {
			 valgt.data = null; //Må huske å koble om man fjerner noe i midten av slett, kommer tilbake
			 antall--;
			 return true;
			}
			valgt = valgt.neste;
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		// TODO Auto-generated method stub
		return null;
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
