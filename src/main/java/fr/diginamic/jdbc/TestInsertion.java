package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

	public static void main(String[] args) {

		ResourceBundle monFichierConf = ResourceBundle.getBundle("configfichier");
		String userName = monFichierConf.getString("database.user");
		String passWord = monFichierConf.getString("database.password");
		String driver = monFichierConf.getString("database.driver");
		String url = monFichierConf.getString("database.url");

		try {
			// Charge le pilote
			Class.forName(driver);
		} catch (ClassNotFoundException e) {

			System.out.println("Driver non trouv�");
		}
		Connection maConnection = null;
		try {
			// Etablit la connexion
			maConnection = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connexion �tablie");

		} catch (SQLException e) {

			System.out.println("Impossible d'�tablir une connexion");
		}

		try {
			Statement monStatement = maConnection.createStatement();
			int nb = monStatement
					.executeUpdate("INSERT INTO fournisseur(ID, NOM)" + "VALUES (4, 'La Maison de la Peinture')");
			maConnection.commit();
			maConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Echec");
		}
	}

}
