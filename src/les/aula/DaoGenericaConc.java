package les.aula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoGenericaConc implements DaoGenerica
{
	private Connection connect;
	@Override
	public Connection getConnection() throws SQLException
	{
		try 
		{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=exServlet;namedPipes=true");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		return connect;
	}
}