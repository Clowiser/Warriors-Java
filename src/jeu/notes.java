//import java.util.Collections;

// NOTES :

/*

	//this.plateau.getListeCase().add(4, element);
	//this.plateau.getListeCase().remove();
	//System.out.println("Test" + this.plateau.getListeCase().get(13).toString());
	//Case c = this.plateau.getListeCase().get(5);


 DEROULEMENT :
 1 - Java débute par le main qui est le début de tout 
 2 - le main apelle le Game, via son instance, avec sa méthode initGame() qui lance le "jeu" -> son menu principal
 3 - la initGame() contient l'apell de la méthode afficherMenuPrincipal();
 
 
 CLASSE :
 
 Game :
//game gère le fait de quitter le jeu
//game gère le démarrage de la partie 
//game gère la création de personnage
//et il appelle le menu quand il a une demande à faire à l'utilisateur
-> doit return un int 

_______________________
 Boucle while :
 
 boolean isRunning = false; // ici je déclare ma var = false
 
 tant que (!isRunning) { // ici !boolean donc différent de false soit true
  	case 1:
  	exécute bloc de code 
  	[...]
  	case 3: 
  	isRunning = true; -> en sélectionnant 3, isRunning devient true et donc arrête la boucle ? 
 } 
 
 
 RAPPEL :
 -> Un constructeur est une méthode d'une classe donnée, servant à créer des objets.

	- il a le même nom que la classe
	- un constructeur n'a pas de type de retour (mais on ne met pas de void!)
	- son rôle principal : l'allocation de la mémoire et l'initialisation des attributs de l'objet créé
	- un constructeur crée (instancie) un objet en appliquant l'opérateur new
	- les constructeurs acceptent la surcharge
	- si aucun constructeur n'est spécifié dans la définition de la classe, un constructeur sans paramètre est fourni par Java
	- si vous définissez au moins un constructeur, le constructeur par défaut n'est plus fourni

Un constructeur est, en programmation orientée objet, une fonction particulière appelée lors de l'instanciation. Elle permet d'allouer la mémoire nécessaire à l'objet et d'initialiser ses attributs.

-> "this" fait référence à l'objet

-> Getters - méthode pour obtenir la valeur d'un champ - les getters ont le modificateur d'accès public, ce qui signifie qu'ils sont disponibles depuis n'importe où dans le programme.

-> Setters - méthode pour définir la valeur d'un champ - Le setter est une méthode à part entière.

-> Instancier un objet, soit créer un objet => Guerrier Will = new Guerrier();

-> retrun :
- le mot clé return sert à quitter une méthode et à retourner (d'ou le nom) à la méthode appelante.
		lorsque la méthode est du type void, return suffit pour quitter la méthode.
- si la méthode à un type, return permet de retourner un résultat, du type de la méthode


EXPLICATIONS :
-> Exception :
	//throw (sans S) = permet de déclencher une erreur
	//throws (avec S ) = permet de relayer le traitement de l'exception à la méthode appelante

-> clavier.close(); -> !!! Infos : ne pas mettre car provoque une erreur car referme la saisie clavier alors qu'elle doit continuer pour le menuJeu()

// Appel de la méthode : public Guerrier createGuerrier(ArrayList<Guerrier> guerrierListe) - portée Classe nom_de_méthode|createGuerrier|(paramètre)
//Classe nom_de_l'instance = nom_de_l'objet.méthode|createGuerrier|(arguments)
		// -> je récupère joueurG qui est l'instance de la classe Guerrier est égal à la méthode createGuerrier au paramètre de la guerrierListe + fait bien appel à ma méthode dans le menu
		// je fais appel à ma méthode dans le menu qui est égal à l'instance de la classe Guerrier


-> instanceof : 
	est un mot-clé utilisé pour vérifier si une variable de référence contient ou non un type donné de référence d'objet
	il est connu comme un opérateur de comparaison où l' instance est comparée au type renvoyant un booléen vrai ou faux, car en Java, nous n'avons pas de types de retour booléens 0 et 1

-> cast : forcer le compilateur à considérer une variable comme étant d’un type qui n’est pas le type déclaré ou le type réel de la variable.
 Le transtypage (ou cast) est la conversion d'une expression d'un certain type en une expression d'un autre type.
 
 -> Class abstraite : 
 Permet de relier plusieurs points communs entre une super classe
 
 
 A FAIRE :
 
- ajouter "Passer au joueur suivant" ou "case événement" quand le J1 a fini son tour (1 lancer de dés)
 
 REGLES :
	// avancer : aller de case en case => résultat dés = avancer de tant de cases
	// faire que le résultat du dés soit = au personnage qui avance sur case ligne 1
	// puis case ligne 2 quand ligne 1 est atteinte
	// le personnage créé par l'utilisateur devient le personnage sur le plateau ->
	// G = Guerrier ; M = Magicien (donc si Guerrier = icone G ; si Magicien = icone
	// M)

	// évenements sur case :
	// objets : un objet divers (arme, bouclier, parchemin de sort, philtre, autres)
	// -> action - prendre objet : quand objet sur une case, prendre objet
	// -> action - laisser objet : quand objet sur une case, laisser objet
	// rencontre : un PNG divers (dialogue)
	// ennemi : un ennemi apparaît => enclenche l'action combat()

	// combats :
	// attaque : attaquer avec arme/sort => infliger nombre de point du résultat
	// d'un autre dés
	// dégat : si attaque avec perte de PV, déduire du niveau de vie
	// victoire : si joueur fait perdre le total de PV de l'ennemi = win
	// défaite : si joueur perd le total de ses PV = lose
	// fin de combat : fin de combat -> poursuivre aventure

	// objectifs :
	// fin du jeu : arriver au bout des 10x10 cases


M�thodes :
	 
	  //Méthode permettant de mélanger le plateau pour en avoir un différent à chaque partie lancée.
   public void swap(){
        for (int i=0;i<100;i++) {
            int firstIndex = (int) ((Math.random() * 20) + 1);
            int secondIndex = (int) ((Math.random() * 20) + 1);
            Collections.swap(jeuPlateau, firstIndex, secondIndex);
        }
    } 
	  
	 */
