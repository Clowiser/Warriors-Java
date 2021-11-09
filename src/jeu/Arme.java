package jeu;

public class Arme{
	private String nom;

	//constructeur
	public Arme() {
		this("une épée");
	}
	
	public Arme(String nom){
		this.nom = nom;
	}
	
	//getters et setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}