package jeu;

public class Sort extends Case {
	private String sort;
	private int attaque;

	// constructeur
	public Sort(String sort, int attaque) {
		this.sort = sort;
		this.attaque = attaque;
	}

	public String toString() {
		return sort;
	}
	
	//Setters
	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	
	//Getters
	public String getSort() {
		return sort;
	}

	public int getAttaque() {
		return attaque;
	}
	
	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous trouvez un parchemin de sort : le " + getSort() + " ! ");
		if (personnage instanceof Magicien) {
			Magicien joueurMagicien = (Magicien) personnage; // cast -> Magicien
			System.out.println("Vous �tes un Magicien, prenez " + getSort() + " pour r�cup�rer " + this.getAttaque()
					+ " d'attaque ! ");
			joueurMagicien.setForce(joueurMagicien.getForce() + this.attaque);
		} else {
			System.out.println("Vous n'�tes pas Magicien, passez votre chemin !");
		}
		return;
	}
}
