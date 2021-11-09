package jeu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
	// pour cr�er et r�cup�rer les donn�es d'une liste java
		private ArrayList<Guerrier> guerrierListe ;
		private ArrayList<Magicien> magicienListe ;
		
	public Menu() {
	// instance de ces objets
		guerrierListe = new ArrayList<Guerrier>();
		magicienListe = new ArrayList<Magicien>();
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.menuSelect();
		//menu.choice();
}

public void menuSelect(){
	System.out.println("Warriors Game");
	System.out.println("Menu");
	Scanner clavier = new Scanner(System.in);
	System.out.println("1 - S�lection du personnage");
	System.out.println("2 - D�marrer la partie");
	System.out.println("3 - Quitter le jeu");
	int choixMenu = clavier.nextInt();
	
	// faire choix entre 1 ou 2 ou 3
			switch (choixMenu) {
			case 1:
				//Appel de la fonction choice
				choice();
				break;
				
			case 2:
				//Appel de la fonction start
				//magicien();
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

public void choice(){
		int choix;
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("Choisir son personnage - 1 pour Guerrier - 2 pour Magicien - 3 Quitter le jeu : ");
		choix = clavier.nextInt();

		// faire choix entre 1 ou 2 ou 3
		switch (choix) {
		case 1:
			//Appel de la fonction Guerrier
			guerrier();
			break;
			
		case 2:
			//Appel de la fonction Magicien
			magicien();
			break;
			
		case 3:
			System.out.println("Vous avez quitt� le jeu");
			break;
			
		default:
			System.out.println("Erreur choix personnages");
			break;
		}
		clavier.close();
	}


	// METHODES
	//choix Guerrier
	public void guerrier() {
		//d�but d'instance...
		Guerrier joueur1;
		
		//choix nom
		System.out.println("Nommez votre Guerrier : ");
		//java.util.Scanner clavier = new java.util.Scanner(System.in);
		Scanner clavier = new Scanner(System.in);
		String nom = clavier.next();
		System.out.println(nom);
		

		//choix niveau de vie
		boolean isValide = false; // de base, le choix du niveau de vie est = false
		int niveau;
		do {
			System.out.println("Choisissez le niveau de vie de votre Guerrier - entre 5 et 10 :");
			niveau = clavier.nextInt();
				if (niveau >= 5 && niveau <= 10){
					isValide = true; // quand l'utilisateur entre le bon chiffre soit = true soit = affiche niveau
					System.out.println(niveau);
				}else{
					System.out.println("Veuillez entrer un chiffre entre 5 et 10");
				};
		}while (! isValide); // la comparaison !!! == // Tant que le choix de l'utilisateur n'est pas correst soit = false, boucle fait a nouveau le choix 

		
		//choix force d'attaque
		boolean isValide2 = false;
		int force;
		do {
			System.out.println("Choisissez la force d'attaque de votre Guerrier - entre 5 et 10 :");
			force = clavier.nextInt();
			if (force >= 5 && force <= 10) {
				System.out.println(force);
				isValide2 = true;
			}else{
				System.out.println("Veuillez entrer un chiffre entre 5 et 10");
			};
		}while (!isValide2);
			
		joueur1 = new Guerrier(nom, niveau, force); // ... suite d'instance !!!!! c'est ici que je stockes les informations entr�es par l'utilisateur !!!!
	
		//choix armes
		
		//r�sum�
		//mettre donn�es dans liste
		guerrierListe.add(joueur1);	//pour ajouter un objet (joueur1 ici en l'occurrence) dans la liste
		
		System.out.println("R�capitulatif de vos personnages : ");
		  for(int i = 0; i<guerrierListe.size();i++)
		  System.out.println(guerrierListe.get(i).toString());
		  
		System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " �l�ments");  // pour afficher le nombre d'�l�ments dans la liste
		
		//nouveau personnage
		nouveau();
		
		clavier.close();
	}


	//choix Magicien
	public void magicien() {
		//d�but d'instance...
		Magicien joueur2;
	
		//choix nom
		System.out.println("Nommez votre Magicien : ");
		Scanner clavier = new Scanner(System.in);
		String nom = clavier.next();
		System.out.println(nom);
		
		//choix niveau de vie
		boolean isValide = false; // de base, le choix du niveau de vie est = false
		int niveau;
		do {
			System.out.println("Choisissez le niveau de vie de votre Magicien - entre 5 et 10 :");
			niveau = clavier.nextInt();
				if (niveau >= 5 && niveau <= 10){
					isValide = true; // quand l'utilisateur entre le bon chiffre soit = true soit = affiche niveau
					System.out.println(niveau);
				}else{
					System.out.println("Veuillez entrer un chiffre entre 5 et 10");
				};
		}while (isValide == false); // la comparaison !!! == // Tant que le choix de l'utilisateur n'est pas correct soit = false, boucle fait a nouveau le choix 

		
		//choix force d'attaque
		boolean isValide2 = false;
		int force;
		do {
			System.out.println("Choisissez la force d'attaque de votre Magicien - entre 5 et 10 :");
			force = clavier.nextInt();
			if (force >= 5 && force <= 10) {
				System.out.println(force);
				isValide2 = true;
			}else{
				System.out.println("Veuillez entrer un chiffre entre 5 et 10");
			};
		}while (isValide2 == false);
		
		//stock des donn�es
		joueur2 = new Magicien(nom, niveau, force); // ... suite d'instance !!!!! c'est ici que je stockes les informations entr�es par l'utilisateur !!!!
		
		//choix armes
		
		//r�sum�		
		magicienListe.add(joueur2); // ajout � la liste
		
		System.out.println("R�capitulatif de vos personnages : ");
		  for(int i = 0; i<magicienListe.size();i++)
		  System.out.println(magicienListe.get(i).toString());
		  
		System.out.println("La liste de Magicien contient " + magicienListe.size() + " �l�ments");  // pour afficher le nombre d'�l�ments dans la liste
	
		
		//nouveau personnage
		nouveau();
		
		clavier.close();
	}
	
	public void nouveau() {
		int newChoix; 
		System.out.println("Voulez-vous cr�er un nouveau personnage ? 1 Oui - 2 Non - 3 R�capitulatif des personnages - 4 Quitter le jeu ");	
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
			}else if (newChoix == 2) {
				choice();
			}else if (newChoix == 3) {
				totalPersonnages();
			}else{
				System.out.println("Vous avez quitt� le jeu");
				
			}
			clavier.close();
		}
	
	public void totalPersonnages(){
		System.out.println("La liste de Magicien contient " + magicienListe.size() + " �l�ments"); 
			System.out.println("Le r�capitulatif de vos personnages : ");
			  for(int i = 0; i<magicienListe.size();i++)
			  System.out.println(magicienListe.get(i).toString());
		  
		
		System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " �l�ments");
			System.out.println("Le r�capitulatif de vos personnages : ");
			  for(int i = 0; i<guerrierListe.size();i++)
			  System.out.println(guerrierListe.get(i).toString());

		System.out.println("Retour � la cr�ation de personnage");
		choice();
	}
}