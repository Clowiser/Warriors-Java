package jeu;

public class Magicien {
	
	//Attributs
	private String nom; 
	private int niveau;
	private int force;
	
	//METHODES
	//Constructeurs
	public Magicien() {
		this("personnage par default");
	}
	
	public Magicien(String nom) {
		this(nom, 5, 5);
	}
	
	public Magicien(String nom, int niveau, int force){
		this.nom = nom;
		this.niveau = niveau;
		this.force = force;
	}
	
	//Getters 
	 public String getNom() {
	       return nom;
	   }

	 public int getNiveau() {
	       return niveau;
	   }
	   
	 public int getForce() {
	       return force;
	   }
	 
	 //Setters
	 public void setNom(String nom) {
	       this.nom = nom;
	   }
	   
	 public void setNiveau(int niveau) {
	       this.niveau = niveau;
	   }
	   
	 public void setForce(int force) {
	       this.force = force;
	   }
	
	  //Je défini ma propre méthode toString()
	   public String toString() {
		   return 
			   "Votre Magicien s'apelle " + this.nom +
			   ", son niveau de vie est de " + this.niveau +
			   " et il possède une force de : " + this.force;
		}

	
	//Magicien Marylin = new Magicien();
}
