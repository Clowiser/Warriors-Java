package jeu;

public class Arme extends Case{
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
	
	//accesseurs
	//getters
	public String getArme() {
		return arme;
	}

	//setters
	public void setArme(String arme) {
		this.arme = arme;
	}

	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous �tes sur une case Arme");
		return;
	}
	
}