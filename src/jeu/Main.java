package jeu;

import java.sql.SQLException;

/**
 * 
 * @author Jessica
 *
 */

public class Main {
	
	//m�thode principale Java : est le point d'entr�e de tout programme Java
	public static void main(String[] args) throws SQLException {
		
		
		PersonnageDao dao = new PersonnageDao();
		
		dao.getConnect();
		
		Game game = new Game();  // instance de l'objet game -> cr�ation de l'objet pour le lancer
		game.initGame(); // appel de la m�thode initGame() de game
		
	}
}