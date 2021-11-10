package jeu;

public class Magicien {
	
	//Attributs
	private String nom; 
	private int niveau;
	private int force;
	private Philtre philtre;
	private Sort sort;
	
	//METHODES
	//Constructeurs
	public Magicien() {
		this("personnage par default");
	}
	
	public Magicien(String nom) {
		this(nom, 5, 5, "par défaut", "par défaut");
	}
	
	public Magicien(String nom, int niveau, int force, String philtre, String sort){
		this.nom = nom;
		this.niveau = niveau;
		this.force = force;
		this.philtre = new Philtre(philtre);
		this.sort = new Sort(sort);
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
	 
	  public Philtre getPhiltre() {
			return this.philtre;
		}
	  
		public Sort getSort() {
			return sort;
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
	
	 public void setPhiltre(Philtre philtre) {
			this.philtre = philtre;
		}
	 
	 public void setSort(Sort sort) {
			this.sort = sort;
		}
	 
	  //Je défini ma propre méthode toString()
	   public String toString() {
		   return 
			   "Votre Magicien s'apelle " + this.nom +
			   ", son niveau de vie est de " + this.niveau +
			   " et il dispose une force d'attaque de " + this.force + 
			   " et possède " + this.philtre + 
			   " et " + this.sort + ".";
		}
	
	//Magicien Marylin = new Magicien();
}
