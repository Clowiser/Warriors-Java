package jeu;

import java.sql.SQLException;

/**
 * 
 * @author Jessica
 *
 */

public class Main {
	
	//méthode principale Java : est le point d'entrée de tout programme Java
	public static void main(String[] args) throws SQLException {
		
		
		PersonnageDao dao = new PersonnageDao();
		
		dao.getConnect();
		
		Game game = new Game();  // instance de l'objet game -> création de l'objet pour le lancer
		game.initGame(); // appel de la méthode initGame() de game
		
	}
}