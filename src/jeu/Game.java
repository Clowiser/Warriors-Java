package jeu;

import java.util.Scanner;
//import jeu.Plateau;
//import jeu.EmptyCase;
//import jeu.CreationPersonnage;


//game gère le fait de quitter le jeu
//game gère le démarrage de la partie 
//game gère la création de personnage
//et il appelle le menu quand il a une demande à faire à l'utilisateur


public class Game {

	// attributs
	Plateau plateau; 
	Des nbDe = new Des();
	int scoreDes;
	int positionJoueur = 0;
	int positionJoueurFin;
	
	Scanner clavier = new Scanner(System.in);
	Plateau testAffichage = new Plateau(10, 10); // juste un affichage lambda 
	
	//Menu menu = new Menu();
	
	//CreationPersonnage choix = new CreationPersonnage(); // lance le choix du personnage - nouveau + stock info
	//Game game = new Game(); // lance une partie - nouvelle + stock info
		
	
	//constructeurs
	public Game() {
		this.plateau = new Plateau();
	}
	
	//appel du menu
	/*public void menuTest() {
		menu.menuPrincipal();
	}*/
	
		
	// Menu du jeu : lancer les dés - avancer - passer joueur suivant
		public void menuJeu() {
			// menu en jeu
			int choix;
			
			if(positionJoueurFin < positionJoueur) {
			System.out.println("1 - Lancer le dés");
			}
			if(positionJoueurFin+1 > positionJoueur ) {
			System.out.println("2 - Quitter la partie : retour au menu principal"); 
			}
			
			// ajouter "Passer au joueur suivant" ou "case événement" quand le J1 a fini son tour (1 lancer de dés)
			choix = clavier.nextInt();
			
			// faire choix entre 1 ou 2
			switch (choix) {
			case 1:
				// Appel de la fonction lancerDes()
				try {
					lancerDes();
				} catch (PersonnageHorsPlateauException e) {
					System.out.println(e.getMessage());// affiche le message
					System.out.println("");
					menuJeu();
					//e.printStackTrace(); // affiche l'erreur en rouge
				}
				break;

			case 2:
				System.out.println("Vous avez quitté la partie - retour au menu principal");
				System.out.println("");
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
			//menu du jeu -> lancer les dés ou Quitter en fonction de ou se trouve le joueur
			menuJeu();
		}

		// affichage du plateau
		public void afficherPlateau() {
			System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les dés pour commencer l'aventure !");
			
			testAffichage.afficherPlat(); // test
			
			System.out.println("Infos : la taille du plateau est de " + plateau.size() + " cases.");
			System.out.println("");
			System.out.println("- Appuyez sur 1 pour faire le premier jet de dés -");
		}

		
		// lancer les dés
		public void lancerDes() throws PersonnageHorsPlateauException {
		
			if(positionJoueur <= plateau.size()) {
				scoreDes = nbDe.lancerDe();
				positionJoueur += scoreDes; // additionne les deux var et stocke le résultat dans var gauche -> positionJoueur + resultatDe = positionJoueur
				System.out.println("Le résultat de votre lancer de dés est : " + scoreDes + ".");
				System.out.println("");
				avancer();
				menuJeu();
			}
			
		}
		
		//exception mais j'ai pas vraiment compris -> voir avec le formateur
		/*
		 * public void leverException() throws PersonnageHorsPlateauException {
			try {
		    if(positionJoueur >= plateau.size()) {
		    	throw new PersonnageHorsPlateauException();
		    }
			}catch (PersonnageHorsPlateauException e){
		       System.out.println(e.getMessage()); // throw (sans S) = permet de déclencher une erreur
		    }
		}
		//throws (avec S ) = permet de relayer le traitement de l'exception à la méthode appelante
		 * */
		 

				
		// avancer le joueur : résultat de l'avancée du joueur sur le plateau + placement sur plateau 
		public void avancer() throws PersonnageHorsPlateauException  {
			
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
					positionJoueur = positionJoueurFin; // 1 - la positon joueur est égale à sa position de fin (voir autre manière de récupérer)
					System.out.println("");
					throw new PersonnageHorsPlateauException();
		
				}
			
				break;

			default:
				System.out.println("Erreur sélection");
				break;
			}
			
			//clavier.close(); -> !!! Infos : ne pas mettre car provoque une erreur car referme la saisie clavier alors qu'elle doit continuer pour le menuJeu()

		}
		
		
		//choix personnage créé
		
		
		public void choixPersonnage() {
			
		}
		
		
		public void interaction() {
			
		}

}