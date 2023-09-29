package dk.tec.jaj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTools 
{
	private String conStr = 
			"jdbc:sqlserver://localhost;databaseName=FrugtDB;encrypt=true;trustServerCertificate=true";

	Connection con;
	Statement stmt;
	
	public DBTools()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void connect() 
	{
		try {
			con = DriverManager.getConnection(conStr, "sa", "1234");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	public Frugt getFrugtById(int id) 
	{
		connect();
		String selectStr = "Select * from Frugt where id = " + id;
		
		Frugt frugt = new Frugt();
		
		try {
			ResultSet result = stmt.executeQuery(selectStr);
			if(result.next())
			{
				frugt.setId(result.getInt("Id"));
				frugt.setName(result.getString("Name"));
				frugt.setDescr(result.getString("Descr"));
				frugt.setWeight(result.getInt("Weight"));
				frugt.setCountry(result.getString("Country"));		
				
				con.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return frugt;
	}




	
	
	
	
}
