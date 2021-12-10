import javax.servlet.*;
import java.io.*;
import java.util.Scanner;

public class ServletOperacion extends GenericServlet{

	public void service(ServletRequest request, ServletResponse response) throws IOException{

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String action = request.getParameter("action");
		int resultado = 0;
		PrintWriter out = response.getWriter();
		File archivo = new File("/var/lib/jetty/resources/resultados.txt");
		//Comprobamos si existe el archivo y si no lo creamos
		try {
			if(!archivo.exists()) {
				archivo.createNewFile();
			}
		}catch(IOException e) {
			PrintWriter writer = response.getWriter();
			out.println("NADA");
		}
		if (action.equals("SUMAR")){
			resultado = num1 + num2;
			
			out.println("La resta estre el número " + num1 + " y " + num2 + " es: " + resultado);
			
			PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));
			writer.write("El resultado de " + action + " de " + num1 + " y " + num2 + " es: " + resultado + "\n");
			writer.close();
		}
		else if(action.equals("RESTAR")) {
			resultado = num1 - num2;
			
			out.println("La resta estre el número " + num1 + " y " + num2 + " es: " + resultado);
			PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));
			writer.write("El resultado de " + action + " de " + num1 + " y " + num2 + " es: " + resultado + "\n");
			writer.close();
		}
		else if(action.equals("DIVIDIR")) {
			resultado = num1/num2;
			
			out.println("La división estre el número " + num1 + " y " + num2 + " es: " + resultado);
			PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));
			writer.write("El resultado de " + action + " de " + num1 + " y " + num2 + " es: " + resultado + "\n");
			writer.close();
		}
		
		else if(action.equals("MULTIPLICAR")) {
			resultado = num1 * num2;
			
			out.println("La multiplicación estre el número " + num1 + " y " + num2 + " es: " + resultado);
			PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));
			writer.write("El resultado de " + action + " de " + num1 + " y " + num2 + " es: " + resultado + "\n");
			writer.close();
		}
		else if(action.equals("VER_OPERACIONES_ANTERIORES")) {
			 Scanner obj = new Scanner(archivo);
			 if (obj.hasNextLine()) {
				 while (obj.hasNextLine()) {
			    	 out.println(obj.nextLine());
			    	 out.println("\n");
				 }
		     }
			 else {
				 out.println("No hay ninguna operación guardada");
			 }	 
		     obj.close();
		}
		
	}
}