package fr.diginamic.jdbc.entites;

import java.util.List;

public class Fournisseur {
		private int id;
		private String nom;
		
		public Fournisseur(int id, String nom) {
			super();
			this.id = id;
			this.nom = nom;
}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
		}
		@Override
		public String toString() {
			return "Fournisseur [id=" + id + ", nom=" + nom + "]";
		}
		
}