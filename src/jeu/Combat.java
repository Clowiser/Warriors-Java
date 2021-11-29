package jeu;

import java.util.Scanner;

// COMBATS
// Tour par tour
// tour : attaque ou fuir
// ennemi attaque
// si fuite -> reculer de 1 à 6

public class Combat {
	
	
	
	// test qu'avec le Guerrier
		public void combat(Ennemi ennemi, Personnage personnage) { //je prend mn ennemi et mon personnage en paramètre pour l'interaction
			/* Il est possible de passer des arguments (appelés aussi paramètres) à une méthode, c'est-à-dire lui fournir une valeur ou le nom d'une 
			*variable afin que la méthode puisse effectuer des opérations sur ces arguments ou bien grâce à ces arguments.
			*/
			// prendre niveau de vie + niveau de force du personnage -> Guerrier/magicien
			// prendre niveau de vie + niveau de force de l'ennemi -> Gobelins/sorcières/dragons
			//  Q ? j'ai un Gobelin, enfant de Ennemi, lui-même enfant de Case, dois-je créer un gobelin pour le combat? = NON car créer deux instances !
			
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
				// revenir au jeu + lancés de dés ramdom qui fait RECULER
				break;

			default:
				System.out.println("Erreur sélection");
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
				System.out.println("Il reste " + totalAtkJoueur + " à l'ennemi");
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
