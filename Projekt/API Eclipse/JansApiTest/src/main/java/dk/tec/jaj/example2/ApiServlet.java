package dk.tec.jaj.example2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.jaj.AnalyzeRequest;
import dk.tec.jaj.DBTools;
import dk.tec.jaj.Frugt;


//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		ObjectMapper mapper = new ObjectMapper();
		
		DBTools db = new DBTools();
		
		switch(analyze.getMatch())
		{
		case MatchFrugtId:
			Frugt f = db.getFrugtById(analyze.getId());
			out.write(mapper.writeValueAsString(f));
			break;
			
		case MatchFrugt:
			break;
			
		case MatchNo:
			out.write("No Match");
			break;
		}		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String receivedJSON = request.getReader().readLine();
		ObjectMapper mapper = new ObjectMapper();
		
		Frugt f = mapper.readValue(receivedJSON, Frugt.class);
		
		System.out.println(f.getName());
	
		
	}

}
