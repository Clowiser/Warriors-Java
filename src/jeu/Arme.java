package jeu;

public class Arme{
	private String arme;

	//constructeur
	public Arme() {
		this("arme par d�faut");
	}
	
	public Arme(String arme){
		this.arme = arme;
	}
	
	public String toString() {
		return arme;
	}
	
	//getters et setters
	/*public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}*/
}