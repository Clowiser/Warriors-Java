package jeu;

//héritage - classe mère
interface Case {

	//qu'est-ce qui est commun à toutes les clases enfants Ennemi, Arme, Trésor, etc. -> Type de case que ca va être ?
	
	//attributs
	
	//constructeurs -> du coup, en interface, pas de constructeur
	
	//méthodes
	public void interaction(Personnage personnage, Game game);
	//cette méthode est utilisée dans tous les classes qui s'implémentent de Case
	//c'est une méthode qui n'a pas de coprs (pas de code)

}