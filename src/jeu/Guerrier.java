package jeu;

public class Guerrier {

	//Attributs
	private String nom; 
	private int niveau;
	private int force;
	private Arme arme;
	private Bouclier bouclier;
	
	//METHODES
	//Constructeurs
	public Guerrier() {
		this("personnage par défaut");
	}
	
	public Guerrier(String nom) {
		this(nom, 5, 5, "par défaut", "par défaut");
	}
	
	public Guerrier(String nom, int niveau, int force, String arme, String bouclier){
		this.nom = nom;
		this.niveau = niveau;
		this.force = force;
		this.arme = new Arme(arme);
		this.bouclier = new Bouclier(bouclier);
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
	   
	   public Bouclier getBouclier() {
			return bouclier;
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
		
		public void setBouclier(Bouclier bouclier) {
			this.bouclier = bouclier;
		}
	   
	   //Je défini ma propre méthode toString()
	   public String toString() {
		   return 
			   "Votre Guerrier s'apelle " + this.nom +
			   ", son niveau de vie est de " + this.niveau +
			   " et il dispose d'une force d'attaque de " + this.force + 
			   " et possède " + this.arme + " et " + this.bouclier + ".";
		}

	//Instancier un objet => Guerrier Will = new Guerrier();
}
