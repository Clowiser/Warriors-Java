package jeu;

public class Bouclier implements Case {
	private String bouclier;
	private int defense;

	// constructeur
	public Bouclier() {
		this("bouclier par défaut", 5);
	}

	public Bouclier(String bouclier, int defense) {
		this.bouclier = bouclier;
		this.defense = defense;
	}
	
	//getters
	public String getBouclier() {
		return bouclier;
	}
	
	public int getDefense() {
		return defense;
	}
	
	//setters
	public void setBouclier(String bouclier) {
		this.bouclier = bouclier;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public String toString() {
		return bouclier;
	}

	@Override
	public void interaction(Personnage personnage, Game game) {
		System.out.println("Vous trouvez un solide bouclier de " + getBouclier() + " ! ");
		if (personnage instanceof Guerrier) {
			Guerrier joueurGuerrier = (Guerrier) personnage; // cast -> Guerrier appelé joueurGuerrier =
			System.out.println("Vous êtes un Guerrier, prenez " + getBouclier() + " pour récupérer " + this.getDefense()
					+ " de défense ! ");
			// récupérer le nombre de point de défense de l'arme pour ajouter à la défense du Guerrier
			joueurGuerrier.setArmure(joueurGuerrier.getArmure() + this.defense);
			System.out.println("Votre niveau de défense est maintenant de " + joueurGuerrier.getArmure() + " points !");
		} else {
			System.out.println("Vous n'êtes pas Guerrier, passez votre chemin !");
		}
		
	}

}