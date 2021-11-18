package jeu;

import java.util.*;
//import toute la bibliothèque java.util dont :
	//import java.util.ArrayList;
	//import java.util.Scanner;

public class Menu {
	
	//attributs
	Game game = new Game(); // lance une partie - nouvelle + stock info
	CreationPersonnage choix = new CreationPersonnage(); // lance le choix du personnage - nouveau + stock info
	Scanner clavier = new Scanner(System.in); // lance la saisie clavier
	
	//méthodes
	public void menuPrincipal() {
		
		System.out.println("");
		System.out.println("TEST au 18/11/21 - MENU");
		System.out.println("Warriors Game");
		System.out.println("A vous de jouer !");
		System.out.println("");
		
		boolean isRunning = false; 
		while(!isRunning) { // while (isRunnig = false)
			
			System.out.println("1 - Créez votre personnage pour démarrer une partie");
			System.out.println("2 - Démarrer la partie");
			System.out.println("3 - Quitter le jeu");
			int choixMenu = clavier.nextInt();
	
			// faire choix entre 1 /ou 2/ ou 2
			switch (choixMenu) {
			case 1:
				// Appel de la fonction choice de la classe ChoixPerso via instance de choix
				choix.choicePerso();
				break;
	
			case 2:
				// Appel de la fonction start de la classe Game via instance de game
				game.start();
				break;
	
			case 3:
				System.out.println("Vous avez quitté le jeu Warrios Game. A bientôt pour de nouvelles aventures !");
				isRunning = true;
				break;
		
			default:
				System.out.println("Erreur de selection");
				break;
			}
		}
	}

	
}