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
		System.out.println("TEST au 29/11/21 - MENU");
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
				System.out.println("Nommez votre : "+ (isGuerrier ? "guerrier" : "magicien"));

				   String name = scanner.next();
			        if (!name.equals("")) {
			            perso.setNom(name);
			        }
			        
		    
		         do{
		            System.out.println("__"
		                    + "\n" + (isGuerrier ? "Guerrier" : "Magicien") + " nom: " + perso.getNom() +
		                    "\nPoints de vie: " + perso.getNiveau()
		                    + "\nPoints d'attaque: " + perso.getForce()
		                    + (isGuerrier ? "\nArme: " + ((Guerrier)perso).getArme() + "\nBouclier:" + ((Guerrier)perso).getBouclier() : "\nSort: " + ((Magicien)perso).getSort()));


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
		joueurG = new Guerrier(nom, niveau, force); // ... suite d'instance !!!!! c'est ici que je stockes les informations entrées par l'utilisateur !!!!
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

	private static void setNiveau(Personnage perso, boolean isGuerrier) {
		// choix niveau de vie
			int niveau = getIntResult("Choisissez le niveau de vie de votre " + (isGuerrier ? "Guerrier (entre 5 et 10)" : "Magicien (entre 3 et 6"));
			
			if(isGuerrier) {
				while(niveau < 5 || niveau > 10) {
					niveau = getIntResult("Entrez une valeur correcte (entre 5 et 10)");
				}
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

}