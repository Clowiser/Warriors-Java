// NOTES :

/*
 * RAPPEL :
 * Un constructeur est une m�thode d'une classe donn�e, servant � cr�er des objets.

	- il a le m�me nom que la classe
	- un constructeur n'a pas de type de retour (mais on ne met pas de void!)
	- son r�le principal : l'allocation de la m�moire et l'initialisation des attributs de l'objet cr��
	- un constructeur cr�e (instancie) un objet en appliquant l'op�rateur new
	- les constructeurs acceptent la surcharge
	- si aucun constructeur n'est sp�cifi� dans la d�finition de la classe, un constructeur sans param�tre est fourni par Java
	- si vous d�finissez au moins un constructeur, le constructeur par d�faut n'est plus fourni

 */
	// avancer : aller de case en case => r�sultat d�s = avancer de tant de cases
	// faire que le r�sultat du d�s soit = au personnage qui avance sur case ligne 1
	// puis case ligne 2 quand ligne 1 est atteinte
	// le personnage cr�� par l'utilisateur devient le personnage sur le plateau ->
	// G = Guerrier ; M = Magicien (donc si Guerrier = icone G ; si Magicien = icone
	// M)

	// �venements sur case :
	// objets : un objet divers (arme, bouclier, parchemin de sort, philtre, autres)
	// -> action - prendre objet : quand objet sur une case, prendre objet
	// -> action - laisser objet : quand objet sur une case, laisser objet
	// rencontre : un PNG divers (dialogue)
	// ennemi : un ennemi appara�t => enclenche l'action combat()

	// combats :
	// attaque : attaquer avec arme/sort => infliger nombre de point du r�sultat
	// d'un autre d�s
	// d�gat : si attaque avec perte de PV, d�duire du niveau de vie
	// victoire : si joueur fait perdre le total de PV de l'ennemi = win
	// d�faite : si joueur perd le total de ses PV = lose
	// fin de combat : fin de combat -> poursuivre aventure

	// objectifs :
	// fin du jeu : arriver au bout des 10x10 cases
