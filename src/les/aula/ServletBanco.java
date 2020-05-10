package les.aula;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/loginbanco")
public class ServletBanco extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String usuario = req.getParameter("USER");
		String password = req.getParameter("PASS");
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		DaoGenerica dao = new DaoGenericaConc();
		try {
			Connection conect = dao.getConnection();
			String sql = "SELECT user, pass FROM logins WHERE usuario = ? AND pass = ?";
			PreparedStatement state = conect.prepareStatement(sql);
			state.setString(1, usuario);
			state.setString(2, password);
			ResultSet resultado = state.executeQuery();
			if(resultado.next()) 
			{
				out.println("Login efetuado com sucesso!!!");
				out.flush();
			}
			else 
			{
				out.println("Falha no Login! Usuário e/ou senha incorreta!!!");
				out.flush();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
