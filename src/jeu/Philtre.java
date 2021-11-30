package jeu;

public class Philtre implements Case {
	private String philtre;
	private int pointVie;

	//constructeur
	public Philtre() {
		this("philtre par défaut", 3);
	}
	
	public Philtre(String philtre, int pointVie){
		this.philtre = philtre;
		this.pointVie = pointVie;
	}
	
	public String toString() {
		return philtre;
	}
	
	//getters
	public int getPointVie() {
		return pointVie;
	}
	
	public String getPhiltre() {
		return philtre;
	}
	
	//setters
	public void setPhiltre(String philtre) {
		this.philtre = philtre;
	}

	public void setPointVie(int pointVie) {
		this.pointVie = pointVie;
	}
	
	public void interaction(Personnage personnage) {
		System.out.println("Vous trouvez un philtre magique : la " + getPhiltre() + " ! ");
		if (personnage instanceof Magicien) {
			Magicien joueurMagicien = (Magicien) personnage; // cast -> Magicien
			System.out.println("Vous êtes un Magicien, prenez " + getPhiltre() + " pour récupérer " + this.getPointVie()
					+ " d'attaque ! ");
			joueurMagicien.setForce(joueurMagicien.getForce() + this.pointVie);
		} else {
			System.out.println("Vous n'êtes pas Magicien, passez votre chemin !");
		}
		return;
	}
}