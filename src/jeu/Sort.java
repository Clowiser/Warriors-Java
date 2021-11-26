package jeu;

public class Sort extends Case{
	private String sort;

	//constructeur
	//public Sort() {
		//this("sort par défaut");
	//}
	
	public Sort() {
		this("une Boule de Feu");
	}
	
	public Sort(String sort){
		this.sort = sort;
	}
	
	public String toString() {
		return sort;
	}

	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous êtes sur une case Sort");
		return;
	}
}
