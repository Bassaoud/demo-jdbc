package fr.diginamic.props;

import java.util.ResourceBundle;
import java.util.Set;

public class TestConfiguration {

	public static void main(String[] args) {
		ResourceBundle monFichierConf = ResourceBundle.getBundle("configfichier");
		String userName = monFichierConf.getString("database.user");
		String passWord = monFichierConf.getString("database.password");
		Set<String> keys = monFichierConf.keySet();

		for (String key : keys) {
			userName = monFichierConf.getString(key);
			System.out.println(userName);
		}

	}

}
