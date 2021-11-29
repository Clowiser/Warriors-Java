package jeu;

import java.util.Scanner;

// COMBATS
// Tour par tour
// tour : attaque ou fuir
// ennemi attaque
// si fuite -> reculer de 1 � 6

public class Combat {
	
	
	
	// test qu'avec le Guerrier
		public void combat(Ennemi ennemi, Personnage personnage) { //je prend mn ennemi et mon personnage en param�tre pour l'interaction
			/* Il est possible de passer des arguments (appel�s aussi param�tres) � une m�thode, c'est-�-dire lui fournir une valeur ou le nom d'une 
			*variable afin que la m�thode puisse effectuer des op�rations sur ces arguments ou bien gr�ce � ces arguments.
			*/
			// prendre niveau de vie + niveau de force du personnage -> Guerrier/magicien
			// prendre niveau de vie + niveau de force de l'ennemi -> Gobelins/sorci�res/dragons
			//  Q ? j'ai un Gobelin, enfant de Ennemi, lui-m�me enfant de Case, dois-je cr�er un gobelin pour le combat? = NON car cr�er deux instances !
			
			System.out.println("Votre Ennemi dispose de " + ennemi.getForce() + " de force d'attaque et de " + ennemi.getNiveau() + " points de vie.");
			System.out.println("");
			System.out.println("Votre Personnage dispose de " + personnage.getForce() + " de force d'attaque et de " + personnage.getNiveau() + " points de vie.");
			System.out.println("");
			
			 attaqueJoueur(ennemi, personnage);
			//resterFuir();	

		} 
		
		/*public void resterFuir() {
			System.out.println("Voulez-vous continuer ou fuir ? - 8 Rester - 9 Fuir");

			int choix = clavier.nextInt();

			switch (choix) {
			case 8:
				System.out.println("Vous avez choisi de rester ! A votre tour, Aventurier !");
				System.out.println("");
				// attaqueJoueur();
				break;

			case 9:
				System.out.println("Vous avez fui !"); 
				// revenir au jeu + lanc�s de d�s ramdom qui fait RECULER
				break;

			default:
				System.out.println("Erreur s�lection");
				break;
			}
		}*/
		
		// Joueur attaque toujours en premier
		  
		int totalAtkJoueur;
		public void attaqueJoueur(Ennemi ennemi, Personnage personnage) {
			System.out.println("A l'assaut !");
			if (personnage.getForce() > ennemi.getNiveau()) {
				System.out.println("Ennemi est mort - Fin du combat");
			}

			if (personnage.getForce() < ennemi.getNiveau()) {
				totalAtkJoueur = ennemi.getNiveau() - personnage.getForce();
				System.out.println("Il reste " + totalAtkJoueur + " � l'ennemi");
			}

			if (totalAtkJoueur > 0) {
				System.out.println("Au tour de l'ennemi !");
				attaqueEnnemi(ennemi, personnage);
			}
		}

		int totalAtkEnnemi;
		public void attaqueEnnemi(Ennemi ennemi, Personnage personnage) {

			if (ennemi.getForce() > personnage.getNiveau()) {
				System.out.println("Votre personnage est mort - Fin de partie");
			}

			if (personnage.getNiveau() > ennemi.getForce()) {
				totalAtkEnnemi = personnage.getNiveau() - ennemi.getForce();
				System.out.println("Il vous reste " + totalAtkEnnemi);
			}

		}
		
		
	
}
