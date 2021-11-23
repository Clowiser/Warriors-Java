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
	
	//accesseurs
	//getters
	public String getArme() {
		return arme;
	}

	//setters
	public void setArme(String arme) {
		this.arme = arme;
	}
	
}