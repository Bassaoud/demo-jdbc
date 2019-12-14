package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestSelect {
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

		ResultSet r�sultats = null;
		try {
			Statement monStatement = maConnection.createStatement();
			r�sultats = monStatement.executeQuery("SELECT * FROM fournisseur");
			//System.out.println(r�sultats);
			maConnection.commit();
			maConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Echec");
		}
	}
public static void ToString() {
	
}
}
