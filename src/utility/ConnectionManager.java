package utility;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

//import oracle.ons.Connection;

import java.sql.Connection;



public class ConnectionManager{
	public Connection getConnection() throws Exception 
	{
		Properties prop=loadPropertiesFile();
		String driver=prop.getProperty("driver");
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		
		Class.forName(driver);
		Connection con=null;
 	con=DriverManager.getConnection(url,username,password);
		return con;
		
		
	}
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
}


