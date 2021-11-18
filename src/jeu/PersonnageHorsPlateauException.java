package jeu;

import java.lang.Exception;

public class PersonnageHorsPlateauException extends Exception {
	
	private static final long serialVersionUID = 1L; //pour avoir un identifiant unique
	
	//constructeur de l'exception
	public PersonnageHorsPlateauException() {
		this("Attention ! Vous êtes en dehors du plateau ! Et vous tombez dans une chute infinie dans laquelle vous mourrez de vieillesse..." );
	}

	//appel au constructeur de l'exception
	public PersonnageHorsPlateauException(String message) {
		super (message);
	}

}