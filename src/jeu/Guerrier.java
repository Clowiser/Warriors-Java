package jeu;

//h�ritage - classe fille de Personnage
public class Guerrier extends Personnage {

	// Attributs
	private Arme arme;
	private Bouclier bouclier;

	// Constructeurs communs � tous les guerriers
	public Guerrier(String nom, int niveau, int force) {
		super(nom, niveau, force); // appel le constructeur du parent avec les attributs
		this.arme = new Masse(); // r�f�rence � arme de la classe Arme instance Masse
		this.bouclier = new Fer();
	}

	// Constructeurs avec valeur par d�faut
	public Guerrier() {
		super("Pyrobarbare", 5, 5);
	}

	// Getters => prend l'information
	public Arme getArme() {
		return this.arme;
	}

	public Bouclier getBouclier() {
		return this.bouclier;
	}

	// Setters => renvoie et r�utiliser l'information
	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public void setBouclier(Bouclier bouclier) {
		this.bouclier = bouclier;
	}

	// force du guerrier + force de l'arme selon arme de la classe Arme
	public void forceGuerArme(Arme arme) {
		setForce(this.getForce() + arme.getAttaque());
	}

	
	/*public String toString() {
		return "Votre Guerrier s'apelle " + getNom() + ", son niveau de vie est de " + getNiveau()
				+ " et il dispose d'une force d'attaque de " + getForce() + ", poss�de " + bouclier + " et " + arme
				+ " pour attaquer !";
	}*/

}