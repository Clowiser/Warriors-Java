package jeu;

import java.util.*;
//import jeu.Case;

public class Plateau {
	
	//attributs
	 private ArrayList<Case> jeuPlateau = new ArrayList<>(); // instance liste des cases sous forme de tableau
	
	 //constructeurs
	 public Plateau() {
		 initPlateau(); // appel du menu principal pour la création du game
	 }
	 
	//accesseurs
	 public ArrayList<Case> getListeCase(){ 
		 return jeuPlateau; // retourne l'entièreté de la liste de case
	 }
	 
	//Lie la positionJoueur avec la case correspondante
	 public Case getUneCase(int index){ // prendre une case avec en paramètre son index -> fait en sorte que la méthode accepte des chiffres extérieurs
		 return jeuPlateau.get(index); // retourne une case => index
	 }
	 /* cette méthode est la même que dessus, cela me renvoie l'index de la case avec ce qu'elle correspond
	 public Case idCasePlateau(int idCase) { //méthode avec la classe Case nommée prenant en paramètre int idCase donc l'index
		return this.jeuPlateau.get(idCase); // retourne l'objet référence du jeuPlateau en prenant idCase
	 }
	 */
	 
	//méthodes
	public void initPlateau() { //initation du tableau avec des cases vides et une case Start
		 
		 for (int i=0; i<20; i++){ // tableau de 64 cases + instance du plateau de jeu en dur.
			 jeuPlateau.add(new EmptyCase()); // ajoute case vide (de index 0 à fin du plateau tant que celle-ci n'est pas modifié)
		 }
		
		 jeuPlateau.set(0, new StartCase()); // renvoie la classe StartCase() qui est 'Start Case' = index 0
		 //La méthode set(int index, Element E) met à jour l'élément de l'index spécifié avec l'élément E donné -> public E set(int index, Element E)
		 
		 //trésor
		 jeuPlateau.set(1, new Tresor()); // ici on définie que Trésor est index 1
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
		 
		 //sorcière
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