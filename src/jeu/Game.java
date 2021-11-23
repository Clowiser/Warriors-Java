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
	Menu menu; // ! -> c'est le game qui appelle le menu, pas l'inverse => quand on lance un jeu, c'est le jeu qu'on lance dans lequel il nous affiche un menu qui sert d'interaction
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
		//MENUS
		//menu principal du jeu (affichage des directives dans le menu)
		public void initGame() {
			boolean isRunning = false; 
	
			while(!isRunning) { // while (isRunning = true) / rappel while (!isRunning) = opposé de la déclaration (si isRunning = false alors !isRunning = true)
				
				menu.afficherMenuPrincipal(); // appel de la méthode afficherMenuPrincipal()
				
				int choixMenu = menu.entreeClavier(""); // appel de la fonction qui permet le scanner clavier
				
				switch (choixMenu) {
				case 1:
					// Appel de la fonction createPerso()
					createPerso();
					break;
		
				case 2:
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
			
			System.out.println("1 - Lancer le dés - 2 - Quitter la partie : retour au menu principal - 3 clearPerso"); 
			
			int choix = menu.entreeClavier("");
			
			// faire choix entre 1 ou 2 ou 3
			switch (choix) {
			case 1:
				try {
					lancerDes();
				} catch (PersonnageHorsPlateauException e) {
					System.out.println(e.getMessage());// affiche le message
					System.out.println("");
					menuJeu();
					//e.printStackTrace(); // affiche l'erreur en "rouge" - erreur exception
					//essaie lancerDes() + attrape l'erreur créé en classe, pour afficher le message noté dans la classe (via getMessage()) soit en exception directement
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
				System.out.println("Erreur sélection - TEST");
				initGame();
				break;
			
			}
		}
		
		//Menu création personnages
		public void createPerso() {
			int choix = 0;
			
			if(guerrierListe.size() == 0 || magicienListe.size() == 0) {
				choix = menu.entreeClavier("Créer son personnage : 1 pour Guerrier - 2 pour Magicien - 3 Démarrer la partie - 4 Récapitulatif des personnages - 5 Quitter la création de personnage : retour au menu principal ");
			}
			
				switch (choix) {
				case 1:
					Guerrier joueurG = menu.createGuerrier();
					
					// mettre données dans liste
					guerrierListe.add(joueurG); // pour ajouter un objet (joueurG ici en l'occurrence) dans la liste guerrierListe
					createPerso();
					break;
	
				case 2:
					// Appel de la fonction createMagicien() de l'instance menu de la classe Magicien
					Magicien joueurM = menu.createMagicien();
					
					magicienListe.add(joueurM); // ajout à la liste magicienListe
					createPerso();
					break;
					
				case 3:
					start();
	
				case 4:
					afficherListe();
					System.out.println("");
					createPerso();
					break;
					
				case 5:
					System.out.println("Vous avez quitté la création de personnage - retour au menu principal");
					menu.afficherMenuPrincipal();
					break;
	
				default:
					System.out.println("Erreur création personnages");
					break;
				}
		
}
		
		//afficher la liste des personnages créés
		public void afficherListe() {
			
			//liste des guerriers créés
			if(guerrierListe.size() == 0 && magicienListe.size() == 0) {
				System.out.println("Aucun personnage - Veuillez créer votre personnage pour commencer l'Aventure !");
				System.out.println("");
				createPerso();
			}
			
			if(guerrierListe.size() == 1 || magicienListe.size() == 1) {
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
			
		
		
		
		//DEMARRAGE DE LA PARTIE
		//récupérer le personnage créé
		public void recupPersoCreer() {
			
			if(guerrierListe.size() == 1) {
				guerrierListe.get(0); // récupère les informations du premier guerrier - index 0 - (via instance) créé par l'utilisateur  = 1 personne pour le moment
				System.out.println("");
				System.out.println("Vous jouez avec votre Guerrier " + guerrierListe.get(0).getNom()); // affichage le nom du guerrierListe
				//System.out.println(guerrierListe.get(0)); // affichage
				//guerrierListe.get(0).getNom(); // récupère le nom du guerrierListe avec index 0 -> récupérer la valeur d'un élément dans ArrayList en Java
			}
			
			if (magicienListe.size() == 1) {
				magicienListe.get(0); // récupère les informations du premier magicien - index 0
				System.out.println("");
				System.out.println("Vous jouez avec votre Magicien " + magicienListe.get(0).getNom()); // affichage le nom du magicienListe
				//System.out.println(magicienListe.get(0));
			}
			
		}
		
		
		//démarrer
		public void start(){
		
			if(guerrierListe.size() == 0 && magicienListe.size() == 0) {
				System.out.println("Veuillez créer votre personnage pour commencer l'Aventure !");
				System.out.println("");
				createPerso();
			}
			
			if(guerrierListe.size() == 1 || magicienListe.size() == 1) {
				recupPersoCreer();
			}
			
			// affichage du plateau
			menu.afficherPlateau(plateau);
			System.out.println("");
			
			interaction();
			//testAffichage.afficherPlat(); // test
			
			menuJeu();
			
			return;
		}
		
		
		//lancer les dés
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
		
		//avancer
		public void avancer() throws PersonnageHorsPlateauException  { 
			////throws (avec S ) = permet de relayer le traitement de l'exception à la méthode appelante
			
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
					positionJoueur = 0; // remise à 0 de la position du joueur
					System.out.println("");
					throw new PersonnageHorsPlateauException(); // throw (sans S) = permet de déclencher une erreur
				}
				break;

			default:
				System.out.println("Erreur sélection");
				break;
			}

		}
		
		//interaction
		public void interaction() {

			Case Case1 = plateau.idCasePlateau(0); // Classe Case nom => objet du plateau avec index
			Case Case2 = plateau.idCasePlateau(1);
			Case Case3 = plateau.idCasePlateau(2);
			Case Case4 = plateau.idCasePlateau(3);
			Case Case5 = plateau.idCasePlateau(4);
			Case Case6 = plateau.idCasePlateau(5);
			Case Case7 = plateau.idCasePlateau(6);
			Case Case8 = plateau.idCasePlateau(7);
			Case Case9 = plateau.idCasePlateau(8);
			Case Case10 = plateau.idCasePlateau(9);
			Case Case11 = plateau.idCasePlateau(10);
			Case Case12 = plateau.idCasePlateau(11);
			Case Case13 = plateau.idCasePlateau(12);
			Case Case14 = plateau.idCasePlateau(13);
			Case Case15 = plateau.idCasePlateau(14);
			Case Case16 = plateau.idCasePlateau(15);
			Case Case17 = plateau.idCasePlateau(16);
			Case Case18 = plateau.idCasePlateau(17);
			Case Case19 = plateau.idCasePlateau(18);
			Case Case20 = plateau.idCasePlateau(19);
			
			//System.out.println(Personnage);
			System.out.println("| " + Case1 + " | " + Case2  + " | " + Case3  + " | " + Case4  + " | " + Case5  + " | " + Case6  + " | " + Case7  + " | " + Case8  + " | " + Case9  + " | " + Case10 + 
					" | " + Case11 + " | " + Case12  + " | " + Case13  + " | " + Case14  + " | " + Case15  + " | " + Case16  + " | " + Case17  + " | " + Case18  + " | " + Case19  + " | " + Case20 + " | ");
			
			//plateau.afficherCases();
			System.out.println("");
			
			if(positionJoueur == 0) {
				System.out.println("Vous êtes sur la case Départ");
				System.out.println("");
			}else if(positionJoueur == 3 || positionJoueur == 7) {
				System.out.println("Vous êtes sur une case Vide");	
				System.out.println("");
			}else if(positionJoueur == 1 || positionJoueur == 4 || positionJoueur == 6 || positionJoueur == 8) {
				System.out.println("Vous êtes sur une case Trésor - 8 Ouvrir - 9 Laisser");
				System.out.println("");
			}else if(positionJoueur == 2 || positionJoueur == 5 || positionJoueur == 9 || positionJoueur == 10 || positionJoueur == 13 || positionJoueur == 18) {
				System.out.println("Vous êtes sur une case Ennemi ! Combat ! - 8 Combattre - 9 Fuir");
				menucombat();
				System.out.println("");
			}
		}
		
		//garder le même personnage ou recréer un nouveau personnage
		public void clearPerso() {
			System.out.println("Voulez vous recommencer la partie avec votre personnage ? 1 oui - 2 non retour au menu principal ");
			
			int choix = menu.entreeClavier("");
			
			// faire choix entre 1 ou 2
			switch (choix) {
			case 1:
				start();
				break;
	
			case 2:
				guerrierListe.remove(0); //suppression guerrier à l'index 0
				magicienListe.remove(0);
				System.out.println("Votre personnage a été supprimé - retour au menu principal");
				initGame(); 
				break;
	
			default:
				System.out.println("Erreur sélection");
				break;
			
			}
			
		}
		
		//COMBATS
		//Tour par tour
		//tour : attaque ou fuir
		//ennemi attaque
		//si fuite -> reculer de 1 à 6
		
		public void menucombat() {
			int choix = menu.entreeClavier("");
			
			switch (choix) {
			case 8:
				interactionCombat();
				break;

			case 9:
				//revenir au jeu + lancés de dés ramdom qui fait RECULER
				break;

			default:
				System.out.println("Erreur sélection");
				break;
			}
		}
		
		//test
		Gobelin gobelinTest;
		public void interactionCombat() {
			//prendre niveau de vie + niveau de force du personnage -> Guerrier/magicien
			//prendre niveau de vie + niveau de force de l'ennemi -> Gobelins/sorcières/dragons
			
			//joueur
			guerrierListe.get(0);
			guerrierListe.get(0).getNiveau(); // récupe vie
			guerrierListe.get(0).getForce(); // récupe force
			
			//ennemi
			gobelinTest = new Gobelin();
			gobelinTest.getForce();
			gobelinTest.getNiveau();
			
			System.out.println("Votre Ennemi dispose de " + gobelinTest.getForce() + " de force d'attaque et de " + gobelinTest.getNiveau() + " points de vie.");
			
			System.out.println("Votre Personnage dispose de " + guerrierListe.get(0).getForce() + " de force d'attaque et de " + guerrierListe.get(0).getNiveau() + " points de vie.");
			
			System.out.println("");
			
			
			System.out.println("A votre tour, Aventurier !");
			attaqueJoueur();
			
			if(totalAtkJoueur > 0) {
			System.out.println("Au tour de l'ennemi !");
			attaqueEnnemi();
			}else if (totalAtkJoueur <= 0) {
				System.out.println("L'ennemi  est mort !");
			}
			
		}
		
		//Joueur attaque toujours en premier
		int totalAtkJoueur;
		public void attaqueJoueur() {
			
			totalAtkJoueur = guerrierListe.get(0).getForce() - gobelinTest.getNiveau();
			
			System.out.println("Il reste " + totalAtkJoueur + " à l'ennemi");
			
			//System.out.println("Voulez-vous continuer ou fuir ? - 8 Rester - 9 Fuir");
			
			// if joueurRest => System.out.println("Vous avez choisi de rester !");
			
		
			
		}
		
		int totalAtkEnnemi;
		public void attaqueEnnemi() {
			
			if(totalAtkJoueur > 0) {
			
			totalAtkEnnemi = gobelinTest.getForce() - guerrierListe.get(0).getNiveau();
			
			System.out.println("Il vous reste " + totalAtkEnnemi);
			
			}
			
		}
		
		
		
	
}