package jeu;

public class Des {
	
	//Attributs
	private int valeurDes;

	//M�thodes
	public int lancerDe(){
		valeurDes = 0;
		valeurDes = (int)(1 + 6*Math.random());
		return valeurDes;
		}
	
	/*public String toString() {
		return 
			"Le r�sultat de votre lancer de d�s est : " + valeurDes;
	}*/
}