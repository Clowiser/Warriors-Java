package jeu;

//h�ritage - classe fille de Ennemi
public class Gobelin extends Ennemi {
//cr�ation instance de combat ici
	
	// constructeurs
	public Gobelin(String nom, int niveau, int force) {
		super(nom, niveau, force); // appel le constructeur du parent avec les attributs du parent
	} // m�thode qui ne d�finit pas les infos par d�faut - Gobelin gobelin1 = new Gobelin(6, 1); //je cr�� mon objet de Gobelin, gobelin1, pour l'utiliser

	public Gobelin() {
		super("Gobelin", 6, 10); // appel le constructeur du parent avec les attributs du parent + par d�faut, c-a-d que tous les gobelins auront ses PA et PV
	}
	
	/*@Override
	public void interaction(Personnage personnage) {
		System.out.println("Vous �tes sur une case Gobelin");
		return;
	}*/
	//interaction ci-dessous prend la premi�re place et emp�che l'affichage de l'interaction de Ennemi
	
}