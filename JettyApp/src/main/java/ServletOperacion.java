import javax.servlet.*;
import java.io.*;

public class ServletOperacion extends GenericServlet{

	public void service(ServletRequest request, ServletResponse response) throws IOException{

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String action = request.getParameter("action");
		if (action.equals("SUMAR")){
			int suma = num1 + num2;
			
			PrintWriter out = response.getWriter();
			out.println("La resta estre el número " + num1 + " y " + num2 + " es: " + suma);
		}
		else if(action.equals("RESTAR")) {
			int resta = num1 - num2;
			
			PrintWriter out = response.getWriter();
			out.println("La resta estre el número " + num1 + " y " + num2 + " es: " + resta);
		
		}
		else if(action.equals("DIVIDIR")) {
			int div = num1/num2;
			
			PrintWriter out = response.getWriter();
			out.println("La división estre el número " + num1 + " y " + num2 + " es: " + div);
		
		}
		
		else if(action.equals("MULTIPLICAR")) {
			int mult = num1 * num2;
			
			PrintWriter out = response.getWriter();
			out.println("La multiplicación estre el número " + num1 + " y " + num2 + " es: " + mult);
		
		}
			
		}
}