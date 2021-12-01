package jeu;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonnageDao {

	private final Scanner sc = new Scanner(System.in);

// 1 - Partie connexion 	
	private Connection connect;
	String BDD = "compagniebrascassés";
	String url = "jdbc:mysql://localhost:3306/" + BDD + "?autoReconnect=true&useSSL=false";
	// ou //private String url = "jdbc:mysql://localhost/homeshop";
	String user = "root";
	String pwd = "";

	// Méthode qui vérifie la connexion à la BDD
	public Connection getConnect() {
		if ((connect == null)) {
			try {
				connect = DriverManager.getConnection(url, user, pwd); // getConnection méthode du DriverManager
				System.out.println("Connexion OK"); // affiche ce message, c'est ok !
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connect;
	}

	public ArrayList<Guerrier> getGuerrier() {
		ArrayList<Guerrier> guerrierListe = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(url, user, pwd); // vérifie la connexion à la BDD
			Statement statement = connection.createStatement(); // objet de type Statement -> va permettre de créer une
																// requête.
			ResultSet rs = statement.executeQuery("select * from hero WHERE Type = 'Guerrier'"); // requête => résultat
																									// est stocké dans
																									// un objet de type
																									// ResultSet.
			while (rs.next()) { // méthode next permet de parcourir les produits récupérés.
				String id = rs.getString("id");
				String nom = rs.getString("nom");
				String type = rs.getString("Type");
				int vie = rs.getInt("niveauVie");
				int force = rs.getInt("niveauForce");
				String arme = rs.getString("ArmeSort");
				String bouclier = rs.getNString("BouclierPhiltre");
				guerrierListe.add(new Guerrier(nom, vie, force)); // ajoute ce que contient la table dans le tableau
				System.out.println("Guerrier : " + id + " " + nom + " " + type + " " + vie + " " + force + " " + arme
						+ " " + bouclier); // affichage
			}
			// connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return guerrierListe;
	}

	public ArrayList<Magicien> getMagicien() {

		ArrayList<Magicien> magicienListe = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(url, user, pwd); // vérifie la connexion à la BDD
			Statement statement = connection.createStatement(); // objet de type Statement -> va permettre de créer une
																// requête.
			ResultSet rs = statement.executeQuery("select * from hero WHERE Type = 'Magicien'"); // requête => résultat
																									// est stocké dans
																									// un objet de type
																									// ResultSet.
			while (rs.next()) { // méthode next permet de parcourir les produits récupérés.
				String id = rs.getString("id");
				String nom = rs.getString("nom");
				String type = rs.getString("Type");
				int vie = rs.getInt("niveauVie");
				int force = rs.getInt("niveauForce");
				String sort = rs.getString("ArmeSort");
				String philtre = rs.getNString("BouclierPhiltre");
				magicienListe.add(new Magicien(nom, vie, force)); // ajoute ce que contient la table dans le tableau
				System.out.println("Magicien : " + id + " " + nom + " " + type + " " + vie + " " + force + " " + sort
						+ " " + philtre); // affichage
			}
			// connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return magicienListe;
	}

	public void createHero() throws SQLException {
		String query = "INSERT INTO Hero(Type, nom, niveauVie, niveauForce, ArmeSort, BouclierPhiltre) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement prepare = connect.prepareStatement(query);
		System.out.println("Veuillez choisir entre un Guerrier ou un Magicien pour votre personnage :");
		String type = sc.nextLine().toLowerCase();
		System.out.println("Nommez votre personnage :");
		String nom = sc.nextLine();
		System.out.println("Choisissez le niveau de vie de votre personnage - entre 5 et 10 :");
		int vie = sc.nextInt();
		System.out.println("Choisissez la force d'attaque de votre personnage - entre 5 et 10 :");
		int force = sc.nextInt();
		String armeSort = sc.nextLine();
		if (type.equals("magicien")) {
			System.out.println("Choisissez le sort de votre Magicien - entre Boule de Feu et Eclair de Glace:");
		} else {
			System.out.println("Choisissez l'arme de votre Guerrier - entre Masse et Epée");
		}
		String bouclierPhiltre = sc.nextLine();
		if (type.equals("magicien")) {
			System.out.println("Choisisser le philtre de votre Magicien - entre Philtre de Soin et Philtre de Force");
		} else {
			System.out.println("Choisissez le bouclier de votre Guerrier - entre Bois et Fer");
		}
		String entree = sc.nextLine(); // dernière entrée pour valider la création de personnage
		
		//Problème, j'ai deux créations de personnage héhé
		//problème : ça me décale l'info pour les if

		prepare.setString(1, type);
		prepare.setString(2, nom);
		prepare.setInt(3, vie);
		prepare.setInt(4, force);
		prepare.setString(5, armeSort);
		prepare.setString(6, bouclierPhiltre);
		prepare.executeUpdate();
	}

	// supprimer personnage selon id
	public void supprimerPersonnage(Connection connect, int id) throws SQLException {
		String query = " DELETE FROM `Hero` WHERE ID = ?";
		PreparedStatement prepare = connect.prepareStatement(query);
		prepare.setInt(1, id);
		prepare.executeUpdate();
	}

}