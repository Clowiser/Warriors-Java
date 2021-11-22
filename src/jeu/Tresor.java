package jeu;

//héritage - classe fille de Case
public class Tresor extends Case {
	
	//attributs
	//private String nom;
	
	/*//constructeurs -> construction d'un trésor en lui donnant un nom.
	public Tresor () {
		this.nom = nom;
	}
	
	//get -> retourne le nom du trésor
	public String getNom() {
		return nom;
	}*/
	
	@Override
	public String toString() { //renvoie une chaîne de caractères servant à décrire l'objet concerné.
		return "Tresor";
	}

}
