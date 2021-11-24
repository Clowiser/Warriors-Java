package jeu;

//h�ritage - classe fille de Ennemi
public class Gobelin extends Ennemi {
	
	//constructeurs
	public Gobelin(int niveau, int force) {
		super(niveau, force); // appel le constructeur du parent avec les attributs du parent
	} // m�thode qui ne d�finit pas les infos par d�faut - //Gobelin gobelin1 = new Gobelin(6, 1); //je cr�� mon objet de Gobelin, gobelin1, pour l'utiliser

	//public Gobelin() {
		//super(6, 1); // appel le constructeur du parent avec les attributs du parent + par d�faut, c-a-d que tous les gobelins auront ses PA et PV
	//}

	public String toString() {
	   return 
		   "Gobelin, a une force de " + this.getForce() + " et une vie de " + this.getNiveau();
	   		//"Gobelin a " + getForce() + " en points d'attaque gr�ce � son �p�e ! Ses points de vie sont de " + getNiveau();
	}	
	
}