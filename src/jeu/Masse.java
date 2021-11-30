package jeu;

//class fille de Arme -> récup attributs
public class Masse extends Arme {

	// Constructeurs
	public Masse() {
		this("Masse", 5); // appel le constructeur du parent avec les attributs
	}

	public String toString() { // ce qui va être retourner sur la case Masse
		return "L'arme que vous trouvez est une " + this.getArme() + " et a une force d'attaque de " + this.getAttaque();
	}

	public Masse(String arme, int attaque) {
		super(arme, attaque);
	}
	
}