package jeu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
//import jeu.Plateau;
//import jeu.EmptyCase;
//import jeu.CreationPersonnage;
import java.util.Scanner;

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
	public void initGame() throws SQLException {
		boolean isRunning = false;

		while (!isRunning) { // while (isRunning = true) / rappel while (!isRunning) = oppos� de la
								// d�claration (si isRunning = false alors !isRunning = true)

			menu.afficherMenuPrincipal(); // appel de la m�thode afficherMenuPrincipal()

			int choixMenu = menu.entreeClavier(""); // appel de la fonction qui permet le scanner clavier

			switch (choixMenu) {
			case 1:
				test();
				//createPerso();
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
	public void menuJeu() throws SQLException {

		System.out.println("1 Lancer le d�s - 2 Quitter la partie : retour au menu principal - 3 clearPerso - 4 Inventaire");

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

		case 4:
			inventaire(selectPersonnage);
			menuJeu();
			break;
			
		default:
			System.out.println("Erreur s�lection - menuJeu()");
			break;

		}
	}

	//inventaire personnage durant partie - voir sa vie, sa force, s'il y a une arme, sa position
	private void inventaire(Personnage personnage) {
		System.out.println("- Inventaire - ");
		System.out.println("");
		System.out.println(selectPersonnage); // affiche dernier perso cr�� -> boucle
		System.out.println("");
		
	}

	private Connection connect;
	private final Scanner sc = new Scanner(System.in);
	
	// Menu cr�ation personnages
	public void createPerso() throws SQLException {
		
		//public void createPersonnage() throws SQLException {
			String query = "INSERT INTO Hero(Type, nom, niveauVie, niveauForce, ArmeSort, BouclierPhiltre) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement prepare = connect.prepareStatement(query); //PreparedStatement est une sous-interface de Statement. Il est utilis� pour ex�cuter une requ�te param�tr�e.
			System.out.println("Veuillez choisir entre un Guerrier ou un Magicien pour votre personnage :");
			String type = sc.nextLine().toLowerCase(); //toLowerCase() = met en minuscule pour que si l'utilisateur entre le type en majuscule, �a ne provoque pas de probl�me lors du choix ArmeSort et BouclierPhiltre
			System.out.println("Nommez votre personnage :");
			String nom = sc.nextLine();
			System.out.println("Choisissez le niveau de vie de votre personnage - entre 5 et 10 :");
			int vie = sc.nextInt();
			System.out.println("Choisissez la force d'attaque de votre personnage - entre 5 et 10 :");
			int force = sc.nextInt();
			
			if (type.equals("magicien")) { // m�thode equals() disponible dans la classe String utilis�e pour comparer deux cha�nes et d�terminer si elles sont �gales.
				// -> Cette m�thode renvoie une valeur bool�enne � la suite de la comparaison. Si les deux cha�nes contiennent les m�mes caract�res dans le m�me ordre, la m�thode equals () renvoie true. Sinon, il retourne une valeur fausse.
				System.out.println("Choisissez le sort de votre Magicien - entre Boule de Feu et Eclair de Glace:");
			} else {
				System.out.println("Choisissez l'arme de votre Guerrier - entre Masse et Ep�e");
			}
			String armeSort = sc.next();
			
			sc.nextLine();
			if (type.equals("magicien")) { //compare deux chaines et d�termine si elles sont �gales : si type = magicien (ou guerrier) en minuscule, car �crit ici en minuscule alors ce sera la premi�re phrase
				System.out.println("Choisisser le philtre de votre Magicien - entre Philtre de Soin et Philtre de Force");
			} else {
				System.out.println("Choisissez le bouclier de votre Guerrier - entre Bois et Fer");
			}
			String bouclierPhiltre = sc.nextLine();
			//String entree = sc.nextLine(); // derni�re entr�e pour valider la cr�ation de personnage
			
			prepare.setString(1, type);
			prepare.setString(2, nom);
			prepare.setInt(3, vie);
			prepare.setInt(4, force);
			prepare.setString(5, armeSort);
			prepare.setString(6, bouclierPhiltre);
			prepare.executeUpdate(); // Ex�cute l'instruction SQL fournie, qui peut �tre une instruction INSERT, UPDATE ou DELET
		
			
			
		}
			
			public void selectPerso() {
	
		int choix = 0;

		//choix = menu.entreeClavier(
				//"Cr�er son personnage : 1 pour Guerrier - 2 pour Magicien - 3 D�marrer la partie - 4 R�capitulatif des personnages - 5 Quitter la cr�ation de personnage : retour au menu principal ");

		choix = menu.entreeClavier(
				"S�lectionner votre personnage : 1 pour Guerrier - 2 pour Magicien - 3 D�marrer la partie - 4 R�capitulatif des personnages - 5 Quitter la cr�ation de personnage : retour au menu principal ");

		
		switch (choix) {
		case 1:
			// Appel de la fonction createGuerrier() de l'instance menu de la classe Guerrier
			Guerrier joueurG = menu.createGuerrier(); // instance de Guerrier qui est r�cup�rer dans le menu via la
														// m�thode createGuerrier()
			
			guerrierListe.add(joueurG); // pour ajouter un objet (joueurG ici en l'occurrence) dans la liste guerrierListe
			selectPersonnage = joueurG;
			
			 //1 - l'utilisateur ex�cute la cr�ation de persos (Guerrier/magicien) 2 - ce dernier s'ajoute dans la liste 3 - je r�cup�re le personnage cr�� pour jouer
			
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
	public void clearPerso() throws SQLException {
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
	public void afficherListe() throws SQLException {

		// liste des guerriers cr��s
		if (guerrierListe.size() == 0 && magicienListe.size() == 0) {
			System.out.println("Aucun personnage - Veuillez cr�er votre personnage pour commencer l'Aventure !");
			System.out.println("");
			//createPerso();
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
				System.out.println(guerrierListe.get(i)); // toString() est pr�sent par d�faut, l� je d�fini moi-m�me
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
		
		menuJeu();

	}
	// DEMARRAGE DE LA PARTIE
	// d�marrer

	public void start() throws SQLException {
		if (guerrierListe.size() == 0 && magicienListe.size() == 0) {
			System.out.println("Veuillez cr�er votre personnage pour commencer l'Aventure !");
			System.out.println("");
			//createPerso();
		}
		plateau.afficherCases();

		menu.afficherPlateau(plateau);
		System.out.println("");

		menuJeu();
		return;
	}

	int position;

	// lancer les d�s
	public void lancerDes(Personnage personnage) throws PersonnageHorsPlateauException, SQLException {
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
		// throws (avec S ) = permet de relayer le traitement de l'exception � la
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
				position = 0; // remise � 0 de la position du joueur
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
	
	//test pour les m�thodes de la BDD
	public void test() throws SQLException {
		PersonnageDao dao = new PersonnageDao();
		dao.getConnect(); // effectue la connexion pour se connecter � la BDD // obligatoire 
		//dao.getGuerrier(); // dans sa m�thode, a une connexion et affiche la liste des guerriers de la BDD
		//dao.getMagicien();
		createPerso(); // l'utilisateur cr�er son personnage qui est entr� dans la BDD
		dao. supprimerPersonnage(10); //suppression du personnage avec l'id 10 - OK 
		
	}

	

}