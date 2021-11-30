package jeu;

public abstract class Arme implements Case {
	private String arme;
	private int attaque;

	// constructeur
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
	//Le mot-clé @override est utilisé pour définir une méthode qui est héritée de la classe parente.
	public void interaction(Personnage personnage) {
		System.out.println("Vous trouvez une arme puissante : la " + getArme() + " ! ");
		if (personnage instanceof Guerrier) {
			Guerrier joueurGuerrier = (Guerrier) personnage; // cast -> Guerrier appelé joueurGuerrier =
			System.out.println("Vous êtes un Guerrier, prenez " + getArme() + " pour récupérer " + this.getAttaque()
					+ " d'attaque ! ");
			// récupérer le nombre de point d'attaque de l'arme pour ajouter à  la force du Guerrier
			// joueurGuerrier.forceGuerArme(this); // fonction de trop dans le code, c'est égal à la méthode d'en dessous.
			joueurGuerrier.setForce(joueurGuerrier.getForce() + this.attaque);
			//je vais modifier la valeur de la force du guerrier donc setForce avec la formule (je prend la force du guerrier + l'attaque de l'arme dans la classe dnas laquelle je suis)
			System.out.println("Votre niveau de force est maintenant de " + joueurGuerrier.getForce() + " points ! ");
		} else {
			System.out.println("Vous n'êtes pas Guerrier, passez votre chemin !");
		}

		
	}
	
	//+ " pour récupérer " + this.getAttaque() + "! ")
	// c'est dans l'interaction du personnage (de la classe Personnage) que si le
	// personnage est un Guerrier, s'il tombe sur la case de l'arme, il peut
	// intérargir avec elle.

}