package jeu;

public class Fer extends Bouclier {
	
	//Constructeurs
	public Fer(){
		super("Fer", 5); // appel le constructeur du parent avec les attributs
	}

	public String toString() { // ce qui va être retourner sur la case Masse
		   return 
			   "Le bouclier que vous trouvez est de type " + this.getBouclier() + " et a une défense de " + this.getDefense();
		}

}
