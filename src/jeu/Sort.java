package jeu;

public class Sort extends Case{
	private String sort;

	//constructeur
	//public Sort() {
		//this("sort par d�faut");
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
		System.out.println("Vous �tes sur une case Sort");
		return;
	}
}
