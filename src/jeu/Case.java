package jeu;

//h�ritage - classe m�re
public abstract class Case {
	//qu'est-ce qui est commun � toutes les clases enfants Ennemi, Arme, Tr�sor, etc. -> Type de case que ca va �tre
	
	//attributs
	
	//constructeurs
	
	//m�thodes
	//m�thode dans Case mais ?
	//Personnage personnage;
	abstract public void interaction(Personnage personnage);
	
	
	
	/*{
		
		if(personnage instanceof Guerrier) {
			String guerrier = "guerrier";
			System.out.println("Guerrier, test !");
			return guerrier;
		}else {
			String magicien ="magicien";
			System.out.println("Magicien, test !");
			return magicien;
		}
	
	}*/

	
	 /*public int getForce() {
	       return 0;
	   }
	*/
}