package jeu;

//héritage - classe mère
public abstract class Case implements Interaction {
	//âr le fait que case soit en abstract, elle est déjà une interface
	//qu'est-ce qui est commun à toutes les clases enfants Ennemi, Arme, Trésor, etc. -> Type de case que ca va être
	
	//attributs
	
	//constructeurs
	
	//méthodes
	abstract public void interaction(Personnage personnage);

}