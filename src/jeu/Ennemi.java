package jeu;

//héritage - classe fille de Case
//classe définit en abstract => elle ne peut pas être instancié car on a pas besoin de l'instancier
public abstract class Ennemi extends Case {

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
	public void interaction(Personnage personnage) {
		System.out.println(personnage.getNom() + " VS " + this.getNom() + " : ");
		System.out.println("");
		System.out.println(" - " + this.getNom() + " dispose de " + this.getForce() + " de force d'attaque et de "
				+ this.getVie() + " points de vie.");
		System.out.println("");
		System.out.println(" - " + personnage.getNom() + " dispose de " + personnage.getForce() + " de force d'attaque et de "
				+ personnage.getVie() + " points de vie.");
		System.out.println("");
		System.out.println("Vous attaquez avec une puissance de " + personnage.getForce() + " sur votre ennemi !");
		this.setVie(this.getVie() - personnage.getForce());
		// si vie = 0 -> affiche message ou ennemi est mort
		
		if ((this.getForce() > 0) && (this.getVie() > 0)) {
			System.out.println(this.getNom() + " est toujours en vie, il contre-attaque " + personnage.getNom()
					+ " avec " + this.getForce() + " de force d'attaque !");
			personnage.setVie(personnage.getVie() - this.getForce());
			System.out.println(this.getNom() + " s'enfuit !");

		}

	}

}