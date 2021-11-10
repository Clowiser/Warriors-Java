package jeu;

import java.util.*;
//import java.util.ArrayList;
//import java.util.Scanner;

public class Menu{
	// pour créer et récupérer les données d'une liste java
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
}

public void menuSelect(){
	System.out.println("Warriors Game");
	System.out.println("Menu");
	Scanner clavier = new Scanner(System.in);
	System.out.println("1 - Création du personnage");
	System.out.println("2 - Démarrer la partie");
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
				start();
				break;
				
			case 3:
				System.out.println("Vous avez quitté le jeu");
				break;
				
			default:
				System.out.println("Vous n'avez rien sélectionner");
				break;
			}
			clavier.close();
}

public void choice(){
		int choix;
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("Créer son personnage : 1 pour Guerrier - 2 pour Magicien - 3 Quitter le jeu ");
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
			System.out.println("Vous avez quitté le jeu");
			break;
			
		default:
			System.out.println("Erreur création personnages");
			break;
		}
		clavier.close();
	}


	// METHODES
	//choix Guerrier
	public void guerrier() {
	//début d'instance...
		Guerrier joueurG;
		
	//choix nom
		System.out.println("Nommez votre Guerrier : ");
	
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
		
	//choix arme et bouclier
		String arme = "une épée";
		String bouclier = "un écu";
		
	//stock des données
		joueurG = new Guerrier(nom, niveau, force, arme, bouclier); // ... suite d'instance !!!!! c'est ici que je stockes les informations entrées par l'utilisateur !!!!
		
		
	//résumé
		//mettre données dans liste
		guerrierListe.add(joueurG);	//pour ajouter un objet (joueur1 ici en l'occurrence) dans la liste
		
		System.out.println("Récapitulatif de vos personnages : ");
		for(int i = 0; i<guerrierListe.size();i++) {
		  System.out.println(guerrierListe.get(i)); // toString() est présent par défaut, là je défini moi-même ma méthode toString() dans Personnage pour annuler cet affichage par défaut (blabla@1d25g5qf2)
		  //System.out.println("Votre Guerrier possède " + bouclier + " et " + arme + " pour attaquer !");
		}
		  
		System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " élément(s)");  // pour afficher le nombre d'éléments dans la liste
		
		
	//nouveau personnage
		nouveau();
		
		clavier.close();
	}


	//choix Magicien
	public void magicien() {
	//début d'instance...
		Magicien joueurM;
	
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
		
	//choix sort et philtre
		String philtre = "un philtre de soin";
		String sort = "un sort de boule de feu";
		
	//stock des données
		joueurM = new Magicien(nom, niveau, force, philtre, sort); // ... suite d'instance !!!!! c'est ici que je stockes les informations entrées par l'utilisateur !!!!
		
	//résumé		
		magicienListe.add(joueurM); // ajout à la liste
		
		System.out.println("Récapitulatif de vos personnages : ");
		  for(int i = 0; i<magicienListe.size();i++) {
		  System.out.println(magicienListe.get(i));
		  }
		  
		System.out.println("La liste de Magicien contient " + magicienListe.size() + " élément(s)");  // pour afficher le nombre d'éléments dans la liste
		
	//nouveau personnage
		nouveau();
		
		clavier.close();
	}
	
	
	//nouveau personnage
	public void nouveau() {
		int newChoix; 
		System.out.println("Voulez-vous créer un nouveau personnage ? 1 Oui - 2 Non(retour au menu) - 3 Récapitulatif des personnages - 4 Quitter le jeu ");	
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
				System.out.println("Vous avez quitté le jeu");
				
			}
			clavier.close();
		}
	
	//total des personnages
	public void totalPersonnages(){
		System.out.println("La liste de Magicien contient " + magicienListe.size() + " élément(s)"); 
			System.out.println("Le récapitulatif de vos Magiciens : ");
			  for(int i = 0; i<magicienListe.size();i++) {
			  System.out.println(magicienListe.get(i));
			  }
		  
		System.out.println("La liste de Guerrier contient " + guerrierListe.size() + " élément(s)");
			System.out.println("Le récapitulatif de vos Guerriers : ");
			  for(int i = 0; i<guerrierListe.size();i++) {
			  System.out.println(guerrierListe.get(i));
			  }

		System.out.println("Retour à la création de personnage");
		choice();
	}
	
	
	//ACTIONS
	//démarrer le jeu - Afficher le plateau - lancer les dés - avancer
	public void start(){
		//affichage du plateau
			afficherPlateau();
			
			menuJeu();
			
	}
	
	public void menuJeu() {
		//menu en jeu
		int choix;
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("1 Lancer le dés - 2 Retour au menu - 3 Quitter le jeu");
		choix = clavier.nextInt();

	// faire choix entre 1 ou 2 ou 3
		switch (choix) {
		case 1:
			//Appel de la fonction lancerDes()
			lancerDes();
			break;
			
		case 2:
			//Appel de la fonction menuSelect()
			menuSelect();
			break;
			
		case 3:
			System.out.println("Vous avez quitté le jeu");
			break;
			
		default:
			System.out.println("Erreur sélection");
			break;
		}
		clavier.close();
		
	}
	
	//affichage du plateau
		public void afficherPlateau() {
			System.out.println("Affichage du plateau");
				Plateau plateau = new Plateau(10, 10);
				plateau.afficher(); // appel de la fonction afficher() de la classe Plateau via l'instance
				
		}
		
	//lancer les dés : de 1 à 6
	public void	lancerDes() {
		
		Des nbDe = new Des();
		int resultatDe = nbDe.lancerDe(); 
		System.out.println("le résultat de votre lancer de dés est : " + resultatDe);
		
	//faire avancer le joueur
		int choix;
		
		Scanner clavier = new Scanner(System.in);
		System.out.println("1 avancer le joueur - 2 Quitter le jeu");
		choix = clavier.nextInt();

	// faire choix entre 1 ou 2
		switch (choix) {
		case 1:
			//Appel de la fonction avancer()
			//Plateau.avancer();
			placer();
			break;
			
		case 2:
			System.out.println("Vous avez quitté le jeu");
			break;
			
		default:
			System.out.println("Erreur sélection");
			break;
		}
		clavier.close();
		
	}
	
	// résultat de l'avancé du joueur sur le plateau
		public void placer() {
			Plateau plateau = new Plateau(10, 10);
			plateau.avancer(1, 1, 'X'); // rendre résultat lancer de dés = lig/col sachant qu'il avance ligne par ligne, sur la même lig => le déplacement se fait col/colo
			
			//test : placer des ennemis - attension visible sur le plateau
			plateau.avancer(8, 6, 'E');
			
			plateau.afficher();
			
			menuJeu();
		}
	
	
	
	
	//NOTES :
	//avancer : aller de case en case => résultat dés = avancer de tant de cases
	
	//évenements sur case :
		//objets : un objet divers (arme, bouclier, parchemin de sort, philtre, autres)
			//-> action - prendre objet : quand objet sur une case, prendre objet
			//-> action - laisser objet : quand objet sur une case, laisser objet
		//rencontre : un PNG divers (dialogue)
		//ennemi : un ennemi apparaît => enclenche l'action combat()
	
	//combats : 
		//attaque : attaquer avec arme/sort => infliger nombre de point du résultat d'un autre dés
		//dégat : si attaque avec perte de PV, déduire du niveau de vie
		//victoire : si joueur fait perdre le total de PV de l'ennemi = win
		//défaite : si joueur perd le total de ses PV = lose
		//fin de combat : fin de combat -> poursuivre aventure
		
	//objectifs :
		//fin du jeu : arriver au bout des 10x10 cases

}