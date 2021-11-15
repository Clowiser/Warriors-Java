package jeu;

//héritage - classe fille
public class Guerrier extends Personnage {

	//Attributs
	private Arme arme;
	private Bouclier bouclier;
	private char g;
	
	//Constructeurs
	public Guerrier(String nom, int niveau, int force, String arme, String bouclier, char g){
		super(nom, niveau, force); // appel le constructeur du parent
		this.arme = new Arme(arme);
		this.bouclier = new Bouclier(bouclier);
		this.g = g;
	}

	//Getters => prend l'information
	   public Arme getArme() {
			return arme;
		}
	   
	   public Bouclier getBouclier() {
			return bouclier;
		}
	   
		public char getG() {
			return g;
		}

	   
	//Setters => renvoie l'information
		public void setArme(Arme arme) {
			this.arme = arme;
		}
		
		public void setBouclier(Bouclier bouclier) {
			this.bouclier = bouclier;
		}
		
		public void setG(char g) {
			this.g = g;
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