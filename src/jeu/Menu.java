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
		System.out.println("1 - Cr�ation du personnage");
		System.out.println("2 - D�marrer la partie");
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
			System.out.println("Vous avez quitt� le jeu");
			break;

		default:
			System.out.println("Vous n'avez rien s�lectionner");
			break;
		}
		clavier.close();
	}

	public void choice() {
		int choix;

		Scanner clavier = new Scanner(System.in);
		System.out.println("Cr�er son personnage : 1 pour Guerrier - 2 pour Magicien - 3 Quitter le jeu ");
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
			System.out.println("Vous avez quitt� le jeu");
			break;

		default:
			System.out.println("Erreur cr�ation personnages");
			break;
		}
		clavier.close();
	}

	
	
	// METHODES
	//liste personnages pour cr�er et r�cup�rer les donn�es d'une liste java
		private ArrayList<Guerrier> guerrierListe;
		private ArrayList<Magicien> magicienListe;

		public Menu() {
			// instance de ces objets
			guerrierListe = new ArrayList<Guerrier>();
			magicienListe = new ArrayList<Magicien>();
		}
	
	// choix Guerrier
	public void guerrier() {
		// d�but d'instance...
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
		String arme = "une �p�e";
		String bouclier = "un �cu";
		char g = 'G';
		
		// stock des donn�es
		joueurG = new Guerrier(nom, niveau, force, arme, bouclier, g); // ... suite d'instance !!!!! c'est ici que je stockes les informations entr�es par l'utilisateur !!!!

		// r�sum�
		// mettre donn�es dans liste
		guerrierListe.add(joueurG); // pour ajouter un objet (joueur1 ici en l'occurrence) dans la liste

		System.out.println("R�capitulatif de vos personnages : ");
		for (int i = 0; i < guerrierListe.size(); i++) {
			System.out.println(guerrierListe.get(i)); // toString() est pr�sent par d�faut, l� je d�fini moi-m�me ma m�thode toString() dans Personnage pour annuler cet affichage par d�faut (blabla@1d25g5qf2)
		}

		System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " �l�ment(s)"); // pour afficher le nombre d'�l�ments dans la liste

		// nouveau personnage
		nouveau();

		clavier.close();
	}

	// choix Magicien
	public void magicien() {
		// d�but d'instance...
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

		// stock des donn�es
		joueurM = new Magicien(nom, niveau, force, philtre, sort); // ... suite d'instance !!!!! c'est ici que je stockes les informations entr�es par l'utilisateur !!!!

		// r�sum�
		magicienListe.add(joueurM); // ajout � la liste

		System.out.println("R�capitulatif de vos personnages : ");
		for (int i = 0; i < magicienListe.size(); i++) {
			System.out.println(magicienListe.get(i));
		}

		System.out.println("La liste de Magicien contient " + magicienListe.size() + " �l�ment(s)"); // pour afficher le nombre d'�l�ments dans la liste

		// nouveau personnage
		nouveau();

		clavier.close();
	}

	// nouveau personnage
	public void nouveau() {
		int newChoix;
		System.out.println(
				"Voulez-vous cr�er un nouveau personnage ? 1 Oui - 2 Non(retour au menu) - 3 R�capitulatif des personnages - 4 Quitter le jeu ");
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
			System.out.println("Vous avez quitt� le jeu");

		}
		clavier.close();
	}

	// total des personnages
	public void totalPersonnages() {
		System.out.println("La liste de Magicien contient " + magicienListe.size() + " �l�ment(s)");
		System.out.println("Le r�capitulatif de vos Magiciens : ");
		for (int i = 0; i < magicienListe.size(); i++) {
			System.out.println(magicienListe.get(i));
		}

		System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " �l�ment(s)");
		System.out.println("Le r�capitulatif de vos Guerriers : ");
		for (int i = 0; i < guerrierListe.size(); i++) {
			System.out.println(guerrierListe.get(i));
		}

		System.out.println("Retour � la cr�ation de personnage");
		choice();
	}

	
	
	
	
	
	
	// ACTIONS
	// d�marrer le jeu - afficher le plateau - lancer les d�s - avancer - passer joueur 2
	public void menuJeu() {
		// menu en jeu
		int choix;

		Scanner clavier = new Scanner(System.in);
		System.out.println("1 Lancer le d�s - 2 Retour au menu - 3 Quitter le jeu - TEST"); // ajouter "Passer au joueur suivant" ou "case �v�nement" quand le J1 a fini son tour (1 lancer de d�s)
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
			System.out.println("Vous avez quitt� le jeu");
			break;
			

		default:
			System.out.println("Erreur s�lection");
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
	Plateau plateau = new Plateau(32, 32); // param�tres du plateau -> port�e globale
	
	public void afficherPlateau() {
		System.out.println("Affichage du plateau de Dungeons & Dragons - lancer les d�s pour commencer l'aventure");
		placerElement();
	}

	// r�sultat de d�s pour faire avancer le personnage -> port�e globale
	Des nbDe = new Des();
	int scoreDes;
	int position = 0;
	int ligne = 1;
	int diff = 0;
	

	// lancer les d�s : de 1 � 6
	public void resultatDes() {

		do {
			scoreDes = nbDe.lancerDe();
			position += scoreDes; // additionne les deux var et stocke le r�sultat dans var gauche -> position + resultatDe = position
			System.out.println("le r�sultat de votre lancer de d�s est : " + scoreDes + " - la position de votre personnage est : " + position);
			avancer();
		}while(position <= 0); // lance automatiquement 1 fois ce bloc de code
		
		/*
		if(position >= 33) {
					position = ligne++; // ok incr�mentation -> passe bien � la ligne suivant MAIS manque le nombre du position + rappel des index d'un tableau
		}
		//si la position (le X) est >= 10 -> passer � la ligne suivante + nouvelle position - 10
		*/
		 
	}

	// r�sultat de l'avanc� du joueur sur le plateau -> placement sur plateau 
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
		//Plateau plateau = new Plateau(32, 32); // se cr�er � chaque nouveau appel de la fonction avancer()
		//plateau.placer(ligne, position, 'X'); // rendre r�sultat lancer de d�s = lig/col sachant qu'il avance ligne par ligne, sur la m�me lig => le d�placement se fait col/col + X est la repr�sentation du personnage
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
		
		// placer arriv�e = A
		plateau.placer(30, 16, 'A');
		//System.out.print(plateau.getCase(30, 16)); // test pour voir si les param�tres rentr�s affiche bien 'A'
		
		plateau.afficher();
		//plateau.deplacerB();
		//plateau.afficher();
		
	}

}