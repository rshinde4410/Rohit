package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(new FileInputStream("resources/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key) {
		return prop.getProperty(key);
	}

}
