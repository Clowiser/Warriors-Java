package jeu;

import java.util.*;
//import toute la biblioth�que java.util dont :
	//import java.util.ArrayList;
	//import java.util.Scanner;

public class Menu {
	
	//attributs
	Game game = new Game(); // lance une partie - nouvelle + stock info
	ChoixPerso choix = new ChoixPerso(); // lance le choix du personnage - nouveau + stock info
	Scanner clavier = new Scanner(System.in);
	
	
	//m�thodes
	public void menuPrincipal() {
		
		System.out.println("Warriors Game");
		System.out.println("A vous de jouer !");
		
		boolean isRunning = false; 
		while(!isRunning) {
			System.out.println("1 - Cr�ation du personnage - TEST POUR VOIR SI SA BUG au 16/11/21");
			System.out.println("2 - D�marrer la partie");
			System.out.println("3 - Quitter le jeu");
			int choixMenu = clavier.nextInt();
	
			// faire choix entre 1 ou 2 ou 3
			switch (choixMenu) {
			case 1:
				// Appel de la fonction choice
				choix.choice();
				break;
	
			case 2:
				// Appel de la fonction start de la classe Game via instance qui cr�er l'objet
				game.start();
				break;
	
			case 3:
				System.out.println("Vous avez quitt� le jeu Warrios Game !");
				isRunning = true;
				break;
		
			default:
				System.out.println("Vous n'avez rien s�lectionn�");
				break;
			}
		}
	}
}