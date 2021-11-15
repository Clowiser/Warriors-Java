package jeu;

import java.util.*;
//import java.util.ArrayList;
//import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.menuSelect();
	}
	


	public void menuSelect() {
		System.out.println("Warriors Game");
		System.out.println("Menu");
		Scanner clavier = new Scanner(System.in);
		System.out.println("1 - Création du personnage");
		System.out.println("2 - Démarrer la partie");
		System.out.println("3 - Quitter le jeu");
		int choixMenu = clavier.nextInt();

		// faire choix entre 1 ou 2 ou 3
		switch (choixMenu) {
		case 1:
			// Appel de la fonction choice
			choice();
			break;

		case 2:
			// Appel de la fonction start
			start();
			break;

		case 3:
			System.out.println("Vous avez quitté le jeu");
			break;

		default:
			System.out.println("Vous n'avez rien sélectionner");
			break;
		}
		clavier.close();
	}

	public void choice() {
		int choix;

		Scanner clavier = new Scanner(System.in);
		System.out.println("Créer son personnage : 1 pour Guerrier - 2 pour Magicien - 3 Quitter le jeu ");
		choix = clavier.nextInt();

		// faire choix entre 1 ou 2 ou 3
		switch (choix) {
		case 1:
			// Appel de la fonction Guerrier
			guerrier();
			break;

		case 2:
			// Appel de la fonction Magicien
			magicien();
			break;

		case 3:
			System.out.println("Vous avez quitté le jeu");
			break;

		default:
			System.out.println("Erreur création personnages");
			break;
		}
		clavier.close();
	}

	
	
	// METHODES
	//liste personnages pour créer et récupérer les données d'une liste java
		private ArrayList<Guerrier> guerrierListe;
		private ArrayList<Magicien> magicienListe;

		public Menu() {
			// instance de ces objets
			guerrierListe = new ArrayList<Guerrier>();
			magicienListe = new ArrayList<Magicien>();
		}
	
	// choix Guerrier
	public void guerrier() {
		// début d'instance...
		Guerrier joueurG;

		// choix nom
		System.out.println("Nommez votre Guerrier : ");

		Scanner clavier = new Scanner(System.in);
		String nom = clavier.next();
		System.out.println(nom);

		// choix niveau de vie
		boolean isValide = false; // de base, le choix du niveau de vie est = false
		int niveau;
		do {
			System.out.println("Choisissez le niveau de vie de votre Guerrier - entre 5 et 10 :");
			niveau = clavier.nextInt();
			if (niveau >= 5 && niveau <= 10) {
				isValide = true; // quand l'utilisateur entre le bon chiffre soit = true soit = affiche niveau
				System.out.println(niveau);
			} else {
				System.out.println("Veuillez entrer un chiffre entre 5 et 10");
			}
			;
		} while (!isValide); // la comparaison !!! == // Tant que le choix de l'utilisateur n'est pas correct
								// soit = false, boucle fait a nouveau le choix

		// choix force d'attaque
		boolean isValide2 = false;
		int force;
		do {
			System.out.println("Choisissez la force d'attaque de votre Guerrier - entre 5 et 10 :");
			force = clavier.nextInt();
			if (force >= 5 && force <= 10) {
				System.out.println(force);
				isValide2 = true;
			} else {
				System.out.println("Veuillez entrer un chiffre entre 5 et 10");
			}
			;
		} while (!isValide2);

		// choix arme et bouclier
		String arme = "une épée";
		String bouclier = "un écu";
		char g = 'G';
		
		// stock des données
		joueurG = new Guerrier(nom, niveau, force, arme, bouclier, g); // ... suite d'instance !!!!! c'est ici que je stockes les informations entrées par l'utilisateur !!!!

		// résumé
		// mettre données dans liste
		guerrierListe.add(joueurG); // pour ajouter un objet (joueur1 ici en l'occurrence) dans la liste

		System.out.println("Récapitulatif de vos personnages : ");
		for (int i = 0; i < guerrierListe.size(); i++) {
			System.out.println(guerrierListe.get(i)); // toString() est présent par défaut, là je défini moi-même ma méthode toString() dans Personnage pour annuler cet affichage par défaut (blabla@1d25g5qf2)
		}

		System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " élément(s)"); // pour afficher le nombre d'éléments dans la liste

		// nouveau personnage
		nouveau();

		clavier.close();
	}

	// choix Magicien
	public void magicien() {
		// début d'instance...
		Magicien joueurM;

		// choix nom
		System.out.println("Nommez votre Magicien : ");
		Scanner clavier = new Scanner(System.in);
		String nom = clavier.next();
		System.out.println(nom);

		// choix niveau de vie
		boolean isValide = false; // de base, le choix du niveau de vie est = false
		int niveau;
		do {
			System.out.println("Choisissez le niveau de vie de votre Magicien - entre 5 et 10 :");
			niveau = clavier.nextInt();
			if (niveau >= 5 && niveau <= 10) {
				isValide = true; // quand l'utilisateur entre le bon chiffre soit = true soit = affiche niveau
				System.out.println(niveau);
			} else {
				System.out.println("Veuillez entrer un chiffre entre 5 et 10");
			}
			;
		} while (isValide == false); // la comparaison !!! == // Tant que le choix de l'utilisateur n'est pas correct
										// soit = false, boucle fait a nouveau le choix

		// choix force d'attaque
		boolean isValide2 = false;
		int force;
		do {
			System.out.println("Choisissez la force d'attaque de votre Magicien - entre 5 et 10 :");
			force = clavier.nextInt();
			if (force >= 5 && force <= 10) {
				System.out.println(force);
				isValide2 = true;
			} else {
				System.out.println("Veuillez entrer un chiffre entre 5 et 10");
			}
			;
		} while (isValide2 == false);

		// choix sort et philtre
		String philtre = "un philtre de soin";
		String sort = "un sort de boule de feu";

		// stock des données
		joueurM = new Magicien(nom, niveau, force, philtre, sort); // ... suite d'instance !!!!! c'est ici que je stockes les informations entrées par l'utilisateur !!!!

		// résumé
		magicienListe.add(joueurM); // ajout à la liste

		System.out.println("Récapitulatif de vos personnages : ");
		for (int i = 0; i < magicienListe.size(); i++) {
			System.out.println(magicienListe.get(i));
		}

		System.out.println("La liste de Magicien contient " + magicienListe.size() + " élément(s)"); // pour afficher le nombre d'éléments dans la liste

		// nouveau personnage
		nouveau();

		clavier.close();
	}

	// nouveau personnage
	public void nouveau() {
		int newChoix;
		System.out.println(
				"Voulez-vous créer un nouveau personnage ? 1 Oui - 2 Non(retour au menu) - 3 Récapitulatif des personnages - 4 Quitter le jeu ");
		Scanner clavier = new Scanner(System.in);
		newChoix = clavier.nextInt();

		if (newChoix == 1) {
			System.out.println("Quel type de personnage ? 1 pour Guerrier - 2 pour Magicien ");
			int newChoix2 = clavier.nextInt();

			switch (newChoix2) {
			case 1:
				guerrier();
				break;
			case 2:
				magicien();
				break;
			}
		} else if (newChoix == 2) {
			menuSelect();
		} else if (newChoix == 3) {
			totalPersonnages();
		} else {
			System.out.println("Vous avez quitté le jeu");

		}
		clavier.close();
	}

	// total des personnages
	public void totalPersonnages() {
		System.out.println("La liste de Magicien contient " + magicienListe.size() + " élément(s)");
		System.out.println("Le récapitulatif de vos Magiciens : ");
		for (int i = 0; i < magicienListe.size(); i++) {
			System.out.println(magicienListe.get(i));
		}

		System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " élément(s)");
		System.out.println("Le récapitulatif de vos Guerriers : ");
		for (int i = 0; i < guerrierListe.size(); i++) {
			System.out.println(guerrierListe.get(i));
		}

		System.out.println("Retour à la création de personnage");
		choice();
	}

	
	
	
	
	
	
	// ACTIONS
	// démarrer le jeu - afficher le plateau - lancer les dés - avancer - passer joueur 2
	public void menuJeu() {
		// menu en jeu
		int choix;

		Scanner clavier = new Scanner(System.in);
		System.out.println("1 Lancer le dés - 2 Retour au menu - 3 Quitter le jeu - TEST"); // ajouter "Passer au joueur suivant" ou "case événement" quand le J1 a fini son tour (1 lancer de dés)
		choix = clavier.nextInt();

		// faire choix entre 1 ou 2 ou 3
		switch (choix) {
		case 1:
			// Appel de la fonction lancerDes()
			resultatDes();
			break;

		case 2:
			// Appel de la fonction menuSelect()
			menuSelect();
			break;

		case 3:
			System.out.println("Vous avez quitté le jeu");
			break;
			

		default:
			System.out.println("Erreur sélection");
			break;
		}
		clavier.close();
	}
	
	
	
	public void start() {
		// affichage du plateau
		afficherPlateau();

		menuJeu();
	}

	// affichage simple du plateau
	Plateau plateau = new Plateau(32, 32); // paramètres du plateau -> portée globale
	
	public void afficherPlateau() {
		System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les dés pour commencer l'aventure");
		placerElement();
	}

	// résultat de dés pour faire avancer le personnage -> portée globale
	Des nbDe = new Des();
	int scoreDes;
	int position = 0;
	int ligne = 1;
	int diff = 0;
	

	// lancer les dés : de 1 à 6
	public void resultatDes() {

		do {
			scoreDes = nbDe.lancerDe();
			position += scoreDes; // additionne les deux var et stocke le résultat dans var gauche -> position + resultatDe = position
			System.out.println("le résultat de votre lancer de dés est : " + scoreDes + " - la position de votre personnage est : " + position);
			avancer();
		}while(position <= 0); // lance automatiquement 1 fois ce bloc de code
		
		/*
		if(position >= 33) {
					position = ligne++; // ok incrémentation -> passe bien à la ligne suivant MAIS manque le nombre du position + rappel des index d'un tableau
		}
		//si la position (le X) est >= 10 -> passer à la ligne suivante + nouvelle position - 10
		*/
		 
	}

	// résultat de l'avancé du joueur sur le plateau -> placement sur plateau 
	// c'est un cas d'exemple
	public void avancer() {
		
		int direction;
		Scanner clavier = new Scanner(System.in);
		System.out.println("Faites avancer votre personnage de " + scoreDes +  " : 1 bas - 2 droite - 3 haut - 4 gauche");
		direction = clavier.nextInt();

		// faire choix entre 1 ou 2 ou 3 ou 4
		switch (direction) {
		case 1:
			plateau.deplacerB();
			plateau.afficher();
			break;

		case 2:
			plateau.deplacerD();
			plateau.afficher();
			break;

		case 3:
			plateau.deplacerH();
			plateau.afficher();
			break;
			
		case 4:
			plateau.deplacerG();
			plateau.afficher();
			break;
			
		default:
			plateau.deplacerG();
			break;
		}
		clavier.close();
	}
	
	public void placerElement() {
		
		// placer les personnages
		//Plateau plateau = new Plateau(32, 32); // se créer à chaque nouveau appel de la fonction avancer()
		//plateau.placer(ligne, position, 'X'); // rendre résultat lancer de dés = lig/col sachant qu'il avance ligne par ligne, sur la même lig => le déplacement se fait col/col + X est la représentation du personnage
		plateau.placer(5, 5, 'X');

		
		// placer des ennemis
		plateau.placer(8, 6, 'E');
		plateau.placer(1, 3, 'E');
		plateau.placer(10, 8, 'E');
		plateau.placer(4, 4, 'E');
		
		// placer des objets
		plateau.placer(2, 7, 'O');
		plateau.placer(5, 10, 'O');
		plateau.placer(9, 1, 'O');
		plateau.placer(7, 3, 'O');
		
		// placer arrivée = A
		plateau.placer(30, 16, 'A');
		//System.out.print(plateau.getCase(30, 16)); // test pour voir si les paramètres rentrés affiche bien 'A'
		
		plateau.afficher();
		//plateau.deplacerB();
		//plateau.afficher();
		
	}

}