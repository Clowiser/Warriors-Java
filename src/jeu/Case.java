package jeu;

//h�ritage - classe m�re
interface Case {

	//qu'est-ce qui est commun � toutes les clases enfants Ennemi, Arme, Tr�sor, etc. -> Type de case que ca va �tre ?
	
	//attributs
	
	//constructeurs -> du coup, en interface, pas de constructeur
	
	//m�thodes
	public void interaction(Personnage personnage, Game game);
	//cette m�thode est utilis�e dans tous les classes qui s'impl�mentent de Case
	//c'est une m�thode qui n'a pas de coprs (pas de code)

}