package jeu;

public class Bouclier{
	private String bouclier;

	//constructeur
	public Bouclier() {
		this("bouclier par défaut");
	}
	
	public Bouclier(String bouclier){
		this.bouclier = bouclier;
	}
	
	public String toString() {
		return bouclier;
	}
	
	//getters et setters
	/*public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}*/
}