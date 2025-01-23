package no.hvl.data102.filmarkiv.klient;
import no.hvl.data102.filmarkiv.*;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

public class FilmarkivMain {
//Main meny som starter programmet
	public static void main(String[] args) {
			Filmarkiv filmer = new Filmarkiv(100);
			Meny meny = new Meny(filmer);
			meny.start();
			}
	
			}

 