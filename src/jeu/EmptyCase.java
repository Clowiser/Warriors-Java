package jeu;

//h�ritage - classe fille de Case
public class EmptyCase extends Case{

	@Override
	public String toString() { //renvoie une cha�ne de caract�res servant � d�crire l'objet concern�.
		return "EmptyCase";
	}
	   //par d�faut il y a toujours un constructeur vide
}