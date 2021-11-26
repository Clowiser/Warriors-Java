package jeu;

import java.util.Scanner;

public abstract class Arme extends Case {
	private String arme;
	private int attaque;

	// constructeur
	protected Arme(String arme, int attaque) {
		this.arme = arme;
		this.attaque = attaque;
	}

	// accesseurs
	// getters
	public String getArme() {
		return arme;
	}

	public int getAttaque() {
		return attaque;
	}

	// setters
	public void setArme(String arme) {
		this.arme = arme;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	
	public String toString() {
		return arme;
	}

	@Override
	public void interaction(Personnage personnage) {
		if (personnage instanceof Guerrier) {
			Guerrier joueurGuerrier = (Guerrier)personnage; //cast -> Guerrier appelé joueurGuerrier = 
			  System.out.println("Vous êtes un Guerrier, prenez " + ((this instanceof Masse)? " cette massue" : " cette épée"));
			  Scanner scanner = new Scanner(System.in);
			  int weapon = scanner.nextInt();
			  switch(weapon) {
			  case 1:
				  joueurGuerrier.forceGuerArme(this);
				  System.out.println("Votre attaque est maintenant de " + joueurGuerrier.getForce());
				  break;
			  case 2:
				  break;
			  }
			  //récupérer le nombre de point d'attaque de l'arme pour ajouter à la force du Guerrier
			
		}else{
            System.out.println("Vous n'êtes pas Guerrier, passez votre chemin !");
        }
	}
	
	//+ " pour récupérer " + this.getAttaque() + "! ")
	// c'est dans l'interaction du personnage (de la classe Personnage) que si le
	// personnage est un Guerrier, s'il tombe sur la case de l'arme, il peut
	// intérargir avec elle.

}