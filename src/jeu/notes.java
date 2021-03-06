//import java.util.Collections;

// NOTES :

/*
	//this.plateau.getListeCase().add(4, element);
	//this.plateau.getListeCase().remove();
	//System.out.println("Test" + this.plateau.getListeCase().get(13).toString());
	//Case c = this.plateau.getListeCase().get(5);


 DEROULEMENT :
 1 - Java d?bute par le main qui est le d?but de tout 
 2 - le main apelle le Game, via son instance, avec sa m?thode initGame() qui lance le "jeu" -> son menu principal
 3 - la initGame() contient l'apell de la m?thode afficherMenuPrincipal();
 
 
 CLASSE :
 
 Game :
//game g?re le fait de quitter le jeu
//game g?re le d?marrage de la partie 
//game g?re la cr?ation de personnage
//et il appelle le menu quand il a une demande ? faire ? l'utilisateur
-> doit return un int 

_______________________
 Boucle while :
 
 boolean isRunning = false; // ici je d?clare ma var = false
 
 tant que (!isRunning) { // ici !boolean donc diff?rent de false soit true
  	case 1:
  	ex?cute bloc de code 
  	[...]
  	case 3: 
  	isRunning = true; -> en s?lectionnant 3, isRunning devient true et donc arrête la boucle ? 
 } 
 
 
 RAPPEL :
 -> Un constructeur est une m?thode d'une classe donn?e, servant ? cr?er des objets.

	- il a le même nom que la classe
	- un constructeur n'a pas de type de retour (mais on ne met pas de void!)
	- son r?le principal : l'allocation de la m?moire et l'initialisation des attributs de l'objet cr??
	- un constructeur cr?e (instancie) un objet en appliquant l'op?rateur new
	- les constructeurs acceptent la surcharge
	- si aucun constructeur n'est sp?cifi? dans la d?finition de la classe, un constructeur sans param?tre est fourni par Java
	- si vous d?finissez au moins un constructeur, le constructeur par d?faut n'est plus fourni

Un constructeur est, en programmation orient?e objet, une fonction particuli?re appel?e lors de l'instanciation. Elle permet d'allouer la m?moire n?cessaire ? l'objet et d'initialiser ses attributs.

-> "this" fait r?f?rence ? l'objet

-> Getters - m?thode pour obtenir la valeur d'un champ - les getters ont le modificateur d'acc?s public, ce qui signifie qu'ils sont disponibles depuis n'importe o? dans le programme.

-> Setters - m?thode pour d?finir la valeur d'un champ - Le setter est une m?thode ? part enti?re.

-> Instancier un objet, soit cr?er un objet => Guerrier Will = new Guerrier();

-> retrun :
- le mot cl? return sert ? quitter une m?thode et ? retourner (d'ou le nom) ? la m?thode appelante.
		lorsque la m?thode est du type void, return suffit pour quitter la m?thode.
- si la m?thode ? un type, return permet de retourner un r?sultat, du type de la m?thode


EXPLICATIONS :
-> Exception :
	//throw (sans S) = permet de d?clencher une erreur
	//throws (avec S ) = permet de relayer le traitement de l'exception ? la m?thode appelante

-> clavier.close(); -> !!! Infos : ne pas mettre car provoque une erreur car referme la saisie clavier alors qu'elle doit continuer pour le menuJeu()

// Appel de la m?thode : public Guerrier createGuerrier(ArrayList<Guerrier> guerrierListe) - port?e Classe nom_de_m?thode|createGuerrier|(param?tre)
//Classe nom_de_l'instance = nom_de_l'objet.m?thode|createGuerrier|(arguments)
		// -> je r?cup?re joueurG qui est l'instance de la classe Guerrier est ?gal ? la m?thode createGuerrier au param?tre de la guerrierListe + fait bien appel ? ma m?thode dans le menu
		// je fais appel ? ma m?thode dans le menu qui est ?gal ? l'instance de la classe Guerrier


-> instanceof : 
	est un mot-cl? utilis? pour v?rifier si une variable de r?f?rence contient ou non un type donn? de r?f?rence d'objet
	il est connu comme un op?rateur de comparaison o? l' instance est compar?e au type renvoyant un bool?en vrai ou faux, car en Java, nous n'avons pas de types de retour bool?ens 0 et 1

-> cast : forcer le compilateur ? consid?rer une variable comme ?tant d’un type qui n’est pas le type d?clar? ou le type r?el de la variable.
 Le transtypage (ou cast) est la conversion d'une expression d'un certain type en une expression d'un autre type.
 
 -> Class abstraite : 
 Permet de relier plusieurs points communs entre une super classe
 
 
Interface : 
	 * c'est une collection de m?thodes QUE abstraites qui seront red?finies par une classe // que l'on veut appliquer ? une classe, sans pour autant l'int?grer ? une classe, au mod?le de ces objets
	 * ce n'est PAS une Class => on ne peut pas cr?er d'objet ? partir d'une interface
	 * on ne peut pas cr?er le constructeur (logique)
	 * il n'y a plus de notion d'h?ritage -> on fait de l'impl?mentation via implements (on adapte ce code ? cette class)
	 * 
	 * l'h?ritage multiple n'existe pas -> donc s'il on veut plusieurs fonctions partag?es, il faut des interfaces = un seul h?ritage/pls interface
	 * Par le fait que case soit en abstract, "elle est d?j? une interface"
	 * 
	 * Alors comment choisir entre les m?thodes abstraites et l'interface ?
	 * Choix en faveur de la coh?rence de vos mod?les d'objets = classes abstraites ou interface, globalement, ?a s'utilise de la m?me mani?re mais ce n'est pas la m?me chose.
	 * Dans une classe - utilise pour imposr un comportement global : on va pouvoir d?finir des attributs, constructeurs (instancier des nouveaux objets) et m?thodes (avec corps ou sans corps, soit abstraite)
	 * Dans une interface : elle prend plus le r?le d'un ensemble d'outils
	 * 
	 * En bref, une interface, c'est un ensemble de m?thodes que l'on veut injecter et forcer ? red?finir tr?s sp?cifiquement dans une classe.
 
 A FAIRE :
 
- ajouter "Passer au joueur suivant" ou "case ?v?nement" quand le J1 a fini son tour (1 lancer de d?s)
 
 REGLES :
	// avancer : aller de case en case => r?sultat d?s = avancer de tant de cases
	// faire que le r?sultat du d?s soit = au personnage qui avance sur case ligne 1
	// puis case ligne 2 quand ligne 1 est atteinte
	// le personnage cr?? par l'utilisateur devient le personnage sur le plateau ->
	// G = Guerrier ; M = Magicien (donc si Guerrier = icone G ; si Magicien = icone
	// M)

	// ?venements sur case :
	// objets : un objet divers (arme, bouclier, parchemin de sort, philtre, autres)
	// -> action - prendre objet : quand objet sur une case, prendre objet
	// -> action - laisser objet : quand objet sur une case, laisser objet
	// rencontre : un PNG divers (dialogue)
	// ennemi : un ennemi apparaît => enclenche l'action combat()

	// combats :
	// attaque : attaquer avec arme/sort => infliger nombre de point du r?sultat
	// d'un autre d?s
	// d?gat : si attaque avec perte de PV, d?duire du niveau de vie
	// victoire : si joueur fait perdre le total de PV de l'ennemi = win
	// d?faite : si joueur perd le total de ses PV = lose
	// fin de combat : fin de combat -> poursuivre aventure

	// objectifs :
	// fin du jeu : arriver au bout des 10x10 cases


M?thodes :
	 
	  //M?thode permettant de m?langer le plateau pour en avoir un diff?rent ? chaque partie lanc?e.
   public void swap(){
        for (int i=0;i<100;i++) {
            int firstIndex = (int) ((Math.random() * 20) + 1);
            int secondIndex = (int) ((Math.random() * 20) + 1);
            Collections.swap(jeuPlateau, firstIndex, secondIndex);
        }
    } 
	  
	 */
