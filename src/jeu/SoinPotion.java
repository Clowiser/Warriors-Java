package jeu;

public class SoinPotion extends Philtre {
	
	public SoinPotion() {
		super("Potion de soin", 3);
	}
	
	public String toString() { // ce qui va �tre retourner sur la case Masse
		return "Le philtre que vous trouvez est une " + this.getPhiltre() + " et a une force d'attaque de " + this.getPointVie();
	}

}