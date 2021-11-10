package jeu;

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
	 
	 public String toString() {
		   return 
	"Votre Magicien s'apelle " + this.getNom() +
	", son niveau de vie est de " + this.getNiveau() +
	" et il dispose d'une force d'attaque de " + this.getForce() +
	", possède " + philtre + " et " + sort + " pour attaquer !";
	}
	
	//Magicien Marylin = new Magicien();
}