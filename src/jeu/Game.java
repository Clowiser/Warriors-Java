package jeu;

import java.util.ArrayList;
//import jeu.Plateau;
//import jeu.EmptyCase;
//import jeu.CreationPersonnage;

/**
 * Description de la classe Game : C'est dans cette classe que se lance
 * l'ensemble du jeu
 */

public class Game {

	// attributs
	int scoreDes;
	Des nbDe;
	Plateau plateau;
	public Menu menu; // ! -> c'est le game qui appelle le menu, pas l'inverse => quand on lance un
				// jeu, c'est le jeu qu'on lance dans lequel il nous affiche un menu qui sert
				// d'interaction
	ArrayList<Guerrier> guerrierListe;
	ArrayList<Magicien> magicienListe;
	Personnage selectPersonnage;

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
				lancerDes(selectPersonnage);
			} catch (PersonnageHorsPlateauException e) {
				System.out.println(e.getMessage());// affiche le message
				System.out.println("");
				menuJeu();
				// e.printStackTrace(); // affiche l'erreur en "rouge" - erreur exception
				// essaie lancerDes() + attrape l'erreur cr�� en classe, pour afficher le
				// message not� dans la classe (via getMessage()) soit en exception directement
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
			// Appel de la fonction createGuerrier() de l'instance menu de la classe
			// Guerrier
			Guerrier joueurG = menu.createGuerrier(); // instance de Guerrier qui est r�cup�rer dans le menu via la
														// m�thode createGuerrier()
			guerrierListe.add(joueurG); // pour ajouter un objet (joueurG ici en l'occurrence) dans la liste
										// guerrierListe
			selectPersonnage = joueurG;
			/*
			 * 1 - l'utilisateur ex�cute la cr�ation de persos (Guerrier/magicien) 2 - ce
			 * dernier s'ajoute dans la liste 3 - je r�cup�re le personnage cr�� pour jouer
			 */
			break;

		case 2:
			Magicien joueurM = menu.createMagicien();
			magicienListe.add(joueurM);
			selectPersonnage = joueurM;
			break;

		case 3:
			start();

		case 4:
			afficherListe();
			System.out.println("");
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

	// garder le m�me personnage ou recr�er un nouveau personnage
	public void clearPerso() {
		System.out.println(
				"Voulez vous recommencer la partie avec votre personnage actuel ? 1 oui - 2 non retour au menu principal ");

		int choix = menu.entreeClavier("");

		switch (choix) {
		case 1:
			start();
			break;

		case 2:
			if (guerrierListe.size() >= 1) {
				guerrierListe.remove(0); // suppression guerrier � l'index 0
			}
			if (magicienListe.size() >= 1) {
				magicienListe.remove(0);
			}
			System.out.println("Votre personnage a �t� supprim� - retour au menu principal");
			initGame();
			break;

		default:
			System.out.println("Erreur s�lection");
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

			// liste des guerriers cr��s
			System.out.println("- R�capitulatif de vos guerriers : ");
			System.out.println("");
			System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " �l�ment(s)");
			System.out.println("");
			for (int i = 0; i < guerrierListe.size(); i++) {
				System.out.println(guerrierListe.get(i)); // toString() est pr�sent par d�faut, là je d�fini moi-m�me
															// ma
															// m�thode toString() dans Personnage pour annuler cet
															// affichage par d�faut (blabla@1d25g5qf2)
			}
			System.out.println("");

			// liste des magiciens cr��s
			System.out.println("- R�capitulatif de vos magiciens : ");
			System.out.println("");
			System.out.println("La liste de Magicien contient " + magicienListe.size() + " �l�ment(s)");
			System.out.println("");
			for (int i = 0; i < magicienListe.size(); i++) {
				System.out.println(magicienListe.get(i));
			}
			System.out.println("");

		}

	}
	// DEMARRAGE DE LA PARTIE
	// d�marrer

	public void start() {
		if (guerrierListe.size() == 0 && magicienListe.size() == 0) {
			System.out.println("Veuillez cr�er votre personnage pour commencer l'Aventure !");
			System.out.println("");
			createPerso();
		}
		plateau.afficherCases();

		menu.afficherPlateau(plateau);
		System.out.println("");

		menuJeu();
		return;
	}

	int position;

	// lancer les d�s
	public void lancerDes(Personnage personnage) throws PersonnageHorsPlateauException {
		position = personnage.setPositionJoueur(position);
		// avancer le joueur : r�sultat de l'avanc�e du joueur sur le plateau +
		// placement sur plateau
		if (personnage.getPositionJoueur() <= plateau.size()) {
			scoreDes = nbDe.lancerDe();
			position += scoreDes; // additionne les deux var et stocke le r�sultat dans var gauche ->
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
		// throws (avec S ) = permet de relayer le traitement de l'exception à la
		// m�thode appelante

		int direction;

		direction = menu.entreeClavier("1 - Faites avancer votre personnage de " + scoreDes + " case(s)."); // direction = menu.nomfonction();
		// faire choix
		switch (direction) {
		case 1:
			System.out.println(
					"Votre personnage a avanc� de " + scoreDes + " case(s) et est maintenant en position : " + position);
			System.out.println("");

			// INTERACTION DU JOUEUR SUR PLATEAU

			if (position >= plateau.size()) {
				// positionJoueur = plateau.size(); // -> n'est plus utile depuis le throw
				System.out.println("Bravo Aventurier ! Vous avez atteint l'Aventure du Dungeons & Dragons !");
				position = 0; // remise à 0 de la position du joueur
				System.out.println("");
				throw new PersonnageHorsPlateauException(); // throw (sans S) = permet de d�clencher une erreur
			}
			plateau.getTypeCase(position); // par la position Joueur, je "r�cup�re" ce que la case contient = le type

		
			//faire la m�thode en fonction que le joueur soit sur une case Ennemi
			
			plateau.interaction(position, selectPersonnage, this); // par la position Joueur et le type de joueur (Guerrier/magicien) je "r�cup�re" le type de case pour int�rargir

		}

	}

	public boolean resterOuFuir(Personnage personnage) {
		System.out.println("Voulez-vous continuer ou fuir ? - 8 Rester - 9 Fuir");

		boolean isFuir = true;
		
		int choix = menu.entreeClavier("");

		switch (choix) {
		case 8:
			System.out.println("Vous avez choisi de rester !");
			System.out.println("");
			isFuir = false;
			break;

		case 9:
			System.out.println("Vous prenez la fuite !");
			fuite(personnage);
			isFuir = true;
			break;

		default:
			System.out.println("Erreur s�lection");
			break;
		}
		return isFuir;
		  }

	public void fuite(Personnage personnage) {
        if (personnage.getPositionJoueur() <= plateau.size()) {
			scoreDes = nbDe.lancerDe();
			position -= scoreDes; // soustraction les deux var et stocke le r�sultat dans var gauche -> positionJoueur - resultatDe = positionJoueur
			System.out.println("Le r�sultat de votre lancer de d�s est : " + scoreDes);
			System.out.println("");
			System.out.println("Votre personnage a recul� de  " + scoreDes + " case(s) et est maintenant en position : " + position);
			System.out.println("");
    }
	}

}