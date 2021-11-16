package jeu;

//h�ritage - classe m�re
//classe d�finit en abstract => elle ne peut pas �tre instanci�
public class Personnage {

	//Attributs
	private String nom; 
	private int niveau;
	private int force;
	
	//METHODES
	//Constructeurs
	public Personnage() { //obligatoire : par d�faut il y a toujours un constructeur vide
		this("personnage par d�faut");
	}
	
	public Personnage(String nom) {
		this(nom, 5, 5);
	}
	
	public Personnage(String nom, int niveau, int force){
		this.nom = nom;
		this.niveau = niveau;
		this.force = force;
	}

	//Getters => prend l'information
	   public String getNom() {
	       return nom;
	   }
	
	   public int getNiveau() {
	       return niveau;
	   }
	   
	   public int getForce() {
	       return force;
	   }
   
	//Setters => renvoie l'information
	   public void setNom(String nom) {
	       this.nom = nom;
	   }
	   
	   public void setNiveau(int niveau) {
	       this.niveau = niveau;
	   }
	   
	   public void setForce(int force) {
	       this.force = force;
	   }
	   
	 //Je d�fini ma propre m�thode toString() - ici, cela prendra uniquement les valeurs similaire de Guerrier et Magicien
	   /*public String toString() {
		   return 
			   "Votre Personnage s'apelle " + this.nom +
			   ", son niveau de vie est de " + this.niveau +
			   " et il dispose d'une force d'attaque de " + this.force;
		}*/
	   
}