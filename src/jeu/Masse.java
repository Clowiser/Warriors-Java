package jeu;

//class fille de Arme -> r�cup attributs
public class Masse extends Arme {

	// Constructeurs
	public Masse() {
		super("Masse", 5); // appel le constructeur du parent avec les attributs
	}

	public String toString() { // ce qui va �tre retourner sur la case Masse
		return "L'arme que vous trouv� est une " + this.getArme() + " et a une force d'attaque de " + this.getAttaque();
	}
}