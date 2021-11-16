package jeu;

public class Arme{
	private String arme;

	//constructeur
	public Arme() {
		this("arme par défaut");
	}
	
	public Arme(String arme){
		this.arme = arme;
	}

	public String toString() {
		return arme;
	}
	
	
	//getters et setters
	public String getArme() {
		return arme;
	}

	public void setNom(String arme) {
		this.arme = arme;
	}
	
}