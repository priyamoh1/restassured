package GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author SanjayBabu
 *
 */
public class DataBaseUtility {
	/**
	 * connection to DB
	 * @throws SQLException 
	 */
	public void connectToDB() throws SQLException
	{
		Driver ref = new Driver();
		DriverManager.registerDriver(ref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
	}
	/**
	 * Closing DB
	 */
	public void closeDB()
	{
		System.out.println("close DB connection");
	}
}
