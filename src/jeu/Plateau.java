package jeu;

import java.util.*;
//import jeu.Case;


public class Plateau {
	
	//attributs
	 private ArrayList<Case> jeuPlateau = new ArrayList<>(); // instance liste des cases sous forme de tableau
	 
	
	 //constructeurs
	 public Plateau() {
		 initPlateau();
	 }
	 
	//getters
		//pour r�cup�rer la case pass�e en param�tre
		public char getCase() {
			return 0;
		}
	 
	//m�thodes
	public void initPlateau() { //initation du tableau avec des cases vides et une case Start
		 
		 for (int i=0; i<10; i++){ // tableau de 64 cases + instance du plateau de jeu en dur.
			 jeuPlateau.add(new EmptyCase()); // ajoute case vide (de 1 � fin du plateau)
		 }
		
		 //jeuPlateau.set(0, new StartCase()); // renvoie la classe StartCase() qui est 'Start Case' = index 0
		 
		 //tr�sor
		 jeuPlateau.set(1, new Tresor());
		 jeuPlateau.set(4, new Tresor());
		 jeuPlateau.set(8, new Tresor()); 
		 jeuPlateau.set(6, new Tresor()); 
		 
		 //ennemis
		 jeuPlateau.set(2, new Ennemi());
		 jeuPlateau.set(9, new Ennemi());
		 jeuPlateau.set(5, new Ennemi());
		 
		//System.out.println(jeuPlateau);
	 }
	 
	public void afficherCases() {
		System.out.println(jeuPlateau);
	}
	
	 public int size() { // taille du tableau
		 return jeuPlateau.size();
	 }
	 
	 public Case test(int idCase) {
		return this.jeuPlateau.get(idCase);
		
		 
	 }
	 


	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //Affichage d'un tableau en 2D pour illustrer avant de trouver la bonne m�thode
	 //Cr�er en 1D mais afficher en 2D modulo pour couper les lignes
	 
	 //attributs pour afficher un tableau en 2D - Exemple
	 private int nbLig; // ligne
	 private int nbCol; // colonne
	 private char plateau[][]; // repr�sentation du personnage sur le plateau []ligne + []colonne
	 
	 //Affichage d'un plateau - juste comme �a, besoin d'un visuel => c'est un autre objet
	public Plateau(int n, int p) {
			nbLig = n;
			nbCol = p;
			plateau = new char[nbLig][nbCol]; // = a un nouveau tableau de caract�re
			
			for (int i=0; i<nbLig; i++){ // double boucle for car tableau � 2D
				for(int j=0; j<nbCol; j++){
					
					plateau[i][j] = '_'; // on remplit le plateau de _ -> pour les emplacements ( _ = vide ; X = personnage ; E = ennemi ; O = objet ) 
				}
			}
			
		}
		
		//M�thodes
		//afficher le plateau
		public void afficherPlat() {
			
			System.out.println();
			for (int i=0; i<nbLig; i++){
				for(int j=0; j<nbCol; j++){
					
					System.out.print(" | " + plateau[i][j]); // affiche la plateau avec une | + emplacements et se r�p�te de la longueur du tableau
					
				}
				
				System.out.println(" | "); // affiche la derni�re | de chaque ligne
			}
			
			System.out.println(); // saut de ligne � la fin du tableau
			
		}
	 
}