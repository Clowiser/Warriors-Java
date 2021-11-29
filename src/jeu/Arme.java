package jeu;

public class Arme extends Case {
	private String arme;
	private int attaque;

	// constructeur
	protected Arme() {
		this("arme par défaut", 5);
	}

	protected Arme(String arme, int attaque) {
		this.arme = arme;
		this.attaque = attaque;
	}

	// accesseurs
	// getters
	public String getArme() {
		return arme;
	}

	public int getAttaque() {
		return attaque;
	}

	// setters
	public void setArme(String arme) {
		this.arme = arme;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public String toString() {
		return arme;
	}

	@Override
	public void interaction(Personnage personnage) {
		if (personnage instanceof Guerrier) {
			Guerrier joueurGuerrier = (Guerrier) personnage; // cast -> Guerrier appelé joueurGuerrier =
			System.out.println("Vous êtes un Guerrier, prenez " + getArme() + " pour récupérer " + this.getAttaque()
					+ " d'attaque ! ");
			// récupérer le nombre de point d'attaque de l'arme pour ajouter à la force du Guerrier
			// joueurGuerrier.forceGuerArme(this); // foncstion de trop dans le code, c'est égal à la méthode d'en dessous.
			joueurGuerrier.setForce(joueurGuerrier.getForce() + this.attaque);
			//je vais modifier la valeur de la force du guerrier donc setForce avec la formule (je prend la force du guerrier + l'attaque de l'arme dans la classe dnas laquelle je suis)
		} else {
			System.out.println("Vous n'êtes pas Guerrier, passez votre chemin !");
		}
	}
	// c'est dans l'interaction du personnage (de la classe Personnage) que si le
	// personnage est un Guerrier, s'il tombe sur la case de l'arme, il peut
	// intérargir avec elle.

}