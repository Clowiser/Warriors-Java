package jeu;

public class Sorciere extends Ennemi {
	
	//constructeurs
	public Sorciere() {
		super(9, 2);
	}
	
	public String toString() {
		return
			"Sorci�re";
	}

	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous �tes sur une case Sorci�re");
		return;
	}
	
}
