package jeu;

import java.util.Scanner;
import jeu.Plateau;
import jeu.EmptyCase;

public class Game {

	// attributs
	Plateau plateau; 
	Des nbDe = new Des();
	int scoreDes;
	int positionJoueur;
	Scanner clavier = new Scanner(System.in);
	
	
	//constructeurs
	public Game() {
		this.plateau = new Plateau();
	}
	
	//méthodes - ACTIONS
	/*public void menuQuitter() { //TEST
		int choix;

		System.out.println("1 - Quitter la partie : retour au menu principal 2 - lancer des"); 
		choix = clavier.nextInt();

		// faire choix entre 1 ou 2 ou 3
		switch (choix) {
		case 1:
			System.out.println("Vous avez quitté la partie - retour au menu principal");
			System.out.println("");
			break;
			
		case 2:
			lancerDes();
			break;

		default:
			System.out.println("Erreur sélection");
			break;
		} 
	}*/
	
		
	// Menu du jeu : lancer les dés - avancer - passer joueur suivant
		public void menuJeu() {
			// menu en jeu
			int choix;
			
			System.out.println("1 Lancer le dés - 2 Quitter la partie : retour au menu principal"); 
			// ajouter "Passer au joueur suivant" ou "case événement" quand le J1 a fini son tour (1 lancer de dés)
			choix = clavier.nextInt();
			
			// faire choix entre 1 ou 2
			switch (choix) {
			case 1:
				// Appel de la fonction lancerDes()
				lancerDes();
				break;

			case 2:
				System.out.println("Vous avez quitté la partie - retour au menu principal");
				break;

			default:
				System.out.println("Erreur sélection");
				break;
				
			} 
		}
		
		
		
		
		//démarrage de la partie
		public void start() {
			
			// affichage du plateau
			afficherPlateau();
			//menu du jeu -> lancer les dés
			menuJeu();
		}

		
		// affichage du plateau
		public void afficherPlateau() {
			System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les dés pour commencer l'aventure !");
			System.out.println("Infos : la taille du plateau est de " + plateau.size() + " cases.");
			System.out.println("");
		}

		
		// lancer les dés
		public void lancerDes() {
			

			if(positionJoueur <= plateau.size()) {
				scoreDes = nbDe.lancerDe();
				positionJoueur += scoreDes; // additionne les deux var et stocke le résultat dans var gauche -> positionJoueur + resultatDe = positionJoueur
				System.out.println("Le résultat de votre lancer de dés est : " + scoreDes + ".");
				System.out.println("");
				avancer();
				menuJeu();
			}
			
		}

		
		// avancer le joueur : résultat de l'avancée du joueur sur le plateau + placement sur plateau 
		public void avancer() {
			
			int direction;
			
			System.out.println("1 - Faites avancer votre personnage de " + scoreDes + " cases.");
			direction = clavier.nextInt();

			// faire choix
			switch (direction) {
			case 1:
				//plateau.afficher();
				System.out.println("Votre personnage a avancé de " + scoreDes + " cases et est maintenant en position : " + positionJoueur);
				System.out.println("");
				
				if(positionJoueur >= plateau.size()) {
					positionJoueur = plateau.size();
					System.out.println("Bravo Aventurier ! Vous avez atteint l'Aventure du Dungeons & Dragons !");
					positionJoueur = 0;
					System.out.println("");
					//menuQuitter(); // TEST
				}
				break;

			default:
				System.out.println("Erreur sélection");
				break;
			}
			
			
			
			
			 //exceptions : élément qui va attraper les erreurs
			/*try {
				
			}catch (PersonnageHorsPlateauException e) {
				 System.out.println("Attention, vous êtes sorti du plateau");
			 }
			
			}*/
			 
			
			//clavier.close(); -> !!! provoque une erreur car referme la saisie clavier alors qu'elle doit continuer pour le menuJeu()

		}
		
		
		public void interaction() {
			
		}

}