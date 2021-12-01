package jeu;

//héritage - classe fille de Ennemi
public class Gobelin extends Ennemi {
//création instance de combat ici
	
	// constructeurs
	public Gobelin(String nom, int niveau, int force) {
		super(nom, niveau, force); // appel le constructeur du parent avec les attributs du parent
	} // méthode qui ne définit pas les infos par défaut - Gobelin gobelin1 = new Gobelin(6, 1); //je créé mon objet de Gobelin, gobelin1, pour l'utiliser

	public Gobelin() {
		super("Gobelin", 6, 10); // appel le constructeur du parent avec les attributs du parent + par défaut, c-a-d que tous les gobelins auront ses PA et PV
	}
	
	/*@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous êtes sur une case Gobelin");
		return;
	}*/
	//interaction ci-dessous prend la première place et empêche l'affichage de l'interaction de Ennemi
	
}