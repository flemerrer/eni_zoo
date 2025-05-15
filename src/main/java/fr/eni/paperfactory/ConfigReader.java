package fr.eni.paperfactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static String getContext() {
		String resultat = "";

		try {
			FileInputStream input = new FileInputStream("config.properties");
			Properties prop = new Properties();

			prop.load(input);

			resultat = prop.getProperty("database.context");

		} catch (IOException e) {
			e.printStackTrace();
			return "MOCK";// Si aucun fichier trouvé
		}

		return resultat;
	}
}
