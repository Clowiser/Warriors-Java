package jeu;

//héritage - classe fille de Case
public class EmptyCase extends Case{

	@Override
	public String toString() { //renvoie une chaîne de caractères servant à décrire l'objet concerné.
		return "EmptyCase";
	}
	   //par défaut il y a toujours un constructeur vide
}