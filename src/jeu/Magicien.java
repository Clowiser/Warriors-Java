package jeu;

//import Personnage;

//héritage - classe fille
public class Magicien extends Personnage {
	
	//Attributs
	private Philtre philtre;
	private Sort sort;
	
	//Constructeurs
	public Magicien(String nom, int niveau, int force, String philtre, String sort){
		super(nom, niveau, force);
		this.philtre = new Philtre(philtre);
		this.sort = new Sort(sort);
	}
	
	//Getters 
	  public Philtre getPhiltre() {
			return this.philtre;
		}
	  
		public Sort getSort() {
			return sort;
		}
	 
	 //Setters
	 public void setPhiltre(Philtre philtre) {
			this.philtre = philtre;
		}
	 
	 public void setSort(Sort sort) {
			this.sort = sort;
		}
	 
	 //méthodes
	 public String toString() {
		   return 
	"Votre Magicien s'apelle " + getNom() +
	", son niveau de vie est de " + getNiveau() +
	" et il dispose d'une force d'attaque de " + getForce() +
	", possède " + philtre + " et " + sort + " pour attaquer !";
	}
	
}