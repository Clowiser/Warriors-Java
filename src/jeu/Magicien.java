package jeu;

//import Personnage;
import jeu.FireBall;

//héritage - classe fille
public class Magicien extends Personnage {

	// Attributs
	private Philtre philtre;
	private Sort sort;


	// Constructeurs communs à tous les magiciens
	public Magicien(String nom, int niveau, int force) {
		super(nom, niveau, force);
		this.philtre = new SoinPotion();
		this.sort = new FireBall();
	}
	
	// Constructeurs par défaut
	public Magicien() {
		super("Merlin", 3, 3);
	}


	// Getters - méthode pour obtenir la valeur d'un champ - les getters ont le modificateur d'accès public, ce qui signifie qu'ils sont disponibles depuis n'importe où dans le programme.
	public Philtre getPhiltre() {
		return this.philtre;
	}

	public Sort getSort() {
		return sort;
	}


	// Setters - méthode pour définir (ou redéfinir si une valeur à été initialisé) la valeur d'un champ / modifier
	public void setPhiltre(Philtre philtre) {
		this.philtre = philtre;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	// méthodes
	public String toString() {

		return "Votre Magicien s'apelle " + getNom() + ", son niveau de vie est de " + getNiveau()
				+ " et il dispose d'une force d'attaque de " + getForce();
	}

}