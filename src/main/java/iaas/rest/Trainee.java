package iaas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import iaas.restExample.Constructor;
import iaas.restExample.InstanceOf;
import iaas.restExample.child;
import iaas.restExample.varArgs;


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
					  if((s.charAt(i)+"").equals(" "))
					   
		  }
				  return s+"";
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("getSavings/{s},{i}")
	public String getSavings(@PathParam("s")String s,@PathParam("i")int i) {
		child c=new child();
		double d=Double.parseDouble(s);
	
		return c.getSavings(d)+"<br>"+c.getValue(i);
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("varArgs/{values}/{f}")
	public String getadd(@PathParam("values")String values,@PathParam("f") String f) {
	String[] vals=values.split(",");
	String[] v=f.split(",");
	varArgs va=new varArgs();
	
	return va.addInt(vals)+""+"<br>"+va.addFloat(v)+"";
	
}
	@GET
	@Path("Find_type")
	@Produces(MediaType.TEXT_HTML)
	public String type() {
		InstanceOf<Integer> inst=new InstanceOf<Integer>();
		InstanceOf<Float> ins1=new InstanceOf<Float>();
		InstanceOf<String> inst2=new InstanceOf<String>();
		inst.x=0;
		ins1.x=3.5f;
		inst2.x="Arathi";
		return "first x value:  "+inst.getType()+"<br>"+"Second x value:  "+ins1.getType()+"<br>"+"Third x value:  "+inst2.getType();
	}
	
	@GET
	@Path("create_array")
	@Produces(MediaType.TEXT_HTML)
	public String getArrayValues() {
		InstanceOf<Float> inst=new InstanceOf<Float>();
		inst.createArray(56.8f,69.9f,58.4f,36.3f);
		String s="";
		for(Float i:inst.readArray())
			s+=i+",";
		InstanceOf<Integer> inst1=new InstanceOf<Integer>();
		inst1.createArray(23,5,8,9,6,748,4);
		String s1="";
		for(Integer i:inst1.readArray())
			s1+=i+",";
		InstanceOf<String> inst2=new InstanceOf<String>();
		inst2.createArray("Arathi","Hanu","Devendra Reddy","Varalakshmi");
		String s2="";
		for(String i:inst2.readArray())
			s2+=i+",";
		return "Float  values:"+s+"<br>"+"Integer values:"+s1+"<br>"+"String values:"+s2;
		
	}
}

