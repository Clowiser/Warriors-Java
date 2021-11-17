package jeu;

import java.lang.Exception;

public class PersonnageHorsPlateauException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public PersonnageHorsPlateauException() {
		this("Vous êtes en dehors du plateau !");
	}

	public PersonnageHorsPlateauException(String message) {
		super (message);
	}
	
	PersonnageHorsPlateauException (String message, Throwable cause){
		super (message, cause);
	}
}