package jeu;

import java.util.*;
//import toute la bibliothèque java.util dont :
	//import java.util.ArrayList;
	//import java.util.Scanner;

public class Menu {
	
	//attributs
	static Scanner clavier = new Scanner(System.in); // lance la saisie clavier
	static Scanner scanner = new Scanner(System.in);
	
	//méthodes
	
	private static String getResult(String question) {
        System.out.println(question);
        return scanner.next();
    }

    public static int getIntResult(String question) {
        try {
            return Integer.parseInt(getResult(question));
        } catch (NumberFormatException e) {
            return getIntResult(question);
        }
    }

    private static String getStringResult(String question){
        String a = getResult(question);
        try{
            Integer.parseInt(a);
        }catch (NumberFormatException e){
            return a;
        }
        return getStringResult(question);
    }
	
	
	//menu principal
	public void afficherMenuPrincipal() {
		
		System.out.println("");
		System.out.println("TEST au 25/11/21 - MENU");
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
	
	public static Guerrier createGuerrier(){
        return new Guerrier();
    }
    public static Magicien createMagicien(){
        return new Magicien();
    }
	
	
	//Création Guerrier
	public static void createPersonnage(ArrayList<Guerrier> guerrierListe, ArrayList<Magicien> magicienListe) {
		int create = getIntResult("Select character : \n1 for Warrior\n2 for Wizard\n3 for left the game"); //// On déclare la variable selector1 de type INT avec comme valeur l'attente d'un entier pour la variable clavier
        switch (create) { // On initialise un nouveau switch
            case 1: //Si la réponse est 1 alors on print une chaîne de caractére
            	selectGuerrier(guerrierListe);
                break;
            case 2: //Si la réponse est 2 alors on print une chaîne de caractére
            	selectMagicien(magicienListe);
                break;
            case 3: //Si la réponse est 3 alors on print une chaîne de caractére et on stop le programme
                System.out.println("Left the game");
                System.exit(0);
                break;
        }
	
	}
	
	public static void menuApresSelection(Personnage perso, boolean isGuerrier) {
		boolean menuAfterSelectionCharacter = true;
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

		            System.out.println("__" + "\n" + "Changer les attributs " + (isGuerrier ? " guerrier" : " magicien") + " ? \n1 pour changer les paramètres \n2 montrer le personnage\n3 retour menu principal" + "\n___\n");

		            int change = clavier.nextInt();
		            clavier.nextLine();
		            switch (change) {
		                case 1:
		                    changeParametres(perso, isGuerrier, clavier);
		                    break;
		                case 2:
		                    montrerPersonnages(perso, isGuerrier);
		                    break;
		                case 3:
		                    System.out.println("Principal menu");
		                    menuAfterSelectionCharacter = false;
		                    break;
		            }
		        }while (menuAfterSelectionCharacter);
	}

	private static void montrerPersonnages(Personnage perso, boolean isGuerrier) {
		System.out.println("Vos modifications :" + " " + perso.getNom() + " " + "avec " + perso.getNiveau() + " " + "points de vie et" + " " + perso.getForce() + " points d'attaque." +
                (isGuerrier ?" Arme :"+ ((Guerrier)perso).getArme() + " avec " + ((Guerrier)perso).getBouclier() + "\n__" : " Sort :"+((Magicien)perso).getSort() +"\n__"));
		
	}

	private static void changeParametres(Personnage perso, boolean isGuerrier, Scanner clavier) {
		setNiveau(perso, isGuerrier);
        setForce(perso, isGuerrier);
        setArme(perso, isGuerrier);
        setArmeSecondaire(perso, isGuerrier, clavier);
		
	}

	private static void setNiveau(Personnage perso, boolean isGuerrier) {
		// choix niveau de vie
			int niveau = getIntResult("Choisissez le niveau de vie de votre " + (isGuerrier ? "Guerrier (entre 5 et 10)" : "Magicien (entre 3 et 6"));
			
			if(isGuerrier) {
				while(niveau < 5 || niveau > 10) {
					niveau = getIntResult("Entrez une valeur correcte (entre 5 et 10)");
				}
			}
			
			if(!isGuerrier) {
				while(niveau < 3 || niveau > 6) {
					niveau = getIntResult("Entrez une valeur correcte (entre 3 et 6)");
				}
			}
			
			perso.setNiveau(niveau);
				
	}
	
	private static void setForce(Personnage perso, boolean isGuerrier) {
		// choix niveau de vie
			int force = getIntResult("Choisissez la force d'attaque de votre " + (isGuerrier ? "Guerrier (entre 5 et 10)" : "Magicien (entre 8 et 15"));
			
			if(isGuerrier) {
				while(force < 5 || force > 10) {
					force = getIntResult("Entrez une valeur correcte (entre 5 et 10)");
				}
			}
			
			if(!isGuerrier) {
				while(force < 8 || force > 15) {
					force = getIntResult("Entrez une valeur correcte (entre 8 et 15)");
				}
			}
			
			perso.setNiveau(force);
				
	}
	
	private static void setArme(Personnage perso, boolean isGuerrier) {
	
		String armePrincipale = getStringResult("Entrez le nom de votre " + (isGuerrier ? "arme" : "sort") + " ou presser entrée pour passer" );
		if(!armePrincipale.equals("")) {
			if(isGuerrier) {
				((Guerrier)perso).setArme(new Masse(armePrincipale));
			}else {
				((Magicien)perso).setSort(new FireBall(armePrincipale));
			}
		}
		
	}
	
	private static void setArmeSecondaire(Personnage perso, boolean isGuerrier, Scanner clavier) {
		
		String armeSecondaire = getStringResult("Entrez le nom de votre " + (isGuerrier ? "bouclier" : "potion") + " ou presser entrée pour passer" );
		if(!armeSecondaire.equals("")) {
			if(isGuerrier) {
				((Guerrier)perso).setBouclier(new Fer(armeSecondaire));
			}else {
				((Magicien)perso).setPhiltre(new SoinPotion(armeSecondaire));
			}
		}
		
	}

	// récupérer le personnage créé - Guerrier
	public static void selectGuerrier(ArrayList<Guerrier> guerrierListe) {
		Guerrier perso = createGuerrier();
		System.out.println("Le Guerrier a été choisi !");
        guerrierListe.add(perso); //ajout dans la liste de guerrier
        selection(perso, true); // rend la sélection vraie ?
	}
	
	// récupérer le personnage créé - Magicien
	public static void selectMagicien(ArrayList<Magicien> magicienListe) {
		Magicien perso = createMagicien();
		System.out.println("Le Magicien a été choisi !");
        magicienListe.add(perso); 
        selection(perso, false); 
	}

	  private static void selection(Personnage perso, boolean isGuerrier) {
	      //nani?
		  menuApresSelection(perso, isGuerrier);
	    }

/*	  public void stock() {
		
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
	  }*/
}