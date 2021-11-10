package jeu;

//import java.util.*;

public class Plateau {
	
	//Attributs
	private int nbLig;
	private int nbCol;
	private char [][] plateau; //représentation du personnage sur le plateau ligne + colonne
	
	//Constructeurs
	public Plateau(int l, int c) {
		nbLig = l;
		nbCol = c;
		plateau = new char[nbLig][nbCol];
		
		for (int i=0; i<nbLig; i++){
			for(int j=0; j<nbCol; j++){
				
				plateau[i][j] = '_';
				
			}
		}
	}
	
	//Getters
	
	//Setters
	
	//Méthodes
	public void afficher() {
		System.out.println();
		for (int i=0; i<nbLig; i++){
			for(int j=0; j<nbCol; j++){
				
				System.out.print(" | " + plateau[i][j]);
				
			}
			
			System.out.println(" | ");
		}
		
		System.out.println();
		
	}
	
	//Actions
	//Avancer
	public void avancer(int l, int c, char o){
		
		l = l-1; // pour que le joueur commence à -1 car le début du plateau ligne commence à 0
		c = c-1; // pour que le joueur commence à -1 car le début du plateau colonne commence à 0
		
		if(l<0 || c<0 || l>nbLig || c>nbCol) {
			System.out.print("Erreur de placement");
			return;
		}
		
		if(plateau[l][c] == '_') {
			plateau[l][c] = o;
		}else {
			System.out.print("Erreur, cette zone n'est pas vie !");
		}
	}
	
	//positionner des objets
}