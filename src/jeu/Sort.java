package jeu;

public class Sort {
	private String nom;
	private int niveau;
	private int force;
	
	public Sort() {
		this("arme par default");
	}
	
	public Sort(String nom) {
		this(nom, 5, 5);
	}
	
	public Sort(String nom, int niveau, int force){
		this.nom = nom;
		this.niveau = niveau;
		this.force = force;
	}
}
