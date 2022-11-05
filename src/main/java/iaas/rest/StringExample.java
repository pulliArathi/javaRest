package iaas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/StringExample")
public class StringExample {
	
	@Produces(MediaType.TEXT_HTML)
	@GET
	
	@Path("String/{str}")
	public String getStringOp(@PathParam("str")String s) {
		int length=s.length();
		String caps=s.toLowerCase();
		char c=s.charAt(5);
		char c1=s.charAt(6);
		String in="aeiou";
		String inds="";
		for(int i=0;i<in.length();i++) {
			inds+=s.indexOf(in.charAt(i))+"";
		}
		String last3=s.substring(length-3 , length);
		return length+"<br>"+caps+"<br>"+(c+"").toLowerCase()+"<br>"+(c1+"").toUpperCase()+"<br>"+last3.toUpperCase()+"<br>"+inds;
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	
	@Path("vowels/{string}")
	public String getvowels(@PathParam("string")String s) {
		
		String in="aeiou";
		String inds="";
		int count=0;

		for(int i=0;i<in.length();i++) {
			inds+=s.indexOf(in.charAt(i))+"";
		}
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U') {
				count++;
				
			}
		}		
		
		String vowels="";
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				
				vowels+=Character.toUpperCase(s.charAt(i));
			}
			
			else
				vowels+=s.charAt(i);
					
		}		
	
		return "index of vowels: "+inds+"<br>"+"number of vowels in the given string is: "+count+"<br>"+"To change vowels to upper case: "+vowels;
	
		
	}
	
}
