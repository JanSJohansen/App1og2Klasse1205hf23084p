package dk.tec.jaj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ApiServlet")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//out.write("Context Path: " + request.getContextPath());
		//out.write("\nServlet Path: " + request.getServletPath());
		//out.write("\nPath Info: " + request.getPathInfo());
		
		AnalyzeRequest analyze = new AnalyzeRequest(request.getPathInfo());
		
		switch(analyze.getMatch())
		{
		case MatchFrugtId:
			out.write("Match på FrugtId id:" + analyze.getId());
			break;
			
		case MatchFrugt:
			out.write("Match på Frugt");
			break;
			
		case MatchNo:
			out.write("No Match");
			break;
		}
		
	}

}
