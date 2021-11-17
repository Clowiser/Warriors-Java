package jeu;

import java.util.*;
import jeu.Case;


public class Plateau {
	
	//attributs
	 private ArrayList<Case> jeuPlateau = new ArrayList<>(); // liste des cases
	 
	 //constructeurs
	 public Plateau() {
		 initPlateau();
	 }
	 
	 public void initPlateau() { //initation du tableau avec des cases vides et une case Start
		 
		 for (int i=0; i<10; i++){ // tableau de 64 cases
			 jeuPlateau.add(new EmptyCase()); // ajoute case vide (de 1 à fin du plateau)
		 }
		
		 jeuPlateau.set(0, new StartCase()); // renvoie la classe StartCase() qui est 'Start Case' = index 0
	 }
	 
	 public int size() { // taille du tableau
		 return jeuPlateau.size();
	 }
	 
	 public void afficherPlat() {
			 System.out.print("|");
			 for(int i=0; i<10; i++) {
				 System.out.print("_");
			 }
			 System.out.print("|");
		}	 
	 
}