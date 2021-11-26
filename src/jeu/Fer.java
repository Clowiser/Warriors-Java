package jeu;

public class Fer extends Bouclier {
	
	//Constructeurs
	public Fer(){
		super("Fer"); // appel le constructeur du parent avec les attributs
	}

	public String toString() { // ce qui va être retourner sur la case Masse
		   return 
			   "L'arme que vous trouvé est une " + this.getBouclier();
		}

}
