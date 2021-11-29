package jeu;

import java.util.*;
//import toute la biblioth�que java.util dont :
//import java.util.ArrayList;
//import java.util.Scanner;

public class Menu {

	// attributs
	Scanner clavier = new Scanner(System.in); // lance la saisie clavier

	public int entreeClavier(String s) {
		System.out.println(s);
		return clavier.nextInt();
	}

	// m�thodes
	// menu principal
	public void afficherMenuPrincipal() {

		System.out.println("");
		System.out.println("TEST au 29/11/21 - MENU");
		System.out.println("La Compagnie des Bras Cass�s");
		System.out.println("A vous de jouer !");
		System.out.println("");

		System.out.println("1 - Cr�ez votre personnage");
		System.out.println("2 - D�marrer la partie");
		System.out.println("3 - Quitter le jeu");

	}

	// affichage du plateau
	public void afficherPlateau(Plateau plateau) {
		System.out.println("");
		System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les d�s pour commencer l'aventure !");
		System.out.println("");
		System.out.println("Infos : la taille du plateau est de " + plateau.size() + " cases.");
	}

	// guerrier
	public Guerrier createGuerrier() {
		// d�but d'instance...
		Guerrier joueurG;

		// choix nom
		System.out.println("Nommez votre Guerrier : ");

		String nom = clavier.next(); // pour des lettres
		System.out.println(nom);

		// choix niveau de vie
		boolean isValide = false; // de base, le choix du niveau de vie est = false
		int niveau;
		do {
			niveau = entreeClavier("Choisissez le niveau de vie de votre Guerrier - entre 5 et 10 :");
			if (niveau >= 5 && niveau <= 10) {
				isValide = true; // quand l'utilisateur entre le bon chiffre soit = true soit = affiche niveau
				System.out.println(niveau);
			} else {
				System.out.println("Veuillez entrer un chiffre entre 5 et 10");
			}

		} while (!isValide); // la comparaison !!! == // Tant que le choix de l'utilisateur n'est pas correct
								// soit = false, boucle fait a nouveau le choix

		// choix force d'attaque
		boolean isValide2 = false;
		int force;
		do {
			force = entreeClavier("Choisissez la force d'attaque de votre Guerrier - entre 5 et 10 :");
			if (force >= 5 && force <= 10) {
				System.out.println(force);
				isValide2 = true;
			} else {
				System.out.println("Veuillez entrer un chiffre entre 5 et 10");
			}
			;
		} while (!isValide2);

		// instance + stock des donn�es
		joueurG = new Guerrier(nom, niveau, force); // ... suite d'instance !!!!! c'est ici que je stockes les informations entr�es par l'utilisateur !!!!
		return joueurG;

	}

	// choix Magicien
	public Magicien createMagicien() {
		// d�but d'instance...
		Magicien joueurM;

		// choix nom
		System.out.println("Nommez votre Magicien : ");

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
		} while (isValide == false); // la comparaison !!! == // Tant que le choix de l'utilisateur n'est pas
										// correct, soit = false, boucle fait a nouveau le choix

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

		// stock des donn�es
		joueurM = new Magicien(nom, niveau, force); // instance et stockage des valeurs
		return joueurM;
	}

}