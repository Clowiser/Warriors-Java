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

	// constructeurs -> fonction appel�e lors de l'instanction d'objet
	public Game() {
		this.plateau = new Plateau();
		this.guerrierListe = new ArrayList<>();
		this.magicienListe = new ArrayList<>();
		this.menu = new Menu();
		this.nbDe = new Des();
	}

	// M�thodes
	// MENUS
	// menu principal du jeu (affichage des directives dans le menu)
	public void initGame() {
		boolean isRunning = false;

		while (!isRunning) { // while (isRunning = true) / rappel while (!isRunning) = oppos� de la
								// d�claration (si isRunning = false alors !isRunning = true)

			menu.afficherMenuPrincipal(); // appel de la m�thode afficherMenuPrincipal()

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
				System.out.println("Vous avez quitt� le jeu Warrios Game. A bient�t pour de nouvelles aventures !");
				isRunning = true;
				break;

			default:
				System.out.println("Erreur de selection - initGame()");
				break;
			}
		}

	}

	// Menu du jeu : lancer les d�s - avancer - passer joueur suivant
	public void menuJeu() {

		System.out.println("1 - Lancer le d�s - 2 - Quitter la partie : retour au menu principal - 3 clearPerso");

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
				// essaie lancerDes() + attrape l'erreur cr�� en classe, pour afficher le message not� dans la classe (via getMessage()) soit en exception directement
			}
			break;

		case 2:
			System.out.println("Vous avez quitt� la partie - retour au menu principal");
			System.out.println("");
			initGame();
			break;

		case 3:
			clearPerso();

		default:
			System.out.println("Erreur s�lection - menuJeu()");
			break;

		}
	}

	// Menu cr�ation personnages
	public void createPerso() {
		int choix = 0;

		choix = menu.entreeClavier(
				"Cr�er son personnage : 1 pour Guerrier - 2 pour Magicien - 3 D�marrer la partie - 4 R�capitulatif des personnages - 5 Quitter la cr�ation de personnage : retour au menu principal ");

		switch (choix) {
		case 1:
			Guerrier joueurG = menu.createGuerrier(); // instance de Guerrier qui est r�cup�rer dans le menu via la m�thode createGuerrier()
			// mettre donn�es dans liste
			guerrierListe.add(joueurG); // pour ajouter un objet (joueurG ici en l'occurrence) dans la liste guerrierListe
			createPerso();
			break;

		case 2:
			// Appel de la fonction createMagicien() de l'instance menu de la classe Magicien
			Magicien joueurM = menu.createMagicien();
			magicienListe.add(joueurM); // ajout � la liste magicienListe
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
			System.out.println("Vous avez quitt� la cr�ation de personnage - retour au menu principal");
			menu.afficherMenuPrincipal();
			break;

		default:
			System.out.println("Erreur cr�ation personnages");
			break;
		}

	}

	// afficher la liste des personnages cr��s
	public void afficherListe() {

		// liste des guerriers cr��s
		if (guerrierListe.size() == 0 && magicienListe.size() == 0) {
			System.out.println("Aucun personnage - Veuillez cr�er votre personnage pour commencer l'Aventure !");
			System.out.println("");
			createPerso();
		}

		// PROBLEME : affiche cette partie quand le perso n'est pas clear quand je
		// quitte le jeu
		if (guerrierListe.size() >= 1 || magicienListe.size() >= 1) {
			System.out.println("- R�capitulatif de vos guerriers : ");
			System.out.println("");
			System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " �l�ment(s)"); // pour afficher le nombre d'�l�ments dans la liste
			System.out.println("");
			for (int i = 0; i < guerrierListe.size(); i++) {
				System.out.println(guerrierListe.get(i)); // toString() est pr�sent par d�faut, l� je d�fini moi-m�me ma
															// m�thode toString() dans Personnage pour annuler cet
															// affichage par d�faut (blabla@1d25g5qf2)
			}
			System.out.println("");

			// liste des magiciens cr��s
			System.out.println("- R�capitulatif de vos magiciens : ");
			System.out.println("");
			System.out.println("La liste de Magicien contient " + magicienListe.size() + " �l�ment(s)"); // pour afficher le nombre d'�l�ments dans la liste
																											
			System.out.println("");
			for (int i = 0; i < magicienListe.size(); i++) {
				System.out.println(magicienListe.get(i));
			}
			System.out.println("");

		}

	}

	// DEMARRAGE DE LA PARTIE
	// r�cup�rer le personnage cr��
	public void recupPersoCreer() {

		if (guerrierListe.size() == 1) {
			guerrierListe.get(0); // r�cup�re les informations du premier guerrier - index 0 - (via instance) cr��
									// par l'utilisateur = 1 personne pour le moment
			System.out.println("");
			System.out.println("Vous jouez avec votre Guerrier " + guerrierListe.get(0).getNom()); // affichage le nom
																								// du guerrierListe
			// System.out.println(guerrierListe.get(0)); // affichage
			// guerrierListe.get(0).getNom(); // r�cup�re le nom du guerrierListe avec index
			// 0 -> r�cup�rer la valeur d'un �l�ment dans ArrayList en Java
		}

		if (magicienListe.size() == 1) {
			magicienListe.get(0); // r�cup�re les informations du premier magicien - index 0
			System.out.println("");
			System.out.println("Vous jouez avec votre Magicien " + magicienListe.get(0).getNom()); // affichage le nom
																									// du magicienListe
			// System.out.println(magicienListe.get(0));
		}

	}

	// d�marrer
	public void start() {

		if (guerrierListe.size() == 0 && magicienListe.size() == 0) {
			System.out.println("Veuillez cr�er votre personnage pour commencer l'Aventure !");
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

	// lancer les d�s
	public void lancerDes() throws PersonnageHorsPlateauException {

		// avancer le joueur : r�sultat de l'avanc�e du joueur sur le plateau +
		// placement sur plateau
		if (positionJoueur <= plateau.size()) {
			scoreDes = nbDe.lancerDe();
			positionJoueur += scoreDes; // additionne les deux var et stocke le r�sultat dans var gauche ->
										// positionJoueur + resultatDe = positionJoueur
			System.out.println("Le r�sultat de votre lancer de d�s est : " + scoreDes + ".");
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
		// throws (avec S ) = permet de relayer le traitement de l'exception � la m�thode appelante
		
		int direction;

		direction = menu.entreeClavier("1 - Faites avancer votre personnage de " + scoreDes + " cases."); // direction = menu.nomfonction();

		// faire choix
		switch (direction) {
		case 1:
			// plateau.afficher();
			System.out.println("Votre personnage a avanc� de " + scoreDes + " cases et est maintenant en position : "
					+ positionJoueur);
			System.out.println("");
			
			//parcoursPlateau();

			if (positionJoueur >= plateau.size()) {
				// positionJoueur = plateau.size(); // -> n'est plus utile depuis le throw
				System.out.println("Bravo Aventurier ! Vous avez atteint l'Aventure du Dungeons & Dragons !");
				positionJoueur = 0; // remise � 0 de la position du joueur
				System.out.println("");
				throw new PersonnageHorsPlateauException(); // throw (sans S) = permet de d�clencher une erreur
			}
			plateau.getUneCase(positionJoueur); // par la position Joueur, je "r�cup�re" ce que la case contient
			System.out.println(plateau.getUneCase(positionJoueur));
			
			break;

		default:
			System.out.println("Erreur s�lection");
			break;
		}

	}

	// interaction
	/*public void parcoursPlateau() {

		if (positionJoueur == 0) {
			System.out.println("Vous �tes sur la case D�part");
			System.out.println("");
		} else if (positionJoueur == 3 || positionJoueur == 7 || positionJoueur == 11 || positionJoueur == 14) {
			System.out.println("Vous �tes sur une case Vide");
			System.out.println("");
		} else if (positionJoueur == 1 || positionJoueur == 4) {
			System.out.println("Vous �tes sur une case Tr�sor - 8 Ouvrir - 9 Laisser");
			System.out.println("");
		} else if (positionJoueur == 6 || positionJoueur == 8) {
		System.out.println("Vous trouver un sort ! Magicien, seul vous pouvez le ramasser !");
		System.out.println("");
		} else if (positionJoueur == 12 || positionJoueur == 15) {
		System.out.println("Vous trouver une arme ! Guerrier, seul vous pouvez la ramasser !");
		System.out.println("");
		} else if (positionJoueur == 2 || positionJoueur == 5 || positionJoueur == 9 || positionJoueur == 10
				|| positionJoueur == 13 || positionJoueur == 16 || positionJoueur == 18 || positionJoueur == 19) {
			System.out.println("Vous �tes sur une case Ennemi ! Combat !");
			//interactionCombat();
			System.out.println("");
		}
	}*/

	// garder le m�me personnage ou recr�er un nouveau personnage
	public void clearPerso() {
		System.out.println(
				"Voulez vous recommencer la partie avec votre personnage ? 1 oui - 2 non retour au menu principal ");

		int choix = menu.entreeClavier("");

		switch (choix) {
		case 1:
			start();
			break;

		case 2:
			guerrierListe.remove(0); // suppression guerrier � l'index 0
			// magicienListe.remove(0);
			System.out.println("Votre personnage a �t� supprim� - retour au menu principal");
			initGame();
			break;

		default:
			System.out.println("Erreur s�lection");
			break;

		}

	}
	


	/*
	// COMBATS
	// Tour par tour
	// tour : attaque ou fuir
	// ennemi attaque
	// si fuite -> reculer de 1 � 6

	// test qu'avec le Guerrier
	// Gobelin gobelinTest;
	public void interactionCombat() {
		// prendre niveau de vie + niveau de force du personnage -> Guerrier/magicien
		// prendre niveau de vie + niveau de force de l'ennemi ->
		// Gobelins/sorci�res/dragons

		// joueur
		guerrierListe.get(0);
		guerrierListe.get(0).getNiveau(); // r�cupe vie
		guerrierListe.get(0).getForce(); // r�cupe force

		// ennemi - r�cup�rer niveau/force
		// NON car deux instances : gobelinTest = new Gobelin(); // instance d'un objet
		// Gobelin // Q ? j'ai un Gobelin, enfant de Ennemi, lui-m�me enfant de Case,
		// dois-je cr�er un gobelin pour le combat?
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
			// revenir au jeu + lanc�s de d�s ramdom qui fait RECULER
			break;

		default:
			System.out.println("Erreur s�lection");
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
	 * System.out.println("Il reste " + totalAtkJoueur + " � l'ennemi"); }
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