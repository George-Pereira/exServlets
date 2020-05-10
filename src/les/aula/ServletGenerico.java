package les.aula;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/generico")
public class ServletGenerico extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String d = req.getParameter("D");
		System.out.println("Data Enviada = " + d);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<h3>Olá navegador, obrigado por acionar o servlet generico!/n A data enviada foi: " + d + "</h3>");
		out.flush();
	}
}
