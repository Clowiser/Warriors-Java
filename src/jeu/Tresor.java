package jeu;

//h�ritage - classe fille de Case
public class Tresor implements Case {
	
	/*//attributs
	private char nom;
	
	//constructeurs -> construction d'un tr�sor en lui donnant un nom.
	public Tresor (char nom) {
		this.nom = nom;
	}
	
	//get -> retourne le nom du tr�sor
	public char getNom() {
		return nom;
	}*/
	
	@Override
	public String toString() { //renvoie une cha�ne de caract�res servant � d�crire l'objet concern�.
		return "Tresor";
	}

	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous �tes sur une case Tr�sor");
		return;
	}

}
