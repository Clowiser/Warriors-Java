package jeu;

import java.util.*;
//import toute la bibliothèque java.util dont :
	//import java.util.ArrayList;
	//import java.util.Scanner;

public class Menu {
	
	//attributs
	Scanner clavier = new Scanner(System.in); // lance la saisie clavier
	
	public int entreeClavier(String s) {
		System.out.println(s);
		return clavier.nextInt();
	}
	
	
	//menu principal
	public void afficherMenuPrincipal() { //construction de la méthode avec paramètre
		
		System.out.println("");
		System.out.println("TEST au 19/11/21 - MENU");
		System.out.println("Warriors Game");
		System.out.println("A vous de jouer !");
		System.out.println("");
		
		System.out.println("1 - Créez votre personnage");
		System.out.println("2 - Démarrer la partie"); 
		System.out.println("3 - Quitter le jeu");
		
	}
	
	
	// affichage du plateau
	public void afficherPlateau(Plateau plateau) {
		System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les dés pour commencer l'aventure !");
		
		//testAffichage.afficherPlat(); // test
		
		System.out.println("Infos : la taille du plateau est de " + plateau.size() + " cases.");
		System.out.println("");
		System.out.println("- Appuyez sur 1 pour faire le premier jet de dés -");
	}
	
	
	//guerrier
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
			;
		} while (!isValide); // la comparaison !!! == // Tant que le choix de l'utilisateur n'est pas correct soit = false, boucle fait a nouveau le choix

		// choix force d'attaque
		boolean isValide2 = false;
		int force;
		do {
			force =  entreeClavier("Choisissez la force d'attaque de votre Guerrier - entre 5 et 10 :");
			if (force >= 5 && force <= 10) {
				System.out.println(force);
				isValide2 = true;
			} else {
				System.out.println("Veuillez entrer un chiffre entre 5 et 10");
			}
			;
		} while (!isValide2);

		// choix arme et bouclier - pas de choix
		String arme = "une épée";
		String bouclier = "un écu";
	
		// instance + stock des données
		joueurG = new Guerrier(nom, niveau, force, arme, bouclier); // ... suite d'instance !!!!! c'est ici que je stockes les informations entrées par l'utilisateur !!!!
		
		System.out.println("Votre Guerrier s'apelle " + nom + ", son niveau de vie est de " + niveau + " et il dispose d'une force d'attaque de " + force + " possède " + bouclier + " et " + arme + " pour attaquer !");	
	
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

		// choix sort et philtre - pas de choix
		String philtre = "un philtre de soin";
		String sort = "un sort de boule de feu";

		// stock des données
		joueurM = new Magicien(nom, niveau, force, philtre, sort); // ... suite d'instance !!!!! c'est ici que je stockes les informations entrées par l'utilisateur !!!!

		return joueurM;
	}
					
}