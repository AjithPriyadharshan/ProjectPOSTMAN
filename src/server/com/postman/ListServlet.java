package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) {
		
		ParserClass parserClassObj = new ParserClass();
		
		try {
		ArrayList<File> fileObjects = parserClassObj.parserMethod(); // Parsing the xml file
		req.setAttribute("File", fileObjects); 
		RequestDispatcher dispatcher = req.getRequestDispatcher("urlsList.jsp");
		dispatcher.forward(req, res);
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		
		String paramName = req.getParameter("url"); 
		try {
			PrintWriter out = res.getWriter();
			out.print(paramName); // Displaying the selected URL's param names 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
