package jeu;

public class Dragon extends Ennemi {
	
	public Dragon() {
		super(15, 4);
	}
	
	public String toString() {
		return
			"Dragon";
	}

	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous êtes sur une case Dragon");
		return;
	}

}