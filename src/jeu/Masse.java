package jeu;

//class fille de Arme -> récup attributs
public class Masse extends Arme {

	// Constructeurs
	public Masse() {
		this("Masse", 5); // appel le constructeur du parent avec les attributs
	}

	public Masse(String custom) {
		super(custom, 5);
	}

	public Masse(String arme, int attaque) {
		super(arme, attaque);
	}
	
}