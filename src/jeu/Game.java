package jeu;

import java.util.Scanner;

public class Game {

	//ACTIONS
		// démarrer le jeu - afficher le plateau - lancer les dés - avancer - passer joueur suivant
		public void menuJeu() {
			// menu en jeu
			int choix;

			Scanner clavier = new Scanner(System.in);
			System.out.println("1 Lancer le dés - 2 Quitter la partie : retour au menu principal - TEST"); 
			// ajouter "Passer au joueur suivant" ou "case événement" quand le J1 a fini son tour (1 lancer de dés)
			choix = clavier.nextInt();

			// faire choix entre 1 ou 2 ou 3
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
		
		
		public void start() {
			
			// affichage du plateau
			afficherPlateau();

			menuJeu();
		}

		
		// affichage du plateau
		PlateauJeu plateau = new PlateauJeu(); // paramètres du plateau -> portée globale
		
		public void afficherPlateau() {
			System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les dés pour commencer l'aventure !");
			//placerElement();
		}

		
		// résultat de dés pour faire avancer le personnage -> portée globale
		Des nbDe = new Des();
		int scoreDes;
		int position = 0;
		int ligne = 1;
		
		
		// lancer les dés : de 1 à 6
		public void lancerDes() {

			do {
				scoreDes = nbDe.lancerDe();
				position += scoreDes; // additionne les deux var et stocke le résultat dans var gauche -> position + resultatDe = position
				System.out.println("le résultat de votre lancer de dés est : " + scoreDes + " - la position de votre personnage est : " + position);
				avancer();
			}while(position <= 0); // lance automatiquement 1 fois ce bloc de code - revoir cette boucle
			 
		}
		//relier le scoreDes avec le nombre de déplacement possible du personnage

		
		// résultat de l'avancée du joueur sur le plateau -> placement sur plateau 
		public void avancer() {
			
			int direction;
			Scanner clavier = new Scanner(System.in);
			System.out.println("Faites avancer votre personnage de " + scoreDes +  " : 1 bas - 2 droite - 3 haut V - 4 gauche V");
			direction = clavier.nextInt();

			// faire choix entre 1 ou 2 ou 3 ou 4
			switch (direction) {
			case 1:
				//plateau.deplacerB();
				//plateau.afficher();
				System.out.println("votre personnage est descendu de " + scoreDes + " et est maintenant en position : " + position);
				break;

			case 2:
				//plateau.deplacerD();
				//plateau.afficher();
				System.out.println("votre personnage est allé à droite de " + scoreDes + " et est maintenant en position : " + position);
				break;

			case 3:
				//plateau.deplacerH();
				//plateau.afficher();
				System.out.println("votre personnage est monté de " + scoreDes + " et est maintenant en position : " + position);
				break;
				
			case 4:
				//plateau.deplacerG();
				//plateau.afficher();
				System.out.println("votre personnage est allé à gauche de " + scoreDes + " et est maintenant en position : " + position);
				break;
				
			default:
				System.out.println("Erreur sélection");
				break;
			}
			//clavier.close(); -> !!! provoque une erreur car referme la saisie clavier alors qu'elle doit continuer pour le menuJeu()
			
			menuJeu();
		}
		
		/*
		public void placerElement() {
			
			// placer les personnages
			//plateau.placer(ligne, position, 'lettre');
			plateau.placer(2, 4, 'X');

			
			//placer les éléments de manière aléatoire à chaque début de partie
			// placer des ennemis
			plateau.placer(8, 6, 'E');
			plateau.placer(5, 8, 'E');
			//plateau.placer(4, 4, 'E');
			plateau.placer(6, 6, 'B');
			
			//placer des tours
			plateau.placer(1, 8, 'T');
			plateau.placer(8, 8, 'T');
			plateau.placer(1, 1, 'T');
			plateau.placer(8, 1, 'T');
			
			// placer des objets
			plateau.placer(2, 7, 'O');
			plateau.placer(5, 4, 'O');
			plateau.placer(6, 1, 'O');
			plateau.placer(7, 3, 'O');
			
			// placer arrivée = A
			plateau.placer(7, 6, 'A');
			//System.out.print(plateau.getCase(30, 16)); // test pour voir si les paramètres rentrés affiche bien 'A' via le getCase
			
			//plateau.afficher();
			//plateau.deplacerB();
			//plateau.afficher();
		*/
		}

//}