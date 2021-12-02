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
	String BDD = "compagniebrascass�s";
	String url = "jdbc:mysql://localhost:3306/" + BDD + "?autoReconnect=true&useSSL=false"; // la derni�re partie d�sactive SSL et supprime �galement les erreurs SSL.
	String user = "JessiRig";
	String pwd = "evolPHP2+";

	// M�thode qui v�rifie la connexion � la BDD => juste la connexion
	public Connection getConnect() {
		if ((connect == null)) {
			try {
				connect = DriverManager.getConnection(url, user, pwd); // getConnection m�thode du DriverManager
				System.out.println("Connexion OK"); // affiche ce message, c'est ok !
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return connect;
	}

	//m�thode pour r�cup�er la liste des guerriers dans la table Hero
	public ArrayList<Guerrier> getGuerrier() { 
		ArrayList<Guerrier> guerrierListe = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(url, user, pwd); // v�rifie la connexion � la BDD
			Statement statement = connection.createStatement(); // objet de type Statement -> va permettre de cr�er une requ�te.
			ResultSet rs = statement.executeQuery("select * from hero WHERE Type = 'Guerrier'"); // requ�te => r�sultat est stock� dans un objet de type ResultSet.
			while (rs.next()) { // m�thode next permet de parcourir les produits r�cup�r�s
				// next() renvoie un objet poss�dant deux propri�t�s done et value. Cette m�thode peut �galement recevoir un param�tre pour envoyer une valeur au g�n�rateur.
				String id = rs.getString("id");
				String nom = rs.getString("nom");
				//getString() = R�cup�re la valeur du nom de colonne d�sign� dans la ligne actuelle de cet objet SQLServerResultSet sous forme de String
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

	//m�thode pour r�cup�er la liste des magiciens dans la table Hero
	public ArrayList<Magicien> getMagicien() {

		ArrayList<Magicien> magicienListe = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(url, user, pwd); // v�rifie la connexion � la BDD
			Statement statement = connection.createStatement(); // objet de type Statement -> va permettre de cr�er une
																// requ�te.
			ResultSet rs = statement.executeQuery("select * from hero WHERE Type = 'Magicien'"); // requ�te => r�sultat
																									// est stock� dans
																									// un objet de type
																									// ResultSet.
			while (rs.next()) { // m�thode next permet de parcourir les produits r�cup�r�s.
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
		PreparedStatement prepare = connect.prepareStatement(query); //PreparedStatement est une sous-interface de Statement. Il est utilis� pour ex�cuter une requ�te param�tr�e.
		System.out.println("Veuillez choisir entre un Guerrier ou un Magicien pour votre personnage :");
		String type = sc.nextLine().toLowerCase(); //toLowerCase() = met en minuscule pour que si l'utilisateur entre le type en majuscule, �a ne provoque pas de probl�me lors du choix ArmeSort et BouclierPhiltre
		System.out.println("Nommez votre personnage :");
		String nom = sc.nextLine();
		System.out.println("Choisissez le niveau de vie de votre personnage - entre 5 et 10 :");
		int vie = sc.nextInt();
		System.out.println("Choisissez la force d'attaque de votre personnage - entre 5 et 10 :");
		int force = sc.nextInt();
		
		if (type.equals("magicien")) { // m�thode equals() disponible dans la classe String utilis�e pour comparer deux cha�nes et d�terminer si elles sont �gales.
			// -> Cette m�thode renvoie une valeur bool�enne � la suite de la comparaison. Si les deux cha�nes contiennent les m�mes caract�res dans le m�me ordre, la m�thode equals () renvoie true. Sinon, il retourne une valeur fausse.
			System.out.println("Choisissez le sort de votre Magicien - entre Boule de Feu et Eclair de Glace:");
		} else {
			System.out.println("Choisissez l'arme de votre Guerrier - entre Masse et Ep�e");
		}
		String armeSort = sc.next();
		
		sc.nextLine();
		if (type.equals("magicien")) { //compare deux chaines et d�termine si elles sont �gales : si type = magicien (ou guerrier) en minuscule, car �crit ici en minuscule alors ce sera la premi�re phrase
			System.out.println("Choisisser le philtre de votre Magicien - entre Philtre de Soin et Philtre de Force");
		} else {
			System.out.println("Choisissez le bouclier de votre Guerrier - entre Bois et Fer");
		}
		String bouclierPhiltre = sc.nextLine();
		//String entree = sc.nextLine(); // derni�re entr�e pour valider la cr�ation de personnage
		
		//Probl�me, j'ai deux cr�ations de personnage h�h� -> donc je dois relier cette cr�ation de personnage au jeu (supprimer l'autre?)
		//r�ussir � r�cup�rer un personnage pour jouer avec

		prepare.setString(1, type);
		prepare.setString(2, nom);
		prepare.setInt(3, vie);
		prepare.setInt(4, force);
		prepare.setString(5, armeSort);
		prepare.setString(6, bouclierPhiltre);
		prepare.executeUpdate(); // Ex�cute l'instruction SQL fournie, qui peut �tre une instruction INSERT, UPDATE ou DELET
	
	}*/

	// supprimer personnage selon id
	public void supprimerPersonnage(int id) throws SQLException {
		String query = " DELETE FROM `Hero` WHERE ID = ?"; //requ�te SQL pour surpprimer par l'id
		PreparedStatement prepare = connect.prepareStatement(query);
		prepare.setInt(1, id); // setInt() est utilis�e pour d�finir la valeur d'un champ en tant qu'entier sur l'objet sp�cifi�
		prepare.executeUpdate();
	}

}