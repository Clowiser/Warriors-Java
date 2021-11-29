package jeu;

//héritage - classe fille de Personnage
public class Guerrier extends Personnage {

	// Attributs
	private Masse arme;
	private Bouclier bouclier;

	// Constructeurs communs à tous les guerriers
	public Guerrier(String nom, int niveau, int force) {
		super(nom, niveau, force); // appel le constructeur du parent avec les attributs
		this.arme = new Masse(); // référence à arme de la classe Arme instance Masse
		this.bouclier = new Fer();
	}
	
	public Guerrier() {
		super("Pyrobarbare", 5, 5);
	}

	// Getters => prend l'information
	public Masse getArme() {
		return this.arme;
	}

	public Bouclier getBouclier() {
		return this.bouclier;
	}

	// Setters => renvoie et réutiliser l'information
	public void setArme(Masse arme) {
		this.arme = arme;
	}

	public void setBouclier(Fer bouclier) {
		this.bouclier = bouclier;
	}

	// force du guerrier + force de l'arme selon arme de la classe Arme
	/*
	 * public void forceGuerArme(Arme arme) { setForce(this.getForce() +
	 * arme.getAttaque()); }
	 */

	public String toString() {
		return "Votre Guerrier s'apelle " + getNom() + ", son niveau de vie est de " + getNiveau()
				+ " et il dispose d'une force d'attaque de " + getForce();

	}

}