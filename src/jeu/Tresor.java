package jeu;

//héritage - classe fille de Case
public class Tresor implements Case {
	
	/*//attributs
	private char nom;
	
	//constructeurs -> construction d'un trésor en lui donnant un nom.
	public Tresor (char nom) {
		this.nom = nom;
	}
	
	//get -> retourne le nom du trésor
	public char getNom() {
		return nom;
	}*/
	
	@Override
	public String toString() { //renvoie une chaîne de caractères servant à décrire l'objet concerné.
		return "Tresor";
	}

	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous êtes sur une case Trésor");
		return;
	}

}
