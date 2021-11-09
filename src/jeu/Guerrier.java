package jeu;

public class Guerrier {

	//Attributs
	private String nom; 
	private int niveau;
	private int force;
	private Arme arme;
	
	//METHODES
	//Constructeurs
	public Guerrier() {
		this("personnage par default");
	}
	
	public Guerrier(String nom) {
		this(nom, 5, 5, arme);
	}
	
	public Guerrier(String nom, int niveau, int force, Arme arme){
		this.nom = nom;
		this.niveau = niveau;
		this.force = force;
		this.arme = arme;
	}


	//Getters => prend l'information
	   public String getNom() {
	       return nom;
	   }

	   public int getNiveau() {
	       return niveau;
	   }
	   
	   public int getForce() {
	       return force;
	   }
	   
		public Arme getArme() {
			return this.arme;
		}
	   
	//Setters => renvoie l'information
	   public void setNom(String nom) {
	       this.nom = nom;
	   }
	   
	   public void setNiveau(int niveau) {
	       this.niveau = niveau;
	   }
	   
	   public void setForce(int force) {
	       this.force = force;
	   }
	  
		public void setArme(Arme arme) {
			this.arme = arme;
		}
	   
	   //Je défini ma propre méthode toString()
	   public String toString() {
		   return 
			   "Votre Guerrier s'apelle " + this.nom +
			   ", son niveau de vie est de " + this.niveau +
			   " et il possède une force d'attaque de " + this.force + " et possède " + Guerrier.arme + ".";
		}

	//Instancier un objet => Guerrier Will = new Guerrier();
}
