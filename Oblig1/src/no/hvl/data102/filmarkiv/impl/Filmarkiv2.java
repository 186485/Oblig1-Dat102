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
		
		  LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
	        nyNode.neste = start;
	        start = nyNode;
	        antall++; 	
	        
		}
		// TODO Auto-generated method stub
		
	@Override
	public boolean slettFilm(int filmnr) {
	    LinearNode<Film> current = start;
	    LinearNode<Film> previous = null;

	    while (current != null) {
	        if (current.data.getFilmnr() == filmnr) {
	            if (previous == null) {
	                // Sletter den første om første i rekken skal slettes
	                start = current.neste;
	            } else {
	                // Sletter evt node som er i midten eller bakerst
	                previous.neste = current.neste;
	            }
	            antall--; //Sletter og reduserer antallet om noden skal slettes
	            return true; 
	        }
	        previous = current; // kobler sammen nodene slik at rekken forsatt fungerer
	        current = current.neste; 
	    }
	    return false; //Om det ikke er en filmNR som er gyldig
	}

	@Override
	public Film[] soekTittel(String delstreng) {	
		LinearNode<Film> valgt = start;
		while(valgt != null) {
			if(valgt.data.getTittel().contains(delstreng)) {
				
		 return new Film[] { valgt.data };
			}
			valgt = valgt.neste;
		}
		return null;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		LinearNode<Film> valgt = start;
		
		while(valgt != null) {
			if(valgt.data.getProdusent().contains(delstreng)) {
		 return new Film[] { valgt.data };
			}
			valgt = valgt.neste;
		}
		return null;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallSjangere = 0;
        LinearNode<Film> valgt = start;

        while (valgt != null) {
            if (valgt.data.getSjanger() == sjanger) {
                antallSjangere++;
            }
            valgt = valgt.neste;
        }
        return antallSjangere;
	}

	@Override
	public int antall() {
		 return antall;
	}
	
	
}
