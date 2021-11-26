package jeu;

import java.util.ArrayList;
//import jeu.Plateau;
//import jeu.EmptyCase;
//import jeu.CreationPersonnage;

public class Game {

	// attributs
	int scoreDes;
	int positionJoueur = 0;
	// Plateau testAffichage = new Plateau(1, 10); // juste un affichage lambda
	Des nbDe;

	Plateau plateau;
	ArrayList<Case> listeCases = new ArrayList<Case>(); // tableau de cases

	Menu menu; // ! -> c'est le game qui appelle le menu, pas l'inverse => quand on lance un jeu, c'est le jeu qu'on lance dans lequel il nous affiche un menu qui sert d'interaction
	ArrayList<Guerrier> guerrierListe;
	ArrayList<Magicien> magicienListe;

	// constructeurs -> fonction appelée lors de l'instanction d'objet
	public Game() {
		this.plateau = new Plateau();
		this.guerrierListe = new ArrayList<>();
		this.magicienListe = new ArrayList<>();
		this.menu = new Menu();
		this.nbDe = new Des();
	}

	// Méthodes
	// MENUS
	// menu principal du jeu (affichage des directives dans le menu)
	public void initGame() {
		boolean isRunning = false;

		while (!isRunning) { // while (isRunning = true) / rappel while (!isRunning) = opposé de la
								// déclaration (si isRunning = false alors !isRunning = true)

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
				System.out.println("Erreur de selection - initGame()");
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
				// e.printStackTrace(); // affiche l'erreur en "rouge" - erreur exception
				// essaie lancerDes() + attrape l'erreur créé en classe, pour afficher le message noté dans la classe (via getMessage()) soit en exception directement
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
			System.out.println("Erreur sélection - menuJeu()");
			break;

		}
	}

	// Menu création personnages
	public void createPerso() {
		int choix = 0;

		choix = menu.entreeClavier(
				"Créer son personnage : 1 pour Guerrier - 2 pour Magicien - 3 Démarrer la partie - 4 Récapitulatif des personnages - 5 Quitter la création de personnage : retour au menu principal ");

		switch (choix) {
		case 1:
			Guerrier joueurG = menu.createGuerrier(); // instance de Guerrier qui est récupérer dans le menu via la méthode createGuerrier()
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

	// afficher la liste des personnages créés
	public void afficherListe() {

		// liste des guerriers créés
		if (guerrierListe.size() == 0 && magicienListe.size() == 0) {
			System.out.println("Aucun personnage - Veuillez créer votre personnage pour commencer l'Aventure !");
			System.out.println("");
			createPerso();
		}

		// PROBLEME : affiche cette partie quand le perso n'est pas clear quand je
		// quitte le jeu
		if (guerrierListe.size() >= 1 || magicienListe.size() >= 1) {
			System.out.println("- Récapitulatif de vos guerriers : ");
			System.out.println("");
			System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " élément(s)"); // pour afficher le nombre d'éléments dans la liste
			System.out.println("");
			for (int i = 0; i < guerrierListe.size(); i++) {
				System.out.println(guerrierListe.get(i)); // toString() est présent par défaut, là je défini moi-même ma
															// méthode toString() dans Personnage pour annuler cet
															// affichage par défaut (blabla@1d25g5qf2)
			}
			System.out.println("");

			// liste des magiciens créés
			System.out.println("- Récapitulatif de vos magiciens : ");
			System.out.println("");
			System.out.println("La liste de Magicien contient " + magicienListe.size() + " élément(s)"); // pour afficher le nombre d'éléments dans la liste
																											
			System.out.println("");
			for (int i = 0; i < magicienListe.size(); i++) {
				System.out.println(magicienListe.get(i));
			}
			System.out.println("");

		}

	}

	// DEMARRAGE DE LA PARTIE
	// récupérer le personnage créé
	public void recupPersoCreer() {

		if (guerrierListe.size() == 1) {
			guerrierListe.get(0); // récupère les informations du premier guerrier - index 0 - (via instance) créé
									// par l'utilisateur = 1 personne pour le moment
			System.out.println("");
			System.out.println("Vous jouez avec votre Guerrier " + guerrierListe.get(0).getNom()); // affichage le nom
																								// du guerrierListe
			// System.out.println(guerrierListe.get(0)); // affichage
			// guerrierListe.get(0).getNom(); // récupère le nom du guerrierListe avec index
			// 0 -> récupérer la valeur d'un élément dans ArrayList en Java
		}

		if (magicienListe.size() == 1) {
			magicienListe.get(0); // récupère les informations du premier magicien - index 0
			System.out.println("");
			System.out.println("Vous jouez avec votre Magicien " + magicienListe.get(0).getNom()); // affichage le nom
																									// du magicienListe
			// System.out.println(magicienListe.get(0));
		}

	}

	// démarrer
	public void start() {

		if (guerrierListe.size() == 0 && magicienListe.size() == 0) {
			System.out.println("Veuillez créer votre personnage pour commencer l'Aventure !");
			System.out.println("");
			createPerso();
		}

		if (guerrierListe.size() == 1 || magicienListe.size() == 1) {
			recupPersoCreer();
		}

		menu.afficherPlateau(plateau);
		System.out.println("");
		//parcoursPlateau();
		System.out.println();
		menuJeu();
		return;
	}

	// lancer les dés
	public void lancerDes() throws PersonnageHorsPlateauException {

		// avancer le joueur : résultat de l'avancée du joueur sur le plateau +
		// placement sur plateau
		if (positionJoueur <= plateau.size()) {
			scoreDes = nbDe.lancerDe();
			positionJoueur += scoreDes; // additionne les deux var et stocke le résultat dans var gauche ->
										// positionJoueur + resultatDe = positionJoueur
			System.out.println("Le résultat de votre lancer de dés est : " + scoreDes + ".");
			System.out.println("");
			avancer();
			menuJeu();
		}

	}

	/**
	 * test de commentaire pour JavaDoc
	 * 
	 * @throws PersonnageHorsPlateauException
	 */

	
	// avancer
	public void avancer() throws PersonnageHorsPlateauException {
		// throws (avec S ) = permet de relayer le traitement de l'exception à la méthode appelante
		
		int direction;

		direction = menu.entreeClavier("1 - Faites avancer votre personnage de " + scoreDes + " cases."); // direction = menu.nomfonction();

		// faire choix
		switch (direction) {
		case 1:
			// plateau.afficher();
			System.out.println("Votre personnage a avancé de " + scoreDes + " cases et est maintenant en position : "
					+ positionJoueur);
			System.out.println("");
			
			//parcoursPlateau();

			if (positionJoueur >= plateau.size()) {
				// positionJoueur = plateau.size(); // -> n'est plus utile depuis le throw
				System.out.println("Bravo Aventurier ! Vous avez atteint l'Aventure du Dungeons & Dragons !");
				positionJoueur = 0; // remise à 0 de la position du joueur
				System.out.println("");
				throw new PersonnageHorsPlateauException(); // throw (sans S) = permet de déclencher une erreur
			}
			plateau.getUneCase(positionJoueur); // par la position Joueur, je "récupère" ce que la case contient
			System.out.println(plateau.getUneCase(positionJoueur));
			
			break;

		default:
			System.out.println("Erreur sélection");
			break;
		}

	}

	// interaction
	/*public void parcoursPlateau() {

		if (positionJoueur == 0) {
			System.out.println("Vous êtes sur la case Départ");
			System.out.println("");
		} else if (positionJoueur == 3 || positionJoueur == 7 || positionJoueur == 11 || positionJoueur == 14) {
			System.out.println("Vous êtes sur une case Vide");
			System.out.println("");
		} else if (positionJoueur == 1 || positionJoueur == 4) {
			System.out.println("Vous êtes sur une case Trésor - 8 Ouvrir - 9 Laisser");
			System.out.println("");
		} else if (positionJoueur == 6 || positionJoueur == 8) {
		System.out.println("Vous trouver un sort ! Magicien, seul vous pouvez le ramasser !");
		System.out.println("");
		} else if (positionJoueur == 12 || positionJoueur == 15) {
		System.out.println("Vous trouver une arme ! Guerrier, seul vous pouvez la ramasser !");
		System.out.println("");
		} else if (positionJoueur == 2 || positionJoueur == 5 || positionJoueur == 9 || positionJoueur == 10
				|| positionJoueur == 13 || positionJoueur == 16 || positionJoueur == 18 || positionJoueur == 19) {
			System.out.println("Vous êtes sur une case Ennemi ! Combat !");
			//interactionCombat();
			System.out.println("");
		}
	}*/

	// garder le même personnage ou recréer un nouveau personnage
	public void clearPerso() {
		System.out.println(
				"Voulez vous recommencer la partie avec votre personnage ? 1 oui - 2 non retour au menu principal ");

		int choix = menu.entreeClavier("");

		switch (choix) {
		case 1:
			start();
			break;

		case 2:
			guerrierListe.remove(0); // suppression guerrier à l'index 0
			// magicienListe.remove(0);
			System.out.println("Votre personnage a été supprimé - retour au menu principal");
			initGame();
			break;

		default:
			System.out.println("Erreur sélection");
			break;

		}

	}
	


	/*
	// COMBATS
	// Tour par tour
	// tour : attaque ou fuir
	// ennemi attaque
	// si fuite -> reculer de 1 à 6

	// test qu'avec le Guerrier
	// Gobelin gobelinTest;
	public void interactionCombat() {
		// prendre niveau de vie + niveau de force du personnage -> Guerrier/magicien
		// prendre niveau de vie + niveau de force de l'ennemi ->
		// Gobelins/sorcières/dragons

		// joueur
		guerrierListe.get(0);
		guerrierListe.get(0).getNiveau(); // récupe vie
		guerrierListe.get(0).getForce(); // récupe force

		// ennemi - récupérer niveau/force
		// NON car deux instances : gobelinTest = new Gobelin(); // instance d'un objet
		// Gobelin // Q ? j'ai un Gobelin, enfant de Ennemi, lui-même enfant de Case,
		// dois-je créer un gobelin pour le combat?
		// Ennemi ennemi = new Ennemi();

		// System.out.println(listeCases.get(5).toString()); // test

		// System.out.println("Votre Ennemi dispose de " + getForce() + " de force
		// d'attaque et de " + getNiveau() + " points de vie.");
		System.out.println("");
		System.out.println("Votre Personnage dispose de " + guerrierListe.get(0).getForce()
				+ " de force d'attaque et de " + guerrierListe.get(0).getNiveau() + " points de vie.");
		System.out.println("");

		System.out.println("Voulez-vous continuer ou fuir ? - 8 Rester - 9 Fuir");

		int choix = menu.entreeClavier("");

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

	}

	/*
	 * int vieEnnemi = gobelinTest.getNiveau(); int forcePersonnage =
	 * guerrierListe.get(0).getForce();
	 * 
	 * int forceEnnemi = gobelinTest.getForce(); int viePersonnage =
	 * guerrierListe.get(0).getNiveau();
	 */

	/*
	 * //Joueur attaque toujours en premier int totalAtkJoueur; public void
	 * attaqueJoueur() { System.out.println("Vous attaquez avec votre " +
	 * guerrierListe.get(0).getArme() + " ! A l'assaut !");
	 * if(guerrierListe.get(0).getForce() > gobelinTest.getNiveau()) { //vieEnnemi =
	 * 0; System.out.println("Ennemi est mort - Fin du combat"); }
	 * 
	 * if(guerrierListe.get(0).getForce() < gobelinTest.getNiveau()) {
	 * totalAtkJoueur = gobelinTest.getNiveau() - guerrierListe.get(0).getForce();
	 * System.out.println("Il reste " + totalAtkJoueur + " à l'ennemi"); }
	 * 
	 * if(totalAtkJoueur > 0) { System.out.println("Au tour de l'ennemi !");
	 * attaqueEnnemi(); } }
	 * 
	 * int totalAtkEnnemi; public void attaqueEnnemi() {
	 * 
	 * if(gobelinTest.getForce() > guerrierListe.get(0).getNiveau()) {
	 * //viePersonnage = 0;
	 * System.out.println("Votre personnage est mort - Fin de partie"); }
	 * 
	 * if (guerrierListe.get(0).getNiveau() > gobelinTest.getForce()) {
	 * totalAtkEnnemi = guerrierListe.get(0).getNiveau() - gobelinTest.getForce();
	 * System.out.println("Il vous reste " + totalAtkEnnemi); }
	 * 
	 * }
	 */

}