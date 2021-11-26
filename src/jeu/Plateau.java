package jeu;

import java.util.*;
//import jeu.Case;

public class Plateau {
	
	//attributs
	 private ArrayList<Case> jeuPlateau = new ArrayList<>(); // instance liste des cases sous forme de tableau
	
	 //constructeurs
	 public Plateau() {
		 initPlateau(); // appel du menu principal pour la cr�ation du game
	 }
	 
	//accesseurs
	 public ArrayList<Case> getListeCase(){ 
		 return jeuPlateau; // retourne l'enti�ret� de la liste de case
	 }
	 
	//Lie la positionJoueur avec la case correspondante
	 public Case getUneCase(int index){ // prendre une case avec en param�tre son index -> fait en sorte que la m�thode accepte des chiffres ext�rieurs
		 return jeuPlateau.get(index); // retourne une case => index
	 }
	 /* cette m�thode est la m�me que dessus, cela me renvoie l'index de la case avec ce qu'elle correspond
	 public Case idCasePlateau(int idCase) { //m�thode avec la classe Case nomm�e prenant en param�tre int idCase donc l'index
		return this.jeuPlateau.get(idCase); // retourne l'objet r�f�rence du jeuPlateau en prenant idCase
	 }
	 */
	 
	//m�thodes
	public void initPlateau() { //initation du tableau avec des cases vides et une case Start
		 
		 for (int i=0; i<20; i++){ // tableau de 64 cases + instance du plateau de jeu en dur.
			 jeuPlateau.add(new EmptyCase()); // ajoute case vide (de index 0 � fin du plateau tant que celle-ci n'est pas modifi�)
		 }
		
		 jeuPlateau.set(0, new StartCase()); // renvoie la classe StartCase() qui est 'Start Case' = index 0
		 //La m�thode set(int index, Element E) met � jour l'�l�ment de l'index sp�cifi� avec l'�l�ment E donn� -> public E set(int index, Element E)
		 
		 //tr�sor
		 jeuPlateau.set(1, new Tresor()); // ici on d�finie que Tr�sor est index 1
		 jeuPlateau.set(4, new Tresor());
		 
		 //sort
		 jeuPlateau.set(8, new Sort()); 
		 jeuPlateau.set(6, new Sort()); 
		 
		 //arme
		 jeuPlateau.set(12, new Arme()); 
		 jeuPlateau.set(15, new Arme()); 
		 
		 //ennemis

		 //gobelin
		 jeuPlateau.set(5, new Gobelin());
		 jeuPlateau.set(13, new Gobelin());
		 jeuPlateau.set(18, new Gobelin());
		 
		 //dragon
		 jeuPlateau.set(2, new Dragon());
		 jeuPlateau.set(9, new Dragon());
		 jeuPlateau.set(19, new Dragon());
		 
		 //sorci�re
		 jeuPlateau.set(10, new Sorciere());
		 jeuPlateau.set(16, new Sorciere());
		
	 }
	 
	public void afficherCases() {
		System.out.println(jeuPlateau);
	}
	
	 public int size() { // = taille du tableau -> ce qu'il contient
		 return jeuPlateau.size();
	 }
	
}