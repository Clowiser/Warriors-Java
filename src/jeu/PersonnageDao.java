package jeu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PersonnageDao {
	
	private Connection connect;
	String BDD = "compagniebrascassés";
	String url = "jdbc:mysql://localhost:3306/" + BDD;
	// ou //private String url = "jdbc:mysql://localhost/homeshop";
	String user = "JessiRig";
	String pwd = "evolPHP2+";
	
	// Méthode publique qui vérifie la connexion  à la BDD
	 public Connection getConnect() {
	        if ((connect == null)) {
	            try {
	                connect = DriverManager.getConnection(url, user, pwd);
	                System.out.println("Connexion OK");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return connect;
	    }

	public List<Guerrier> getAll() {
		List<Guerrier> guerrierListe = new ArrayList<>();
	    try {
	        Connection connection = DriverManager.getConnection(url, user, pwd);
	        Statement statement = connection.createStatement(); //objet de type Statement -> va permettre de créer une requête.
	        ResultSet rs = statement.executeQuery("select * from hero"); //résultat est stocké dans un objet de type ResultSet.
	        while (rs.next()) { //méthode next permet de parcourir les produits récupérés.
	            String nom = rs.getString("Nom : ");
	            int vie = rs.getInt("Vie : ");
	            int force = rs.getInt("Force : ");
	            guerrierListe.add(new Guerrier(nom, vie, force));
	        }
	        //connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return guerrierListe;
	}

}