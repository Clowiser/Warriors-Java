package jeu;

//h�ritage - classe fille de Case
//classe d�finit en abstract => elle ne peut pas �tre instanci� car on a pas besoin de l'instancier
//Interface => implements au lieu de extends : une classe impl�mente une interface si elle d�finit les m�thodes de l'interface.
//implements est l'�quivalent de extends pour une interface
public abstract class Ennemi implements Case {

	private String nom;
	private int vie;
	private int force;

	// Constructeurs -> par d�faut il y a toujours un constructeur vide
	// Constructeur commun pour chaque ennemi + sont en protected pour que les
	// classes enfants utilise ce constructeur parent.
	protected Ennemi() {
		this("Nom par d�faut", 5, 5);
	}

	protected Ennemi(String nom, int niveau, int force) {
		this.nom = nom;
		this.vie = niveau;
		this.force = force;
	}

	// Getters => prend l'information
	public int getVie() {
		return vie;
	}

	public int getForce() {
		return force;
	}

	public String getNom() {
		return nom;
	}

	// Setters => renvoie l'information
	public void setVie(int vie) {
		this.vie = vie;
		if (vie <= 0) {
			this.vie = 0;
			System.out.println("Ennemi est mort !");
		}
	}

	public void setForce(int force) {
		this.force = force;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// METHODES
	@Override
	public void interaction(Personnage personnage, Game game) {
		boolean test = game.resterOuFuir(personnage);
		if (!test) {
			game.menu.afficheCombat(personnage, this);
		}
	}

}