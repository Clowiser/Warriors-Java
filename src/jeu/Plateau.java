package jeu;

//Création du plateau
public class Plateau {
	
	//Attributs
	private int nbLig; // ligne
	private int nbCol; // colonne
	private char plateau[][]; // représentation du personnage sur le plateau []ligne + []colonne
	//Plateau grille = new Plateau(32, 32); // paramètres du plateau -> portée globale

	
	//Constructeurs
	public Plateau(int l, int c) {
		nbLig = l;
		nbCol = c;
		plateau = new char[nbLig][nbCol];
		
		
		for (int i=0; i<nbLig; i++){
			for(int j=0; j<nbCol; j++){
				
				plateau[i][j] = '_'; // on remplit le plateau de _ -> pour les emplacements ( _ = vide ; X = personnage ; E = ennemi ; O = objet ) 
			}
		}
		
	}
	
	//Méthodes
	//afficher le plateau
	public void afficher() {
		
		System.out.println();
		for (int i=0; i<nbLig; i++){
			for(int j=0; j<nbCol; j++){
				
				System.out.print(" | " + plateau[i][j]); // affiche la plateau avec une | + emplacements et se répète de la longueur du tableau
				
			}
			
			System.out.println(" | "); // affiche la dernière | de chaque ligne
		}
		
		System.out.println(); // saut de ligne à la fin du tableau
		
	}
	
	//Getters
	//pour récupérer la case passée en paramètre
	public char getCase(int l, int c) {
		return plateau[l-1][c-1];
	}
	
	
	//Setters
	
	
	//Actions
	//Placer
	public void placer(int l, int c, char o){ // ligne et colonne où on veut placer le joueur, char est une lettre
		
		l = l-1; // ligne -1 -> part de 0 
		c = c-1; // colonne - 1 -> part de 0
		// ligne et colonne sont des tableaux donc commence à 0 car si joueur se place en 1, cela fera l-1 = 1-1 = 0 et c-1 = 1-1 = 0  
		
		if(l<0 || c<0 || l>nbLig || c>nbCol) { // si ligne < 0 OU colonne < 0 OU ligne > à []ligne OU colonne > []colonne -> test tous les cas de figure pour savoir si on dépasse le plateau
			System.out.print(" !! Erreur de placement !!"); // si erreur alors affiche ce message
			return; // pour sortir de cette fonction
		}else if(plateau[l][c] == 'A') {
			System.out.print("Bravo ! Vous avez réussi !");
		}
		
		if(plateau[l][c] == '_') { // si la case lig/col est égal à _ soit à vide 
			plateau[l][c] = o; // alors remplace par la lettre correspondant au personnage (un caractère)
		}else { // sinon
			System.out.print("Cette zone a un événement !"); // affiche ce message
		}
		
	}
	
	public void deplacerH(){ // déplacer uniquement le personnage par le haut : i-1
		
		char tmp;
		//parcours l'intégralité du plateau
		for (int i=0; i<nbLig; i++){ 
			for(int j=0; j<nbCol; j++){
				if(plateau[i][j] == 'X'){ // on cherche le personnage
					if(i-1 >= 0 && plateau[i-1][j] == '_') { // on teste la position // veut dire : si en dessus du joueur il y a encore une case du plateau 
						tmp = plateau[i][j]; // on copie le personnage
						plateau[i][j] = '_'; // on vide la case
						plateau[i-1][j] = tmp; // on déplace le personnage
						
						}
					}
				}
			}
	}
	
	public void deplacerB(){ // déplacer uniquement le personnage par le bas : i+1
			
			char tmp;
			//parcours l'intégralité du plateau
			for (int i=0; i<nbLig; i++){ 
				for(int j=0; j<nbCol; j++){
					if(plateau[i][j] == 'X'){ // on cherche le personnage
						if(i+1 <= nbLig-i && plateau[i+1][j] == '_') { // on teste la position // veut dire : si en dessus du joueur il y a encore une case du plateau 
							tmp = plateau[i][j]; // on copie le personnage
							plateau[i][j] = '_'; // on vide la case
							plateau[i+1][j] = tmp; // on déplace le personnage
							
							}
						}
					}
				}
		}
	
	public void deplacerD(){ // déplacer uniquement le personnage par la droite : j+1
		
		char tmp;
		//parcours l'intégralité du plateau
		for (int i=0; i<nbLig; i++){ 
			for(int j=0; j<nbCol; j++){
				if(plateau[i][j] == 'X'){ // on cherche le personnage
					if(j+1 <= nbCol-1 && plateau[i][j+1] == '_') { // on teste la position // veut dire : si en dessus du joueur il y a encore une case du plateau 
						tmp = plateau[i][j]; // on copie le personnage
						plateau[i][j] = '_'; // on vide la case
						plateau[i][j+1] = tmp; // on déplace le personnage
						
						}
					}
				}
			}
	}
	
	public void deplacerG(){ // déplacer uniquement le personnage par la gauche : j-1
			
			char tmp;
			//parcours l'intégralité du plateau
			for (int i=0; i<nbLig; i++){ 
				for(int j=0; j<nbCol; j++){
					if(plateau[i][j] == 'X'){ // on cherche le personnage
						if(j-1 >= 0 && plateau[i][j-1] == '_') { // on teste la position // veut dire : si en dessus du joueur il y a encore une case du plateau 
							tmp = plateau[i][j]; // on copie le personnage
							plateau[i][j] = '_'; // on vide la case
							plateau[i][j-1] = tmp; // on déplace le personnage
							
							}
						}
					}
				}
		}

}