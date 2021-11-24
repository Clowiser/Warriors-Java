package jeu;

//h�ritage - classe fille de Case
public class Ennemi extends Case {
	
	private int niveau;
	private int force;
	
	//METHODES
		//Constructeurs -> par d�faut il y a toujours un constructeur vide
		public Ennemi() {
			this(5, 5);
		}
		
		public Ennemi(int niveau, int force){
			this.niveau = niveau;
			this.force = force;
		}

		//Getters => prend l'information
		   protected int getNiveau() {
		       return niveau;
		   }
		   
		   public int getForce() {
		       return force;
		   }
	   
		//Setters => renvoie l'information
		   public void setNiveau(int niveau) {
		       this.niveau = niveau;
		   }
		   
		   public void setForce(int force) {
		       this.force = force;
		   }
		   
	@Override
	public String toString() { //renvoie une cha�ne de caract�res servant � d�crire l'objet concern�.
		return "Ennemi";
	}

}