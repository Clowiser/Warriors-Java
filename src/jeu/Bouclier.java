package jeu;

public class Bouclier{
	private String bouclier;

	//constructeur
	public Bouclier() {
		this("bouclier par d�faut");
	}
	
	public Bouclier(String bouclier){
		this.bouclier = bouclier;
	}
	
	public String toString() {
		return bouclier;
	}

}