package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDAO{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Fournisseur> extraire() {
		
		Connection maConnection = null;
		ResultSet résultats = null;
		try {
			Statement monStatement = maConnection.createStatement();
			résultats = monStatement.executeQuery("SELECT * FROM fournisseur");
			ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
			while (résultats.next()) {
				Integer id = résultats.getInt("ID");
				String nom = résultats.getString("NOM");
				
				Fournisseur fouCourant = new Fournisseur(id, nom);
				fournisseurs.add(fouCourant);
				
				System.out.println(fournisseurs);
			}
			maConnection.commit();
			maConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Echec");
		}
		return null;
	}

	@Override
	public void insert(Fournisseur fournisseur) {

		Connection maConnection = null;
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

	@Override
	public int update(String ancienNom, String nouveauNom) {
		
		Connection maConnection = null;

		try {
			Statement monStatement = maConnection.createStatement();
			int nb = monStatement
					.executeUpdate("UPDATE fournisseur "
							+ "SET nom = 'Maison des Peintures'" 
							+"WHERE id=4");
			maConnection.commit();
			maConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Echec");
		}
		return 0;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		
		Connection maConnection = null;

		try {
			Statement monStatement = maConnection.createStatement();
			int nb = monStatement
					.executeUpdate("DELETE FROM fournisseur WHERE nom='Maison des Peintures'");
			maConnection.commit();
			maConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Echec");
		}
		return false;
	}

}
