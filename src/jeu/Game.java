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
		//Plateau testAffichage = new Plateau(1, 10); // juste un affichage lambda 
	Des nbDe;
	Plateau plateau; 
	Menu menu; // ! -> c'est le jeu qui appelle le menu, pas l'inverse
	ArrayList<Guerrier> guerrierListe;
	ArrayList<Magicien> magicienListe;
	
	
	//constructeurs -> fonction appelée lors de l'instanction d'objet
	public Game() {
		this.plateau = new Plateau();
		this.guerrierListe =  new ArrayList<>();
		this.magicienListe = new ArrayList<>();
		this.menu = new Menu();
		this.nbDe = new Des();
	}
	
		//Méthodes
		//menu principal du jeu (affichage des directives dans le menu)
		public void initGame() {
			boolean isRunning = false; 
	
			while(!isRunning) { // while (isRunning = true) / rappel while (!isRunning) = opposé de la déclaration (si isRunning = false alors !isRunning = true)
				
				menu.afficherMenuPrincipal(); // appel de la méthode afficherMenuPrincipal()
				
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
					System.out.println("Vous avez quitté le jeu Warrios Game. A bientôt pour de nouvelles aventures !");
					isRunning = true;
					break;
			
				default:
					System.out.println("Erreur de selection");
					break;
				}
			}
					
		}
			
			
		// Menu du jeu : lancer les dés - avancer - passer joueur suivant
		public void menuJeu() {
			
			/*if(positionJoueurFin < positionJoueur) {
			System.out.println("1 - Lancer le dés");
			}
			if(positionJoueurFin+1 > positionJoueur ) {
				clearPerso();
			System.out.println("2 - Quitter la partie : retour au menu principal"); 
			}*/
			
			System.out.println(" 1 - Lancer le dés - 2 - Quitter la partie : retour au menu principal - 3 clearPerso"); 
			
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
				System.out.println("Vous avez quitté la partie - retour au menu principal");
				System.out.println("");
				initGame();
				break;
				
			case 3:
				clearPerso();
	
			default:
				System.out.println("Erreur sélection TEST");
				break;
			
			}
		}
			
		//char JoueurG = 'G';
		//démarrage de la partie
		public void recupPersoCreer() {
			guerrierListe.get(0); // récupère les informations du premier guerrier - index 0 - (via instance) créé par l'utilisateur  = 1 personne pour le moment
			System.out.println(guerrierListe.get(0)); // affichage
			
			//guerrierListe.get(0).getNom(); // récupère le nom du guerrierListe avec index 0 -> récupérer la valeur d'un élément dans ArrayList en Java
			
			
			/*magicienListe.get(0); // récupère les informations du premier magicien - index 0
			System.out.println(magicienListe.get(0));
			*/
		}
		
		public void choisirPersoPourJouer() {
			
			
			
			
		}
		
		public void start(){
		
			recupPersoCreer();
			
			// affichage du plateau
			menu.afficherPlateau(plateau);
			System.out.println("");
			
			interaction();
			//testAffichage.afficherPlat(); // test
			
			menuJeu();
			
			return;
		}
		
		
		// lancer les dés
		public void lancerDes() throws PersonnageHorsPlateauException {
			
			// avancer le joueur : résultat de l'avancée du joueur sur le plateau + placement sur plateau
			if(positionJoueur <= plateau.size()) {
				scoreDes = nbDe.lancerDe();
				positionJoueur += scoreDes; // additionne les deux var et stocke le résultat dans var gauche -> positionJoueur + resultatDe = positionJoueur
				System.out.println("Le résultat de votre lancer de dés est : " + scoreDes + ".");
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
				System.out.println("Votre personnage a avancé de " + scoreDes + " cases et est maintenant en position : " + positionJoueur);
				System.out.println("");
				interaction();
				
					if(positionJoueur > plateau.size()) {
					positionJoueur = plateau.size();
					System.out.println("Bravo Aventurier ! Vous avez atteint l'Aventure du Dungeons & Dragons !");
					positionJoueur = positionJoueurFin; // 1 - la positon joueur est égale à sa position de fin (voir autre manière de récupérer)
					
					System.out.println("");
					throw new PersonnageHorsPlateauException(); // exception
				}
				break;

			default:
				System.out.println("Erreur sélection");
				break;
			}

		}
		
		public void interaction() {
			
			//Case Personnage = plateau.idCase(positionJoueur); met une case en plus /!\

			Case Case1 = plateau.idCase(0);
			Case Case2 = plateau.idCase(1);
			Case Case3 = plateau.idCase(2);
			Case Case4 = plateau.idCase(3);
			Case Case5 = plateau.idCase(4);
			Case Case6 = plateau.idCase(5);
			Case Case7 = plateau.idCase(6);
			Case Case8 = plateau.idCase(7);
			Case Case9 = plateau.idCase(8);
			Case Case10 = plateau.idCase(9);
			
			
			//" | " + Personnage +
			//System.out.println(Personnage);
			System.out.println("| " + Case1 + " | " + Case2  + " | " + Case3  + " | " + Case4  + " | " + Case5  + " | " + Case6  + " | " + Case7  + " | " + Case8  + " | " + Case9  + " | " );
			
			//plateau.afficherCases();
			System.out.println("");
			
			if(positionJoueur == 0) {
				System.out.println("Vous êtes sur la case Départ");
				System.out.println("");
			}else if(positionJoueur == 3 || positionJoueur == 7) {
				System.out.println("Vous êtes sur une case vide");	
				System.out.println("");
			}else if(positionJoueur == 1 || positionJoueur == 4 || positionJoueur == 6 || positionJoueur == 8) {
				System.out.println("Vous êtes sur une case trésor");
				System.out.println("");
			}else if(positionJoueur == 2 || positionJoueur == 5 || positionJoueur == 9) {
				System.out.println("Vous êtes sur une case Ennemi");
				System.out.println("");
			}
		}
		
		//garder le personnage ou reprendre un nouveau perso
		public void clearPerso() {
			System.out.println("Voulez vous recommencer la partie avec votre personnage ? 1 oui - 2 non retour au menu principal ");
			
			int choix = menu.entreeClavier("");
			
			// faire choix entre 1 ou 2
			switch (choix) {
			case 1:
				// Appel de la fonction lancerDes()
				start();
				break;
	
			case 2:
				guerrierListe.remove(0);
				System.out.println("Votre personnage a été supprimé - retour au menu principal");
				initGame(); 
				break;
	
			default:
				System.out.println("Erreur sélection");
				break;
			
			}
			
		}
		
		
		//Personnages
		public void createPerso() {
			int choix = 0;
			
			/*if(guerrierListe.size() == 1 || magicienListe.size() == 1) {
				choix = menu.entreeClavier("3 Démarrer la partie - 4 Récapitulatif des personnages - 5 Quitter la création de personnage : retour au menu principal");
			}*/
			
			if(guerrierListe.size() == 0 || magicienListe.size() == 0) {
				choix = menu.entreeClavier("Créer son personnage : 1 pour Guerrier - 2 pour Magicien - 3 Démarrer la partie - 4 Récapitulatif des personnages - 5 Quitter la création de personnage : retour au menu principal ");
			}
			
				switch (choix) {
				case 1:
					Guerrier joueurG = menu.createGuerrier(); //
					
					// mettre données dans liste
					guerrierListe.add(joueurG); // pour ajouter un objet (joueurG ici en l'occurrence) dans la liste guerrierListe
					createPerso();
					break;
	
				case 2:
					// Appel de la fonction Magicien
					Magicien joueurM = menu.createMagicien();
					
					// mettre données dans liste
					magicienListe.add(joueurM); // ajout à la liste magicienListe
					createPerso();
					break;
					
				case 3:
					//appel de la méthode start
					start();
	
				case 4:
					afficherListe();
					System.out.println("");
					createPerso();
					break;
					
				case 5:
					System.out.println("Vous avez quitté la création de personnage - retour au menu principal");
					break;
	
				default:
					System.out.println("Erreur création personnages");
					break;
				}
		
}

		
		
		public void afficherListe() {
			
			//liste des guerriers créés
			System.out.println("Récapitulatif de vos guerriers : ");
			for (int i = 0; i < guerrierListe.size(); i++) {
				System.out.println(guerrierListe.get(i)); // toString() est présent par défaut, là je défini moi-même ma méthode toString() dans Personnage pour annuler cet affichage par défaut (blabla@1d25g5qf2)
			}
			
			System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " élément(s)"); // pour afficher le nombre d'éléments dans la liste
			
			//liste des magiciens créés
			System.out.println("Récapitulatif de vos magiciens : ");
			for (int i = 0; i < magicienListe.size(); i++) {
				System.out.println(magicienListe.get(i));
			}

			System.out.println("La liste de Magicien contient " + magicienListe.size() + " élément(s)"); // pour afficher le nombre d'éléments dans la liste
	}
}