package jeu;

//héritage - classe mère
//classe définit en abstract => elle ne peut pas être instancié
public abstract class Personnage {

	// Attributs
	private String nom;
	private int niveau;
	private int force;
	//private boolean fuite;
	//private boolean combat;

	// Constructeurs


	// constructeurs commun aux personnages + sont en protected pour que les classes enfants utilisent ce constructeur parent.
	protected Personnage(String nom, int niveau, int force) {
		this.nom = nom; // this fait référence à l'objet concerné (Guerrier si Guerrier/Magicien si Magicien)
		this.niveau = niveau;
		this.force = force;
	}

	// Getters => prend/récupère l'information
	public String getNom() {
		return nom;
	}

	public int getNiveau() {
		return niveau;
	}

	public int getForce() {
		return force;
	}

	// Setters => renvoie l'information
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public void setForce(int force) {
		this.force = force;
	}

}