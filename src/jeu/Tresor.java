package jeu;

//h�ritage - classe fille de Case
public class Tresor extends Case {
	
	//attributs
	//private String nom;
	
	/*//constructeurs -> construction d'un tr�sor en lui donnant un nom.
	public Tresor () {
		this.nom = nom;
	}
	
	//get -> retourne le nom du tr�sor
	public String getNom() {
		return nom;
	}*/
	
	@Override
	public String toString() { //renvoie une cha�ne de caract�res servant � d�crire l'objet concern�.
		return "Tresor";
	}

}
