package jeu;

import java.util.Scanner;

public class Game {

	//ACTIONS
		// d�marrer le jeu - afficher le plateau - lancer les d�s - avancer - passer joueur suivant
		public void menuJeu() {
			// menu en jeu
			int choix;

			Scanner clavier = new Scanner(System.in);
			System.out.println("1 Lancer le d�s - 2 Quitter la partie : retour au menu principal - TEST"); 
			// ajouter "Passer au joueur suivant" ou "case �v�nement" quand le J1 a fini son tour (1 lancer de d�s)
			choix = clavier.nextInt();

			// faire choix entre 1 ou 2 ou 3
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
		
		
		public void start() {
			
			// affichage du plateau
			afficherPlateau();

			menuJeu();
		}

		
		// affichage du plateau
		PlateauJeu plateau = new PlateauJeu(); // param�tres du plateau -> port�e globale
		
		public void afficherPlateau() {
			System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les d�s pour commencer l'aventure !");
			//placerElement();
		}

		
		// r�sultat de d�s pour faire avancer le personnage -> port�e globale
		Des nbDe = new Des();
		int scoreDes;
		int position = 0;
		int ligne = 1;
		
		
		// lancer les d�s : de 1 � 6
		public void lancerDes() {

			do {
				scoreDes = nbDe.lancerDe();
				position += scoreDes; // additionne les deux var et stocke le r�sultat dans var gauche -> position + resultatDe = position
				System.out.println("le r�sultat de votre lancer de d�s est : " + scoreDes + " - la position de votre personnage est : " + position);
				avancer();
			}while(position <= 0); // lance automatiquement 1 fois ce bloc de code - revoir cette boucle
			 
		}
		//relier le scoreDes avec le nombre de d�placement possible du personnage

		
		// r�sultat de l'avanc�e du joueur sur le plateau -> placement sur plateau 
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
				System.out.println("votre personnage est all� � droite de " + scoreDes + " et est maintenant en position : " + position);
				break;

			case 3:
				//plateau.deplacerH();
				//plateau.afficher();
				System.out.println("votre personnage est mont� de " + scoreDes + " et est maintenant en position : " + position);
				break;
				
			case 4:
				//plateau.deplacerG();
				//plateau.afficher();
				System.out.println("votre personnage est all� � gauche de " + scoreDes + " et est maintenant en position : " + position);
				break;
				
			default:
				System.out.println("Erreur s�lection");
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

			
			//placer les �l�ments de mani�re al�atoire � chaque d�but de partie
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
			
			// placer arriv�e = A
			plateau.placer(7, 6, 'A');
			//System.out.print(plateau.getCase(30, 16)); // test pour voir si les param�tres rentr�s affiche bien 'A' via le getCase
			
			//plateau.afficher();
			//plateau.deplacerB();
			//plateau.afficher();
		*/
		}

//}