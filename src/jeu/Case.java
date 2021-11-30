package jeu;

//héritage - classe mère
public abstract class Case implements Interact {
	//qu'est-ce qui est commun à toutes les clases enfants Ennemi, Arme, Trésor, etc. -> Type de case que ca va être
	
	//attributs
	
	//constructeurs
	
	//méthodes
	abstract public void interaction(Personnage personnage);

}