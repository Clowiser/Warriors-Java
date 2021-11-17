package jeu;

import java.util.ArrayList;
import java.util.Scanner;

public class ChoixPerso {
	
	//attributs
	Scanner clavier = new Scanner(System.in);
	//liste personnages pour créer et récupérer les données d'une liste java
	private ArrayList<Guerrier> guerrierListe;
	private ArrayList<Magicien> magicienListe;

	//constructeurs
	
	
	//méthodes
	public void choice() {
		int choix;

		System.out.println("Créer son personnage : 1 pour Guerrier - 2 pour Magicien - 3 Quitter la création de personnage : retour au menu principal ");
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
			System.out.println("Vous avez quitté la création de personnage - retour au menu principal");
			break;

		default:
			System.out.println("Erreur création personnages");
			break;
		}
	}

	
	// METHODES
	public ChoixPerso() {
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

		// choix arme et bouclier - pas de choix
		String arme = "une épée";
		String bouclier = "un écu";
	
		// stock des données
		joueurG = new Guerrier(nom, niveau, force, arme, bouclier); // ... suite d'instance !!!!! c'est ici que je stockes les informations entrées par l'utilisateur !!!!

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

		// choix sort et philtre - pas de choix
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

		// nouveau personnage -> appel de la fonction nouveau()
		nouveau();

		
	}

	// nouveau personnage
	public void nouveau() {
		int newChoix;
		System.out.println(
				"Voulez-vous créer un nouveau personnage ? 1 Oui - 2 Non (retour au menu) - 3 Récapitulatif des personnages - 4 Quitter la création de personnage ");
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
		} else if (newChoix == 3) {
			totalPersonnages();
		} else {
			System.out.println("Vous avez quitté la création de personnage");
		}
		
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

	//sélectionner le personnage qui va jouer : Guerrier = G ou Magicien = M
}