package jeu;

public class Philtre {
	private String nom;
	private int niveau;
	private int force;
	
	public Philtre() {
		this("arme par default");
	}
	
	public Philtre(String nom) {
		this(nom, 5, 5);
	}
	
	public Philtre(String nom, int niveau, int force){
		this.nom = nom;
		this.niveau = niveau;
		this.force = force;
	}
}
