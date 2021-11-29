package jeu;

//import Personnage;

//h�ritage - classe fille
public class Magicien extends Personnage {

	// Attributs
	private Philtre philtre;
	private Sort sort;

	// Constructeurs communs � tous les magiciens
	public Magicien(String nom, int niveau, int force) {
		super(nom, niveau, force);
		this.philtre = new SoinPotion();
		this.sort = new FireBall();
	}
	
	// Constructeurs par d�faut
	public Magicien() {
		super("Merlin", 3, 3);
	}


	// Getters - m�thode pour obtenir la valeur d'un champ - les getters ont le modificateur d'acc�s public, ce qui signifie qu'ils sont disponibles depuis n'importe o� dans le programme.
	public Philtre getPhiltre() {
		return this.philtre;
	}

	public Sort getSort() {
		return sort;
	}

	// Setters - m�thode pour d�finir (ou red�finir si une valeur � �t� initialis�) la valeur d'un champ / modifier
	public void setPhiltre(Philtre philtre) {
		this.philtre = philtre;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	// m�thodes
	public String toString() {
		return "Votre Magicien s'apelle " + getNom() + ", son niveau de vie est de " + getNiveau()
				+ " et il dispose d'une force d'attaque de " + getForce();
	}
	
}