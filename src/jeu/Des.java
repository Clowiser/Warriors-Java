package jeu;

public class Des {
	
	//Attributs
	private int valeurDes;

	//Méthodes
	public int lancerDe(){
		valeurDes = 0;
		valeurDes = (int)(1 + 6*Math.random());
		return valeurDes;
		}
}