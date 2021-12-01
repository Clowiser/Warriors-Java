package jeu;

//h�ritage - classe m�re
//classe d�finit en abstract => elle ne peut pas �tre instanci�
public abstract class Personnage {

	// Attributs
	//private int id;
	private String nom;
	private int vie;
	private int force;
	private int positionJoueur;

	// constructeurs commun aux personnages + sont en protected pour que les classes enfants utilisent ce constructeur parent.
	protected Personnage(String nom, int vie, int force) {
		//this.id = id;
		this.nom = nom; // this fait r�f�rence � l'objet concern� (Guerrier si Guerrier/Magicien si Magicien)
		this.vie = vie;
		this.force = force;
		this.positionJoueur = 0;
	}

	// Getters => prend/r�cup�re l'information
	//public int getId() {
		//return id;
	//}
	
	public String getNom() {
		return nom;
	}

	public int getVie() {
		return vie;
	}

	public int getForce() {
		return force;
	}
	
	public int getPositionJoueur() {
		return positionJoueur;
	}

	// Setters => renvoie l'information
	//public void setId(int id) {
		//this.id = id;
	//}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int setPositionJoueur(int positionJoueur) {
		return this.positionJoueur = positionJoueur;
	}

}