package jeu;

//héritage - classe fille
public class Guerrier extends Personnage {

	//Attributs
	private Arme arme;
	private Bouclier bouclier;
	
	//Constructeurs
	public Guerrier(String nom, int niveau, int force, String arme, String bouclier){
		super(nom, niveau, force);
		this.arme = new Arme(arme);
		this.bouclier = new Bouclier(bouclier);
	}

	//Getters => prend l'information
	   public Arme getArme() {
			return arme;
		}
	   
	   public Bouclier getBouclier() {
			return bouclier;
		}
	   
	//Setters => renvoie l'information
		public void setArme(Arme arme) {
			this.arme = arme;
		}
		
		public void setBouclier(Bouclier bouclier) {
			this.bouclier = bouclier;
		}
		
		public String toString() {
			   return 
		"Votre Guerrier s'apelle " + this.getNom() +
		", son niveau de vie est de " + this.getNiveau() +
		" et il dispose d'une force d'attaque de " + this.getForce() +
		", possède " + bouclier + " et " + arme + " pour attaquer !";
		}
	   
	//Instancier un objet => Guerrier Will = new Guerrier();
}