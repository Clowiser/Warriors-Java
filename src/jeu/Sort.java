package jeu;

public class Sort{
	private String sort;

	//constructeur
	public Sort() {
		this("sort par d�faut");
	}
	
	public Sort(String sort){
		this.sort = sort;
	}
	
	public String toString() {
		return sort;
	}
}
