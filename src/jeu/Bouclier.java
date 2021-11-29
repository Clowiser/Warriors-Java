package jeu;

public class Bouclier extends Case{
	private String bouclier;
	private int defense;

	// constructeur
	public Bouclier() {
		this("bouclier par d�faut", 5);
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
	public void interaction(Personnage personnage) {
		if (personnage instanceof Guerrier) {
			Guerrier joueurGuerrier = (Guerrier) personnage; // cast -> Guerrier appel� joueurGuerrier =
			System.out.println("Vous �tes un Guerrier, prenez " + getBouclier() + " pour r�cup�rer " + this.getDefense()
					+ " de d�fense ! ");
			// r�cup�rer le nombre de point de d�fense de l'arme pour ajouter � la d�fense du Guerrier
			//joueurGuerrier.setForce(joueurGuerrier.getForce() + this.defense);
		} else {
			System.out.println("Vous n'�tes pas Guerrier, passez votre chemin !");
		}
		
	}

}