package jeu;

//héritage - classe mère
public abstract class Case {
	//qu'est-ce qui est commun à toutes les clases enfants Ennemi, Arme, Trésor, etc. -> Type de case que ca va être
	
	//attributs
	
	//constructeurs
	
	//méthodes
	//méthode dans Case mais ?
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