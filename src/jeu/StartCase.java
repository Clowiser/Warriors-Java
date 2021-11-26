package jeu;

//héritage - classe fille de Case
public class StartCase extends Case{

	@Override
	public String toString() { //renvoie une chaîne de caractères servant à décrire l'objet concerné.
		return "StartCase";
	}

	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous êtes sur la case Départ");
		return;
	}
	
}