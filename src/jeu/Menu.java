package jeu;

import java.util.*;
//import toute la bibliothèque java.util dont :
	//import java.util.ArrayList;
	//import java.util.Scanner;

public class Menu {
	
	//attributs
	Game game = new Game(); // lance une partie - nouvelle + stock info
	ChoixPerso choix = new ChoixPerso(); // lance le choix du personnage - nouveau + stock info
	Scanner clavier = new Scanner(System.in);
	
	
	//méthodes
	public void menuPrincipal() {
		
		System.out.println("Warriors Game");
		System.out.println("A vous de jouer !");
		
		boolean isRunning = false; 
		while(!isRunning) {
			System.out.println("1 - Création du personnage - TEST POUR VOIR SI SA BUG au 16/11/21");
			System.out.println("2 - Démarrer la partie");
			System.out.println("3 - Quitter le jeu");
			int choixMenu = clavier.nextInt();
	
			// faire choix entre 1 ou 2 ou 3
			switch (choixMenu) {
			case 1:
				// Appel de la fonction choice
				choix.choice();
				break;
	
			case 2:
				// Appel de la fonction start de la classe Game via instance qui créer l'objet
				game.start();
				break;
	
			case 3:
				System.out.println("Vous avez quitté le jeu Warrios Game !");
				isRunning = true;
				break;
		
			default:
				System.out.println("Vous n'avez rien sélectionné");
				break;
			}
		}
	}
}