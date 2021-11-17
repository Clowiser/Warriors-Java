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
	
	//m�thodes - ACTIONS
	/*public void menuQuitter() { //TEST
		int choix;

		System.out.println("1 - Quitter la partie : retour au menu principal 2 - lancer des"); 
		choix = clavier.nextInt();

		// faire choix entre 1 ou 2 ou 3
		switch (choix) {
		case 1:
			System.out.println("Vous avez quitt� la partie - retour au menu principal");
			System.out.println("");
			break;
			
		case 2:
			lancerDes();
			break;

		default:
			System.out.println("Erreur s�lection");
			break;
		} 
	}*/
	
		
	// Menu du jeu : lancer les d�s - avancer - passer joueur suivant
		public void menuJeu() {
			// menu en jeu
			int choix;
			
			System.out.println("1 Lancer le d�s - 2 Quitter la partie : retour au menu principal"); 
			// ajouter "Passer au joueur suivant" ou "case �v�nement" quand le J1 a fini son tour (1 lancer de d�s)
			choix = clavier.nextInt();
			
			// faire choix entre 1 ou 2
			switch (choix) {
			case 1:
				// Appel de la fonction lancerDes()
				lancerDes();
				break;

			case 2:
				System.out.println("Vous avez quitt� la partie - retour au menu principal");
				break;

			default:
				System.out.println("Erreur s�lection");
				break;
				
			} 
		}
		
		
		
		
		//d�marrage de la partie
		public void start() {
			
			// affichage du plateau
			afficherPlateau();
			//menu du jeu -> lancer les d�s
			menuJeu();
		}

		
		// affichage du plateau
		public void afficherPlateau() {
			System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les d�s pour commencer l'aventure !");
			System.out.println("Infos : la taille du plateau est de " + plateau.size() + " cases.");
			System.out.println("");
		}

		
		// lancer les d�s
		public void lancerDes() {
			

			if(positionJoueur <= plateau.size()) {
				scoreDes = nbDe.lancerDe();
				positionJoueur += scoreDes; // additionne les deux var et stocke le r�sultat dans var gauche -> positionJoueur + resultatDe = positionJoueur
				System.out.println("Le r�sultat de votre lancer de d�s est : " + scoreDes + ".");
				System.out.println("");
				avancer();
				menuJeu();
			}
			
		}

		
		// avancer le joueur : r�sultat de l'avanc�e du joueur sur le plateau + placement sur plateau 
		public void avancer() {
			
			int direction;
			
			System.out.println("1 - Faites avancer votre personnage de " + scoreDes + " cases.");
			direction = clavier.nextInt();

			// faire choix
			switch (direction) {
			case 1:
				//plateau.afficher();
				System.out.println("Votre personnage a avanc� de " + scoreDes + " cases et est maintenant en position : " + positionJoueur);
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
				System.out.println("Erreur s�lection");
				break;
			}
			
			
			
			
			 //exceptions : �l�ment qui va attraper les erreurs
			/*try {
				
			}catch (PersonnageHorsPlateauException e) {
				 System.out.println("Attention, vous �tes sorti du plateau");
			 }
			
			}*/
			 
			
			//clavier.close(); -> !!! provoque une erreur car referme la saisie clavier alors qu'elle doit continuer pour le menuJeu()

		}
		
		
		public void interaction() {
			
		}

}