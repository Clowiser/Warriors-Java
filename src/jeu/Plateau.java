package jeu;

import java.util.*;
//import jeu.Case;

public class Plateau {

	// attributs
	private ArrayList<Case> plateau = new ArrayList<>(); // instance liste des cases sous forme de tableau

	// constructeurs
	public Plateau() {
		initPlateau(); // appel du menu principal pour la création du game
	}

	// accesseurs
	public ArrayList<Case> getListeCase() {
		return plateau; // retourne l'entièreté de la liste de case
	}

	// Lie la positionJoueur avec la case correspondante
	public Case getTypeCase(int index) { // prendre une case avec en paramètre son index -> fait en sorte que la méthode accepte des chiffres extérieurs
		return plateau.get(index); // retourne une case => index
	}
	/*cette méthode est la même que dessus, cela me renvoie l'index de la case avec ce qu'elle correspond public 
	 * Case idCasePlateau(int idCase) { //méthode avec la classe Case nommée prenant en paramètre int idCase donc l'index return
	 * this.jeuPlateau.get(idCase); // retourne l'objet référence du jeuPlateau en prenant idCase }
	 */

	//retourne une interaction selon l'index du plateau avec le personnage
	public void interaction(int index, Personnage personnage) {
		plateau.get(index).interaction(personnage);
	}

	// méthodes
	public void initPlateau() { // initation du tableau avec des cases vides et une case Start

		for (int i = 0; i < 20; i++) { // tableau de 64 cases + instance du plateau de jeu en dur.
			plateau.add(new EmptyCase()); // ajoute case vide (de index 0 à fin du plateau tant que celle-ci n'est pas modifiée)
		}

		plateau.set(0, new StartCase()); // renvoie la classe StartCase() qui est 'Start Case' = index 0
		// La méthode set(int index, Element E) met à jour l'élément de l'index spécifié avec l'élément E donné -> public E set(int index, Element E)

		// trésor
		//jeuPlateau.set(1, new Tresor()); // ici on définie que Trésor est index 1

		// Magicien
		//jeuPlateau.set(6, new Sort());
		plateau.set(8, new FireBall());
		plateau.set(1, new FireBall());
		plateau.set(2, new SoinPotion());
		plateau.set(17, new SoinPotion());
		
		// Guerrier
		//jeuPlateau.set(15, new Arme());
		plateau.set(4, new Masse());
		plateau.set(6, new Masse());
		plateau.set(3, new Fer());
		plateau.set(7, new Fer());
		
		// ennemis
		// gobelin
		plateau.set(5,  new Gobelin());
		plateau.set(13, new Gobelin());
		plateau.set(18, new Gobelin());

		// dragon
		plateau.set(9, new Dragon());
		plateau.set(19, new Dragon());

		// sorcière
		plateau.set(10, new Sorciere());
		plateau.set(16, new Sorciere());

	}

	public void afficherCases() {
		System.out.println(plateau);
	}

	public int size() { // méthode qui retourne la taille du tableau
		return plateau.size();
	}
		
}