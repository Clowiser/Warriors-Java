package jeu;

//h�ritage - classe fille de Personnage
public class Guerrier extends Personnage {

	// Attributs
	private Masse arme;
	private Bouclier bouclier;

	// Constructeurs communs � tous les guerriers
	public Guerrier() {
		super("Pyrobarbare", 5, 5); // appel le constructeur du parent avec les attributs
		this.arme = new Masse(); // r�f�rence � arme de la classe Arme instance Masse
		this.bouclier = new Fer();
	}

	// Getters => prend l'information
	public Masse getArme() {
		return this.arme;
	}

	public Bouclier getBouclier() {
		return this.bouclier;
	}

	// Setters => renvoie et r�utiliser l'information
	public void setArme(Masse arme) {
		this.arme = arme;
	}

	public void setBouclier(Fer bouclier) {
		this.bouclier = bouclier;
	}

	// force du guerrier + force de l'arme selon arme de la classe Arme
	public void forceGuerArme(Arme arme) {
		this.setForce(this.getForce() + arme.getAttaque());
	}

	public String toString() {
		return super.toString()+"Votre arme :" + getArme() + " votre bouclier : " + getBouclier() + ".";
	}

}