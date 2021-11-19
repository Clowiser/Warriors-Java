package jeu;

import java.util.ArrayList;
//import jeu.Plateau;
//import jeu.EmptyCase;
//import jeu.CreationPersonnage;


public class Game {

	// attributs
	int scoreDes;
	int positionJoueur = 0;
	int positionJoueurFin; // tricherie !!
		Plateau testAffichage = new Plateau(10, 10); // juste un affichage lambda 
	Des nbDe;
	Plateau plateau; 
	Menu menu; // ! -> c'est le jeu qui appelle le menu, pas l'inverse
	ArrayList<Guerrier> guerrierListe;
	ArrayList<Magicien> magicienListe;
	
	
	//constructeurs
	public Game() {
		this.plateau = new Plateau();
		this.guerrierListe =  new ArrayList<>();
		this.magicienListe = new ArrayList<>();
		this.menu = new Menu();
		this.nbDe = new Des();
	}
	
		//M�thodes
	
		//menu principal du jeu (affichage des directives dans le menu)
		public void initGame() {
			boolean isRunning = false; 
	
			while(!isRunning) { // while (isRunning = true) / rappel while (!isRunning) = oppos� de la d�claration (si isRunning = false alors !isRunning = true)
				
				menu.afficherMenuPrincipal(); // appel de la m�thode afficherMenuPrincipal()
				
				int choixMenu = menu.entreeClavier(""); // appel de la fonction qui permet le scanner clavier
				
				switch (choixMenu) {
				case 1:
					// Appel de la fonction choicePerso()
					createPerso();
					break;
		
				case 2:
					// Appel de la fonction start()
					start();
					
					break;
		
				case 3:
					System.out.println("Vous avez quitt� le jeu Warrios Game. A bient�t pour de nouvelles aventures !");
					isRunning = true;
					break;
			
				default:
					System.out.println("Erreur de selection");
					break;
				}
			}
					
		}
			
			
		// Menu du jeu : lancer les d�s - avancer - passer joueur suivant
		public void menuJeu() {
			// menu en jeu
			if(positionJoueurFin < positionJoueur) {
			System.out.println("1 - Lancer le d�s");
			}
			if(positionJoueurFin+1 > positionJoueur ) {
			System.out.println("2 - Quitter la partie : retour au menu principal"); 
			}
			
			int choix = menu.entreeClavier("");
			
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
					//e.printStackTrace(); // affiche l'erreur en "rouge"
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
			menu.afficherPlateau(plateau);
			testAffichage.afficherPlat(); // test
			//menu du jeu -> lancer les d�s ou Quitter en fonction de ou se trouve le joueur
			menuJeu();
			
			return;
		}
		
		
		// lancer les d�s
		public void lancerDes() throws PersonnageHorsPlateauException {
			
			// avancer le joueur : r�sultat de l'avanc�e du joueur sur le plateau + placement sur plateau
			if(positionJoueur <= plateau.size()) {
				scoreDes = nbDe.lancerDe();
				positionJoueur += scoreDes; // additionne les deux var et stocke le r�sultat dans var gauche -> positionJoueur + resultatDe = positionJoueur
				System.out.println("Le r�sultat de votre lancer de d�s est : " + scoreDes + ".");
				System.out.println("");
				avancer();
				menuJeu();
			}
			
		}
		
		// avancer
		public void avancer() throws PersonnageHorsPlateauException  {
			
			int direction;
		
			direction = menu.entreeClavier("1 - Faites avancer votre personnage de " + scoreDes + " cases."); //direction = menu.nomfonction();

			// faire choix
			switch (direction) {
			case 1:
				//plateau.afficher();
				System.out.println("Votre personnage a avanc� de " + scoreDes + " cases et est maintenant en position : " + positionJoueur);
				System.out.println("");
				
					if(positionJoueur > plateau.size()) {
					positionJoueur = plateau.size();
					System.out.println("Bravo Aventurier ! Vous avez atteint l'Aventure du Dungeons & Dragons !");
					positionJoueur = positionJoueurFin; // 1 - la positon joueur est �gale � sa position de fin (voir autre mani�re de r�cup�rer)
					System.out.println("");
					throw new PersonnageHorsPlateauException(); // exception
				}
				break;

			default:
				System.out.println("Erreur s�lection");
				break;
			}

		}
				
		
		
		//Personnages
		public void createPerso() {
			int choix = 0;
			
			/*if(guerrierListe.size() == 1 || magicienListe.size() == 1) {
				choix = menu.entreeClavier("3 D�marrer la partie - 4 R�capitulatif des personnages - 5 Quitter la cr�ation de personnage : retour au menu principal");
			}*/
			
			if(guerrierListe.size() == 0 || magicienListe.size() == 0) {
				choix = menu.entreeClavier("Cr�er son personnage : 1 pour Guerrier - 2 pour Magicien - 3 D�marrer la partie - 4 R�capitulatif des personnages - 5 Quitter la cr�ation de personnage : retour au menu principal ");
			}
			
				switch (choix) {
				case 1:
					Guerrier joueurG = menu.createGuerrier(); //
					
					// mettre donn�es dans liste
					guerrierListe.add(joueurG); // pour ajouter un objet (joueurG ici en l'occurrence) dans la liste guerrierListe
					createPerso();
					break;
	
				case 2:
					// Appel de la fonction Magicien
					Magicien joueurM = menu.createMagicien();
					
					// mettre donn�es dans liste
					magicienListe.add(joueurM); // ajout � la liste magicienListe
					createPerso();
					break;
					
				case 3:
					//appel de la m�thode start
					start();
	
				case 4:
					afficherListe();
					createPerso();
					break;
					
				case 5:
					System.out.println("Vous avez quitt� la cr�ation de personnage - retour au menu principal");
					break;
	
				default:
					System.out.println("Erreur cr�ation personnages");
					break;
				}
		
}
		
		
		public void afficherListe() {
			
			//liste des guerriers cr��s
			System.out.println("R�capitulatif de vos guerriers : ");
			for (int i = 0; i < guerrierListe.size(); i++) {
				System.out.println(guerrierListe.get(i)); // toString() est pr�sent par d�faut, l� je d�fini moi-m�me ma m�thode toString() dans Personnage pour annuler cet affichage par d�faut (blabla@1d25g5qf2)
			}
			
			System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " �l�ment(s)"); // pour afficher le nombre d'�l�ments dans la liste
			
			//liste des magiciens cr��s
			System.out.println("R�capitulatif de vos magiciens : ");
			for (int i = 0; i < magicienListe.size(); i++) {
				System.out.println(magicienListe.get(i));
			}

			System.out.println("La liste de Magicien contient " + magicienListe.size() + " �l�ment(s)"); // pour afficher le nombre d'�l�ments dans la liste
	}
}