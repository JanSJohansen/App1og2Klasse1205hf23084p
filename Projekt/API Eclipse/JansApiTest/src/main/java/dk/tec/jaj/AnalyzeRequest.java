package dk.tec.jaj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalyzeRequest 
{
	MatchEnum match;
	int id;
	
	public MatchEnum getMatch() {
		return match;
	}

	public int getId() {
		return id;
	}

	public AnalyzeRequest(String pathInfo) 
	{
		Matcher matcher = Pattern.compile("/Frugt/([0-9]+)").matcher(pathInfo);
		
		if(matcher.find())
		{
			match = MatchEnum.MatchFrugtId;
			id = Integer.parseInt(matcher.group(1));	
		}
		else 
		{
			 matcher = Pattern.compile("/Frugt").matcher(pathInfo);
			 if(matcher.find())
			 {
				 match = MatchEnum.MatchFrugt;
			 }
			 else
			 {
				 match = MatchEnum.MatchNo;
			 }
		}	
	}
}
