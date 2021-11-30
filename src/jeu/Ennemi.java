package jeu;

//héritage - classe fille de Case
//classe définit en abstract => elle ne peut pas être instancié car on a pas besoin de l'instancier
//Interface => implements au lieu de extends : une classe implémente une interface si elle définit les méthodes de l'interface.
//implements est l'équivalent de extends pour une interface
public abstract class Ennemi implements Case {

	private String nom;
	private int vie;
	private int force;

	// Constructeurs -> par défaut il y a toujours un constructeur vide
	// Constructeur commun pour chaque ennemi + sont en protected pour que les
	// classes enfants utilise ce constructeur parent.
	protected Ennemi() {
		this("Nom par défaut", 5, 5);
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