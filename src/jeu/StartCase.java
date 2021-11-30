package jeu;

//h�ritage - classe fille de Case
public class StartCase implements Case {

	@Override
	public String toString() { //renvoie une cha�ne de caract�res servant � d�crire l'objet concern�.
		return "StartCase";
	}

	@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous �tes sur la case D�part");
		return;
	}
	
}