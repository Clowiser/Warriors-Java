package jeu;

import java.util.*;
//import jeu.Case;

public class Plateau {

	// attributs
	private ArrayList<Case> plateau = new ArrayList<>(); // instance liste des cases sous forme de tableau

	// constructeurs
	public Plateau() {
		initPlateau(); // appel du menu principal pour la cr�ation du game
	}

	// accesseurs
	public ArrayList<Case> getListeCase() {
		return plateau; // retourne l'enti�ret� de la liste de case
	}

	// Lie la positionJoueur avec la case correspondante
	public Case getTypeCase(int index) { // prendre une case avec en param�tre son index -> fait en sorte que la m�thode accepte des chiffres ext�rieurs
		return plateau.get(index); // retourne une case => index
	}
	/*cette m�thode est la m�me que dessus, cela me renvoie l'index de la case avec ce qu'elle correspond public 
	 * Case idCasePlateau(int idCase) { //m�thode avec la classe Case nomm�e prenant en param�tre int idCase donc l'index return
	 * this.jeuPlateau.get(idCase); // retourne l'objet r�f�rence du jeuPlateau en prenant idCase }
	 */

	//retourne une interaction selon l'index du plateau avec le personnage
	public void interaction(int index, Personnage personnage) {
		plateau.get(index).interaction(personnage);
	}

	// m�thodes
	public void initPlateau() { // initation du tableau avec des cases vides et une case Start

		for (int i = 0; i < 20; i++) { // tableau de 64 cases + instance du plateau de jeu en dur.
			plateau.add(new EmptyCase()); // ajoute case vide (de index 0 � fin du plateau tant que celle-ci n'est pas modifi�e)
		}

		plateau.set(0, new StartCase()); // renvoie la classe StartCase() qui est 'Start Case' = index 0
		// La m�thode set(int index, Element E) met � jour l'�l�ment de l'index sp�cifi� avec l'�l�ment E donn� -> public E set(int index, Element E)

		// tr�sor
		//jeuPlateau.set(1, new Tresor()); // ici on d�finie que Tr�sor est index 1

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

		// sorci�re
		plateau.set(10, new Sorciere());
		plateau.set(16, new Sorciere());

	}

	public void afficherCases() {
		System.out.println(plateau);
	}

	public int size() { // m�thode qui retourne la taille du tableau
		return plateau.size();
	}
		
}