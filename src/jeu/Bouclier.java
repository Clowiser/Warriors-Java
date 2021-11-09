package jeu;

public class Bouclier extends Guerrier{
	private String type;

	//constructeur
	public Bouclier(String nom, int niveau, int force, String type){
		this.type = type;
	}
	
	//getters et setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}