package jeu;

import java.util.*;
//import toute la bibliothèque java.util dont :
//import java.util.ArrayList;
//import java.util.Scanner;

public class Menu {

	// attributs
	Scanner clavier = new Scanner(System.in); // lance la saisie clavier

	public int entreeClavier(String s) {
		System.out.println(s);
		return clavier.nextInt();
	}

	// méthodes
	// menu principal
	public void afficherMenuPrincipal() {

		System.out.println("");
		System.out.println("TEST au 30/11/21 - MENU");
		System.out.println("La Compagnie des Bras Cassés");
		System.out.println("A vous de jouer !");
		System.out.println("");

		System.out.println("1 - Créez votre personnage");
		System.out.println("2 - Démarrer la partie");
		System.out.println("3 - Quitter le jeu");

	}

	// affichage du plateau
	public void afficherPlateau(Plateau plateau) {
		System.out.println("");
		System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les dés pour commencer l'aventure !");
		System.out.println("");
		System.out.println("Infos : la taille du plateau est de " + plateau.size() + " cases.");
	}

	// guerrier
	public Guerrier createGuerrier() {
		// début d'instance...
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

		// instance + stock des données
		joueurG = new Guerrier(nom, niveau, force); // ... suite d'instance !!!!! c'est ici que je stockes les
													// informations entrées par l'utilisateur !!!!
		return joueurG;

	}

	// choix Magicien
	public Magicien createMagicien() {
		// début d'instance...
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

		// stock des données
		joueurM = new Magicien(nom, niveau, force); // instance et stockage des valeurs
		return joueurM;
	}

	public void afficheCombat(Personnage personnage, Ennemi ennemi) {
		System.out.println("Combat ! " + personnage.getNom() + " VS " + ennemi.getNom() + " : ");
		System.out.println("");

		System.out.println(" - " + ennemi.getNom() + " dispose de " + ennemi.getForce() + " de force d'attaque et de "
				+ ennemi.getVie() + " points de vie.");
		// le nom de l'ennemi via le ennemi (car ref à l'objet en cours + le fait que
		// via le code, quand le joueur tomber sur une case dragon, le nom s'affichera
		// Dragon)
		System.out.println("");
		System.out.println(" - " + personnage.getNom() + " dispose de " + personnage.getForce()
				+ " de force d'attaque et de " + personnage.getVie() + " points de vie.");
		System.out.println("");
		System.out.println("Vous attaquez avec une puissance de " + personnage.getForce() + " sur votre ennemi !");
		System.out.println("");
		System.out.println("----------------------------------- ! COMBAT ! -----------------------------------");
		System.out.println("");

		ennemi.setVie(ennemi.getVie() - personnage.getForce());
		// sa nouvelle vie (à l'ennemi) est égale a sa vie actuelle - la force du
		// personnage
		// si vie = 0 -> affiche message ou ennemi est mort

		// si ennemi est toujours vivant après la première attaque du personnage, il contre-attaque et s'enfuit
		if ((ennemi.getVie() > 0)) {
			System.out.println(ennemi.getNom() + " est toujours en vie, il contre-attaque " + personnage.getNom()
					+ " avec " + ennemi.getForce() + " de force d'attaque !");
			System.out.println("");
			personnage.setVie(personnage.getVie() - ennemi.getForce());
			if ((personnage.getVie() > 0)) {
				System.out.println("Il vos reste " + personnage.getVie() + " de points de vie.");
				System.out.println("");
				System.out.println(ennemi.getNom() + " s'enfuit !");
			}
			if ((personnage.getVie() <= 0)) {
				System.out.println("Il vous reste 0 points de vie.");
				System.out.println("");
				System.out.println(personnage.getNom() + " est mort.");
				System.out.println("");
				System.out.println("- Game Over - ");
				System.out.println("");
				
				afficherMenuPrincipal();
			}
		
		}

	}
}