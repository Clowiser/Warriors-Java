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
	
	//Getters - méthode pour obtenir la valeur d'un champ - les getters ont le modificateur d'accès public, ce qui signifie qu'ils sont disponibles depuis n'importe où dans le programme.
	  public Philtre getPhiltre() { 
			return this.philtre;
		}
	  
		public Sort getSort() {
			return sort;
		}
	 
	 //Setters - méthode pour définir (ou redéfinir si une valeur à été initialisé) la valeur d'un champ
	 public void setPhiltre(Philtre philtre) {
			this.philtre = philtre;
		}
	 
	 public void setSort(Sort sort) {
			this.sort = sort;
		}
	 
	 //méthodes
	 /*public String toString() {
		   return 
	"Votre Magicien s'apelle " + getNom() +
	", son niveau de vie est de " + getNiveau() +
	" et il dispose d'une force d'attaque de " + getForce() +
	", possède " + philtre + " et " + sort + " pour attaquer !";
	}*/
	
}