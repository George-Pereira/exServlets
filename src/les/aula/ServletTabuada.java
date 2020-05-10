package les.aula;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/tabuada")
public class ServletTabuada extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String numero = req.getParameter("NUM");
		int num = Integer.parseInt(numero);
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		for(int i = 0; i < 11; i ++) 
		{
			out.println("<h3>" + num + " X " + i + " = " + (num * i) + "</h3><br>");
			out.flush();
		}
	}
}
