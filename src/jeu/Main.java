package jeu;

public class Main {
	
	//méthode principale Java : est le point d'entrée de tout programme Java
	public static void main(String[] args) {
		
		Menu menu = new Menu(); // instance de l'objet menu -> création de l'objet pour le lancer
		menu.menuPrincipal(); // appel de la méthode menuPrincipal() de menu
		
		//Game game = new Game();
		//game.menuTest();
		
	}
}