package jeu;

public class Philtre{
	private String philtre;

	//constructeur
	public Philtre() {
		this("philtre par défaut");
	}
	
	public Philtre(String philtre){
		this.philtre = philtre;
	}
	
	public String toString() {
		return philtre;
	}
	
	//getters et setters
		/*public String getPhiltre() {
			return philtre;
		}

		public void setPhiltre(String philtre) {
			this.philtre = philtre;
		}*/
}