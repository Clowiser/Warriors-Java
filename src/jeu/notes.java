// NOTES :

/*
 * RAPPEL :
 * Un constructeur est une méthode d'une classe donnée, servant à créer des objets.

	- il a le même nom que la classe
	- un constructeur n'a pas de type de retour (mais on ne met pas de void!)
	- son rôle principal : l'allocation de la mémoire et l'initialisation des attributs de l'objet créé
	- un constructeur crée (instancie) un objet en appliquant l'opérateur new
	- les constructeurs acceptent la surcharge
	- si aucun constructeur n'est spécifié dans la définition de la classe, un constructeur sans paramètre est fourni par Java
	- si vous définissez au moins un constructeur, le constructeur par défaut n'est plus fourni

 */
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
