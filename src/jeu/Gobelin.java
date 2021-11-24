package jeu;

//héritage - classe fille de Ennemi
public class Gobelin extends Ennemi {
	
	//constructeurs
	public Gobelin(int niveau, int force) {
		super(niveau, force); // appel le constructeur du parent avec les attributs du parent
	} // méthode qui ne définit pas les infos par défaut - //Gobelin gobelin1 = new Gobelin(6, 1); //je créé mon objet de Gobelin, gobelin1, pour l'utiliser

	//public Gobelin() {
		//super(6, 1); // appel le constructeur du parent avec les attributs du parent + par défaut, c-a-d que tous les gobelins auront ses PA et PV
	//}

	public String toString() {
	   return 
		   "Gobelin, a une force de " + this.getForce() + " et une vie de " + this.getNiveau();
	   		//"Gobelin a " + getForce() + " en points d'attaque grâce à son épée ! Ses points de vie sont de " + getNiveau();
	}	
	
}