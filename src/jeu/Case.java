package jeu;

//h�ritage - classe m�re
public abstract class Case implements Interaction {
	//�r le fait que case soit en abstract, elle est d�j� une interface
	//qu'est-ce qui est commun � toutes les clases enfants Ennemi, Arme, Tr�sor, etc. -> Type de case que ca va �tre
	
	//attributs
	
	//constructeurs
	
	//m�thodes
	abstract public void interaction(Personnage personnage);

}