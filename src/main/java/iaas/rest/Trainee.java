package iaas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import iaas.restExample.Constructor;
import iaas.restExample.child;


@Path("/trainee")
public class Trainee {
	@GET
	@Produces("text/plain")
	@Path("all")
	public String wish() {
		String s="hello";
		return "good morning"+s;
	}
	
	@GET
	@Produces("text/plain")
	@Path("{add_1}/{add_2}")
	public String wish(@PathParam("add_1")int i,@PathParam("add_2")int j) {
		return  "Adding of two numbers:"+(i+j);
	}
	@GET
	@Produces("text/plain")
	@Path("add/{n1},{n2}")
	public String add(@PathParam("n1")String x,@PathParam("n2")String y) {
		try {
			float sum=Float.parseFloat(x)+Float.parseFloat(y);
			return "sum:"+sum+"";
		}
		catch(NumberFormatException e) {
			return "<h1>one or more values are not numeric<br>sum:unknown</h1>";
		}
		
	}
	
	@GET
	@Path("add")
	public String add(@QueryParam("values")String values) {
		String[] vals=values.split(",");
		float sum=0.0f;
		try {
			for(int i=0;i<vals.length;i++)
				sum+=Float.parseFloat(vals[i]);
			return sum+"";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("Student")
	public String getStudent() {
		
		Student s1=new Student();
		Student s2=new Student();
		s1.id=101;
		s1.name="arathi";
		s1.course="java";
		s1.age=23;
		
		s2.id=102;
		s2.name="anitha";
		s2.course="python";
		s2.age=23;
		
		
		
		return s1 +"<br> "+s2;
		
		

	}
	
	/*@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("MethodOverloading")
	public String add() {
		MethodOverloading m1=new MethodOverloading();
		String f=m1.add(0,0);
		return ""+f;
		
	}*/
	
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("int/{f}")
	public String getint(@PathParam("f")float f) {
		
		int i=(int) f ;
		return i+"";
		
	}
	/*@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("ascii/{c}")
	public String getchar(@PathParam("c")String c) {
		
		int i=(int) c.charAt(0);
		return i+"";
		
	}*/
	
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("ascii/{c}")
	public String getchar(@PathParam("c")String c) {
		int i = (int) c.charAt(0);
		return i+"";
	}
	

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("lastchar/{s}")
	public String getlastchar(@PathParam("s")String s) {
		char array[]=s.toCharArray();
		int length=array.length;
		String a=s;
		  String words[]=a.split("\\s");
		  String[] as=words;
		
				  for(int i=0;i<words.length;i++) {
					  if(s.charAt(i).equels(''))
					  char p=s.charAt(i-1);
		  }
				  return p+"";
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("getSavings/{s},{i}")
	public String getSavings(@PathParam("s")String s,@PathParam("i")int i) {
		child c=new child();
		double d=Double.parseDouble(s);
	
		return c.getSavings(d)+"<br>"+c.getValue(i);
		
	}
	
}

