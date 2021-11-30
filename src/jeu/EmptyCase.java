package jeu;

//héritage - classe fille de Case
public class EmptyCase implements Case {

	@Override
	public String toString() { //renvoie une chaîne de caractères servant à décrire l'objet concerné.
		return "EmptyCase";
	}
	   //par défaut il y a toujours un constructeur vide

	@Override
	public void interaction(Personnage personnage, Game game) {
		System.out.println("Vous êtes sur une case vide !");
		return;
	}
}