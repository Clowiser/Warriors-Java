package jeu;

import java.util.*;
import jeu.Case;


public class Plateau {
	
	//attributs
	 private ArrayList<Case> jeuPlateau = new ArrayList<>(); // liste des cases
	 
	 private int nbLig; // ligne
	 private int nbCol; // colonne
	 private char plateau[][]; // représentation du personnage sur le plateau []ligne + []colonne
	 
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
	 

	 //Affichage d'un plateau - juste comme ça
	public Plateau(int n, int p) {
			nbLig = n;
			nbCol = p;
			plateau = new char[nbLig][nbCol]; // = a un nouveau tableau de caractère
			
			for (int i=0; i<nbLig; i++){ // double boucle for car tableau à 2D
				for(int j=0; j<nbCol; j++){
					
					plateau[i][j] = '_'; // on remplit le plateau de _ -> pour les emplacements ( _ = vide ; X = personnage ; E = ennemi ; O = objet ) 
				}
			}
			
		}
		
		//Méthodes
		//afficher le plateau
		public void afficherPlat() {
			
			System.out.println();
			for (int i=0; i<nbLig; i++){
				for(int j=0; j<nbCol; j++){
					
					System.out.print(" | " + plateau[i][j]); // affiche la plateau avec une | + emplacements et se répète de la longueur du tableau
					
				}
				
				System.out.println(" | "); // affiche la dernière | de chaque ligne
			}
			
			System.out.println(); // saut de ligne à la fin du tableau
			
		}
	 
}