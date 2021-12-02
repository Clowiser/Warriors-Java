package jeu;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonnageDao {

	private final Scanner sc = new Scanner(System.in);

// 1 - Partie connexion 	
	private Connection connect;
	String BDD = "compagniebrascassés";
	String url = "jdbc:mysql://localhost:3306/" + BDD + "?autoReconnect=true&useSSL=false"; // la dernière partie désactive SSL et supprime également les erreurs SSL.
	String user = "JessiRig";
	String pwd = "evolPHP2+";

	// Méthode qui vérifie la connexion à la BDD => juste la connexion
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

	//méthode pour récupéer la liste des guerriers dans la table Hero
	public ArrayList<Guerrier> getGuerrier() { 
		ArrayList<Guerrier> guerrierListe = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(url, user, pwd); // vérifie la connexion à la BDD
			Statement statement = connection.createStatement(); // objet de type Statement -> va permettre de créer une requête.
			ResultSet rs = statement.executeQuery("select * from hero WHERE Type = 'Guerrier'"); // requête => résultat est stocké dans un objet de type ResultSet.
			while (rs.next()) { // méthode next permet de parcourir les produits récupérés
				// next() renvoie un objet possédant deux propriétés done et value. Cette méthode peut également recevoir un paramètre pour envoyer une valeur au générateur.
				String id = rs.getString("id");
				String nom = rs.getString("nom");
				//getString() = Récupère la valeur du nom de colonne désigné dans la ligne actuelle de cet objet SQLServerResultSet sous forme de String
				String type = rs.getString("Type");
				int vie = rs.getInt("niveauVie");
				int force = rs.getInt("niveauForce");
				String arme = rs.getString("ArmeSort");
				String bouclier = rs.getString("BouclierPhiltre");
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

	//méthode pour récupéer la liste des magiciens dans la table Hero
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
				String philtre = rs.getString("BouclierPhiltre");
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

	/*public void createPersonnage() throws SQLException {
		String query = "INSERT INTO Hero(Type, nom, niveauVie, niveauForce, ArmeSort, BouclierPhiltre) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement prepare = connect.prepareStatement(query); //PreparedStatement est une sous-interface de Statement. Il est utilisé pour exécuter une requête paramétrée.
		System.out.println("Veuillez choisir entre un Guerrier ou un Magicien pour votre personnage :");
		String type = sc.nextLine().toLowerCase(); //toLowerCase() = met en minuscule pour que si l'utilisateur entre le type en majuscule, ça ne provoque pas de problème lors du choix ArmeSort et BouclierPhiltre
		System.out.println("Nommez votre personnage :");
		String nom = sc.nextLine();
		System.out.println("Choisissez le niveau de vie de votre personnage - entre 5 et 10 :");
		int vie = sc.nextInt();
		System.out.println("Choisissez la force d'attaque de votre personnage - entre 5 et 10 :");
		int force = sc.nextInt();
		
		if (type.equals("magicien")) { // méthode equals() disponible dans la classe String utilisée pour comparer deux chaînes et déterminer si elles sont égales.
			// -> Cette méthode renvoie une valeur booléenne à la suite de la comparaison. Si les deux chaînes contiennent les mêmes caractères dans le même ordre, la méthode equals () renvoie true. Sinon, il retourne une valeur fausse.
			System.out.println("Choisissez le sort de votre Magicien - entre Boule de Feu et Eclair de Glace:");
		} else {
			System.out.println("Choisissez l'arme de votre Guerrier - entre Masse et Epée");
		}
		String armeSort = sc.next();
		
		sc.nextLine();
		if (type.equals("magicien")) { //compare deux chaines et détermine si elles sont égales : si type = magicien (ou guerrier) en minuscule, car écrit ici en minuscule alors ce sera la première phrase
			System.out.println("Choisisser le philtre de votre Magicien - entre Philtre de Soin et Philtre de Force");
		} else {
			System.out.println("Choisissez le bouclier de votre Guerrier - entre Bois et Fer");
		}
		String bouclierPhiltre = sc.nextLine();
		//String entree = sc.nextLine(); // dernière entrée pour valider la création de personnage
		
		//Problème, j'ai deux créations de personnage héhé -> donc je dois relier cette création de personnage au jeu (supprimer l'autre?)
		//réussir à récupérer un personnage pour jouer avec

		prepare.setString(1, type);
		prepare.setString(2, nom);
		prepare.setInt(3, vie);
		prepare.setInt(4, force);
		prepare.setString(5, armeSort);
		prepare.setString(6, bouclierPhiltre);
		prepare.executeUpdate(); // Exécute l'instruction SQL fournie, qui peut être une instruction INSERT, UPDATE ou DELET
	
	}*/

	// supprimer personnage selon id
	public void supprimerPersonnage(int id) throws SQLException {
		String query = " DELETE FROM `Hero` WHERE ID = ?"; //requête SQL pour surpprimer par l'id
		PreparedStatement prepare = connect.prepareStatement(query);
		prepare.setInt(1, id); // setInt() est utilisée pour définir la valeur d'un champ en tant qu'entier sur l'objet spécifié
		prepare.executeUpdate();
	}

}