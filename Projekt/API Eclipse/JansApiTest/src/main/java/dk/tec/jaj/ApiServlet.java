package dk.tec.jaj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;


//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//out.write("Context Path: " + request.getContextPath());
		//out.write("\nServlet Path: " + request.getServletPath());
		//out.write("\nPath Info: " + request.getPathInfo());
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		ArrayList<Frugt> frugter = new ArrayList<Frugt>();
		frugter.add(new Frugt(1, "Appelsin", "Den er meget sur", 12300, "New Orangeleans"));
		frugter.add(new Frugt(2, "Gulerøder", "Orange", 12300, "New Gulorleans"));
		frugter.add(new Frugt(3, "Tomat Eje", "De er meget sure", 12300, "New Tomatorleans"));
		frugter.add(new Frugt(4, "Birthe Rønnebær", "Hun er meget sure", 12300, "New Rønorleans"));
		
		ObjectMapper mapper = new ObjectMapper();
		DBTools db = new DBTools();
		
		
		switch(analyze.getMatch())
		{
		case MatchFrugtId:
			//out.write("Match på FrugtId id:" + analyze.getId());
			//out.write(mapper.writeValueAsString(frugter.get(analyze.getId())));
			Frugt f = db.getFrugtById(analyze.getId());
			out.write(mapper.writeValueAsString(f));
			
			break;
			
		case MatchFrugt:
			//out.write("Match på Frugt");
			out.write(mapper.writeValueAsString(frugter));
			break;
			
		case MatchNo:
			out.write("No Match");
			break;
		}
		
	}

}
