package jeu;

public class FireBall extends Sort {
	
	public FireBall() {
		super("Boule de feu", 3);
	}
	
	public String toString() { // ce qui va �tre retourner sur la case Masse
		return "Le sort que vous trouv� est une " + this.getSort() + " et a une force d'attaque de " + this.getAttaque();
	}

}
