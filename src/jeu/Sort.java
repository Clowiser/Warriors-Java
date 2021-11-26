package jeu;

public class Sort extends Case {
	private String sort;
	private int attaque;

	// constructeur
	public Sort() {
		this("sort par défaut", 5);
	}

	public Sort(String sort, int attaque) {
		this.sort = sort;
		this.attaque = attaque;
	}

	public String toString() {
		return sort;
	}
	
	//Getters
	public String getSort() {
		return sort;
	}

	public int getAttaque() {
		return attaque;
	}
	
	//Setters
	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	
	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous êtes sur une case Sort");
		/*
		 * if { String magicien ="magicien"; System.out.println("Magicien, test !");
		 * return magicien; }
		 */
		return;
	}
}
