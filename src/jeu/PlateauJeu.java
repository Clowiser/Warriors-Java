package jeu;

import java.util.*;

public class PlateauJeu {
	
	 private ArrayList<Case> jeuPlateau = new ArrayList<>();
	 
	 public void initPlateau() {
		 for (int i=0; i<64; i++){
			 jeuPlateau.add(new EmptyCase()); // rappel : appel constructeur de base
		 }
	 }
	 
	 public void afficherCase() {
		 System.out.print("|");
		 
	 }

}
