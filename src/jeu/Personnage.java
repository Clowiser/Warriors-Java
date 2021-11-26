package jeu;

//h�ritage - classe m�re
//classe d�finit en abstract => elle ne peut pas �tre instanci�
public abstract class Personnage {

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
	
	//constructeurs commun aux personnages + sont en protected pour que les classes enfants utilise ce constructeur parent.
	protected Personnage(String nom, int niveau, int force){
		this.nom = nom; //this fait r�f�rence � l'objet concern� (Guerrier si Guerrier/Magicien si Magicien)
		this.niveau = niveau;
		this.force = force;
	}

	//Getters => prend/r�cup�re l'information
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
	  public String toString() {
		   return 
			   "Votre Personnage s'apelle " + this.nom +
			   ", son niveau de vie est de " + this.niveau +
			   " et il dispose d'une force d'attaque de " + this.force;
		}
	   
}