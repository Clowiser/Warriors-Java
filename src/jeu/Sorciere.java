package jeu;

public class Sorciere extends Ennemi {
	
	//constructeurs
	public Sorciere() {
		super(9, 2);
	}
	
	public String toString() {
		return
			"Sorcière";
	}

	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous êtes sur une case Sorcière");
		return;
	}
	
}
