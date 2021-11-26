package jeu;

public class Bouclier {
	private String bouclier;

	// constructeur
	public Bouclier() {
		this("bouclier par défaut");
	}

	public Bouclier(String bouclier) {
		this.bouclier = bouclier;
	}

	public String getBouclier() {
		return bouclier;
	}

	public void setBouclier(String bouclier) {
		this.bouclier = bouclier;
	}
	
	public String toString() {
		return getBouclier();
	}

}