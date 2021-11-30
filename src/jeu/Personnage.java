package jeu;

//h�ritage - classe m�re
//classe d�finit en abstract => elle ne peut pas �tre instanci�
public abstract class Personnage {

	// Attributs
	private String nom;
	private int vie;
	private int force;
	private int positionJoueur;

	// Constructeurs


	// constructeurs commun aux personnages + sont en protected pour que les classes enfants utilisent ce constructeur parent.
	protected Personnage(String nom, int niveau, int force) {
		this.nom = nom; // this fait r�f�rence � l'objet concern� (Guerrier si Guerrier/Magicien si Magicien)
		this.vie = niveau;
		this.force = force;
		this.positionJoueur = 0;
	}

	// Getters => prend/r�cup�re l'information
	public String getNom() {
		return nom;
	}

	public int getVie() {
		return vie;
	}

	public int getForce() {
		return force;
	}

	// Setters => renvoie l'information
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getPositionJoueur() {
		return positionJoueur;
	}

	public int setPositionJoueur(int positionJoueur) {
		return this.positionJoueur = positionJoueur;
	}

	
}