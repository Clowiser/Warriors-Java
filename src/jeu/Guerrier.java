package jeu;

public class Guerrier {
	
	
	private String nom; 
	private int niveau;
	private int force;
	//private String arme;
	//private String bouclier;
	
	
	// METHODES
	public Guerrier() {
		this("personnage par default");
	}
	
	public Guerrier(String nom) {
		this(nom, 5, 5);
	}
	
	public Guerrier(String nom, int niveau, int force){
		
		this.nom = nom;
		this.niveau = niveau;
		this.force = force;
	}

	// Getters => prend l'information
	  /* public String getNom() {
	       return nom;
	   }

	   public int getNiveau() {
	       return niveau;
	   }
	   
	   public int getForce() {
	       return force;
	   }*/
	   
	// Setters => renvoie l'information
	   /*public void setNom(String nom) {
	       this.nom = nom;
	   }
	   
	   public void setNiveau(int niveau) {
	       this.niveau = niveau;
	   }
	   
	   public void setForce(int force) {
	       this.force = force;
	   }*/
	  
	   //Je défini ma propre méthode toString()
	   public String toString() {
		   return 
				   "Votre Guerrier s'apelle " + this.nom +
				   ", son niveau de vie est de " + this.niveau +
				   " et il possède une force d'attaque de " + this.force;
		}

	//Instancier un objet => Guerrier Will = new Guerrier();
}
