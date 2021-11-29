package jeu;

//héritage - classe fille de Case
//classe définit en abstract => elle ne peut pas être instancié car on a pas besoin de l'instancier
public abstract class Ennemi extends Case {

	private int niveau;
	private int force;

	// Constructeurs -> par défaut il y a toujours un constructeur vide
	// Constructeur commun pour chaque ennemi + sont en protected pour que les classes enfants utilise ce constructeur parent.
	protected Ennemi() {
		this(5, 5);
	}

	protected Ennemi(int niveau, int force) {
		this.niveau = niveau;
		this.force = force;
	}

	// Getters => prend l'information
	public int getNiveau() {
		return niveau;
	}

	public int getForce() {
		return force;
	}

	// Setters => renvoie l'information
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public void setForce(int force) {
		this.force = force;
	}


	// METHODES
	public void interaction(Personnage personnage) {
	
	}

}