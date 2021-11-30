package jeu;

//h�ritage - classe fille de Personnage
public class Guerrier extends Personnage {

	// Attributs
	private Masse arme;
	private Bouclier bouclier;
	private int armure;

	// Constructeurs communs � tous les guerriers
	public Guerrier(String nom, int niveau, int force) {
		super(nom, niveau, force); // appel le constructeur du parent avec les attributs
		this.arme = new Masse(); // r�f�rence � arme de la classe Arme instance Masse
		this.bouclier = new Fer();
		this.armure = 5;
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
	
	public int getArmure() {
		return armure;
	}

	// Setters => renvoie et r�utiliser l'information
	public void setArme(Masse arme) {
		this.arme = arme;
	}

	public void setBouclier(Fer bouclier) {
		this.bouclier = bouclier;
	}
	
	public void setArmure(int armure) {
		this.armure = armure;
	}

	// force du guerrier + force de l'arme selon arme de la classe Arme
	/*
	 * public void forceGuerArme(Arme arme) { setForce(this.getForce() +
	 * arme.getAttaque()); }
	 */

	public String toString() {
		return "Votre Guerrier s'apelle " + getNom() + ", son niveau de vie est de " + getVie()
				+ " et il dispose d'une force d'attaque de " + getForce() + " ainsi que d'une d�fense de " + getArmure() + " vous donnant une protection !";

	}

}