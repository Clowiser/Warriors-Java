package jeu;

//h�ritage - classe m�re
public abstract class Case implements Interact {
	//qu'est-ce qui est commun � toutes les clases enfants Ennemi, Arme, Tr�sor, etc. -> Type de case que ca va �tre
	
	//attributs
	
	//constructeurs
	
	//m�thodes
	abstract public void interaction(Personnage personnage);

}