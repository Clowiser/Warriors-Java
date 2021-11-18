package jeu;

import java.util.Scanner;
//import jeu.Plateau;
//import jeu.EmptyCase;
//import jeu.CreationPersonnage;


//game g�re le fait de quitter le jeu
//game g�re le d�marrage de la partie 
//game g�re la cr�ation de personnage
//et il appelle le menu quand il a une demande � faire � l'utilisateur


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
	
		
	// Menu du jeu : lancer les d�s - avancer - passer joueur suivant
		public void menuJeu() {
			// menu en jeu
			int choix;
			
			if(positionJoueurFin < positionJoueur) {
			System.out.println("1 - Lancer le d�s");
			}
			if(positionJoueurFin+1 > positionJoueur ) {
			System.out.println("2 - Quitter la partie : retour au menu principal"); 
			}
			
			// ajouter "Passer au joueur suivant" ou "case �v�nement" quand le J1 a fini son tour (1 lancer de d�s)
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
				System.out.println("Vous avez quitt� la partie - retour au menu principal");
				System.out.println("");
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
			//menu du jeu -> lancer les d�s ou Quitter en fonction de ou se trouve le joueur
			menuJeu();
		}

		// affichage du plateau
		public void afficherPlateau() {
			System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les d�s pour commencer l'aventure !");
			
			testAffichage.afficherPlat(); // test
			
			System.out.println("Infos : la taille du plateau est de " + plateau.size() + " cases.");
			System.out.println("");
			System.out.println("- Appuyez sur 1 pour faire le premier jet de d�s -");
		}

		
		// lancer les d�s
		public void lancerDes() throws PersonnageHorsPlateauException {
		
			if(positionJoueur <= plateau.size()) {
				scoreDes = nbDe.lancerDe();
				positionJoueur += scoreDes; // additionne les deux var et stocke le r�sultat dans var gauche -> positionJoueur + resultatDe = positionJoueur
				System.out.println("Le r�sultat de votre lancer de d�s est : " + scoreDes + ".");
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
		       System.out.println(e.getMessage()); // throw (sans S) = permet de d�clencher une erreur
		    }
		}
		//throws (avec S ) = permet de relayer le traitement de l'exception � la m�thode appelante
		 * */
		 

				
		// avancer le joueur : r�sultat de l'avanc�e du joueur sur le plateau + placement sur plateau 
		public void avancer() throws PersonnageHorsPlateauException  {
			
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
					positionJoueur = positionJoueurFin; // 1 - la positon joueur est �gale � sa position de fin (voir autre mani�re de r�cup�rer)
					System.out.println("");
					throw new PersonnageHorsPlateauException();
		
				}
			
				break;

			default:
				System.out.println("Erreur s�lection");
				break;
			}
			
			//clavier.close(); -> !!! Infos : ne pas mettre car provoque une erreur car referme la saisie clavier alors qu'elle doit continuer pour le menuJeu()

		}
		
		
		//choix personnage cr��
		
		
		public void choixPersonnage() {
			
		}
		
		
		public void interaction() {
			
		}

}