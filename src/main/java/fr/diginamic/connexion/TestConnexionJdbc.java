package fr.diginamic.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) {

		ResourceBundle monFichierConf = ResourceBundle.getBundle("database");
		String userName = monFichierConf.getString("database.user");
		String passWord = monFichierConf.getString("database.password");
		String driver = monFichierConf.getString("database.driver");
		String url = monFichierConf.getString("database.url");

		try {
			// Charge le pilote
			Class.forName(driver);
		} catch (ClassNotFoundException e) {

			System.out.println("Driver non trouvé");
		}
		try {
			// Etablit la connexion
			Connection maConnection = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Connexion établie");
			maConnection.close();
		} catch (SQLException e) {

			System.out.println("Impossible d'établir une connexion");
		}

	}

}