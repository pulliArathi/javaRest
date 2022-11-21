package iaas.rest;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import iaas.restExample.Circle;
import iaas.restExample.InstanceOf;
import iaas.restExample.LessAgeException;
import iaas.restExample.Number1;
import iaas.restExample.Seasons;
import iaas.restExample.Signal;
import iaas.restExample.Square;
import iaas.restExample.Vote;
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
		InstanceOf<Object> inst=new InstanceOf<Object>();
		/*InstanceOf<Integer> inst=new InstanceOf<Integer>();
		InstanceOf<Float> ins1=new InstanceOf<Float>();
		InstanceOf<String> inst2=new InstanceOf<String>();
		inst.x=0;
		ins1.x=3.5f;
		inst2.x="Arathi";*/
		return "value  of x"+inst.getType();
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
	@GET
	@Path("AbstractClass_Shape/{v}")
	@Produces(MediaType.TEXT_HTML)
	public String getShape(@PathParam("v")float v) {
		Circle c1=new Circle() ;
			String c2=c1.area(v)+"";
			Square s1=new Square();
			String s2=s1.area(v)+"";
			
			return "Circle:  "+c2+" "+c1.drawnBy("   arathi")+"<br>"+"Square: "+s2+" "+s1.drawnBy("   ArathiDevendra reddy");
		
	}
	
	
	@GET
	@Path("Interface_Number1/{v}")
	@Produces(MediaType.TEXT_HTML)
	public String getNumber(@PathParam("v")int v) {
		
		Number1 n=(v1)->{
			return  "Addition of given number:   "+(v+v)+"<br>"+"Multiplication of given number:   "+(v*v)+"<br>"+"Division of given number:  "+(v/v)+"<br>"+"Substraction of given number:  "+(v-v);
				
		};
		Number1 n1=(v2)->{
			int p=(v/2);
			String s="";
			if(p==1)
				s+="Given number is prime number";
			else
				s+="Given number is not a prime number";
			return s;	
		};
		Number1 n2=(v3)->{
			int sum=0;
			String f="";
			int p=v;
			int i=1;
			while(i<=v/2) {
				if(v%2==0)
					sum=sum+i;
				i++;
			}
				if(sum==p)
					f+="Given number is perfect";
				else
					f+="Given number is not a perfect number";
				return f;	
			
		};
		Number1 n3=(v3)->{
			int count=0;
			int c=v;
			while(c!=0) {
				c=c/10;
				count++;
			}
				return "Number of digits in a given number: "+count;
		};
		
		return n.operation(v)+"<br>"+n1.operation(v)+"<br>"+n2.operation(v)+"<br>"+n3.operation(v);
	}
	@GET
	@Path("signal/{color}")
	@Produces(MediaType.TEXT_HTML)
	public String getSignal(@PathParam("color")String color) {
		int code=0;
		String text="";
		String result="";
		Signal signal=Signal.valueOf(color.toUpperCase());
		try {
			for(int i=0;i<4;i++) {
				code+=(int)color.toUpperCase().charAt(i);
			}
			switch(signal) {
			case RED:
				text="<font color='red' size=10px>";
				break;
			case YELLOW:
				text="<font color='yellow' size=10px>";
				break;
			case GREEN:
				text="<font color='green' size=10px>";
				break;
			default:
				text="<font color='green' size=10px>";
			}
			result=text+signal.toString()+":"+signal.action+":"+signal.time+":"+code+"</font>";
			return result;
		}
		catch(IllegalArgumentException ex) {
			result="<font color='"+color+"' size=10px>The given signal color is not valid</font>";
			return result;
		}
		catch(StringIndexOutOfBoundsException ex) {
			text="<font color='"+color+"' size=10px>";
			result=text+signal.toString()+":"+signal.action+":"+signal.time+":"+code+"</font>";
			return result;
		}
		catch(Exception ex) {
			return "";
		}
		
	}
	
	@GET
	@Path("all_signals")
	@Produces(MediaType.TEXT_HTML)
	public String getAllSignals() {
		String allSig="";
		for(Signal sig:Signal.values())
			allSig+=sig.toString()+"<br>";
		return allSig;
	}
	
	@GET
	@Path("vote/{age}")
	@Produces(MediaType.TEXT_HTML)
	public String vote(@PathParam("age")int age) {
		String votingPage="";
		try {
			Vote vote=new Vote();
			if(vote.canVote(age))
				votingPage="<form><input type='radio' name='party'>BJP<br><input type='radio' name='party'>TRS<br><input type='radio' name='party'>Congress<br><input type='radio' name='party'>MIM";
			else
				throw new LessAgeException("U r not eligible");
			return votingPage;
		}
		catch(LessAgeException e) {
			votingPage=e.getMessage();
			return votingPage;
		}
		
	}
	@GET
	@Path("seasons/{sname}")
	@Produces(MediaType.TEXT_HTML)
	public String getSeasons(@PathParam("sname")String sname) {
		int code=0;
		String text="";
		String result="";
		Seasons s=Seasons.valueOf(sname.toUpperCase());
		try {
			for(int i=0;i<4;i++) {
				code+=(int)sname.toUpperCase().charAt(i);
			}
			switch(s) {
			case SUMMER:
				text="<font color='orange' size=10px>";
				break;
			case WINTER:
				text="<font color='yellow' size=10px>";
				break;
			case SPRING:
				text="<font color='green' size=10px>";
				break;
			default:
				text="<font color='green' size=10px>";
			}
			result=text+s.toString()+":"+s.seasons+":"+s.temp+":"+code+"</font>";
			return result;
		}
		catch(IllegalArgumentException ex) {
			result="<font color='"+sname+"' size=10px>The given signal color is not valid</font>";
			return result;
		}
		catch(StringIndexOutOfBoundsException ex) {
			text="<font color='"+sname+"' size=10px>";
			result=text+s.toString()+":"+s.seasons+":"+s.temp+":"+code+"</font>";
			return result;
		}
		catch(Exception ex) {
			return "";
		}
		
	}
	
	
	@SuppressWarnings("resource")
	@GET
	@Path("read_file/{fname}")
	@Produces(MediaType.TEXT_HTML)
	public String readFile(@PathParam("fname")String fname) {
		try {
			FileInputStream in=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\javaRest\\FileOperation\\"+fname);
			int c=in.read();
			String s="";
			while(c!=-1) {
				if(c==13)
					s+="<br>";
				else
					s+=(char)c;
				c=in.read();
			}
			return s;
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	@GET
	@Path("write_file/{fname}/{data}")
	@Produces(MediaType.TEXT_HTML)
	public String writeFile(@PathParam("fname")String fname,@PathParam("data")String data) {
		try {
			FileOutputStream out=new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\javaRest\\FileOperation\\"+fname,true);
			byte b[]=data.getBytes();
			out.write(b);
			out.write(System.lineSeparator().getBytes());
			return "data saved in file";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	@GET
	@Path("write_file/{fname}/{a},{b}")
	@Produces(MediaType.TEXT_HTML)
	public String witeFile_add(@PathParam("fname")String fname,@PathParam("a")int a, @PathParam("b")int b) {
		try {
		
			FileOutputStream out=new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\javaRest\\FileOperation\\"+fname);
			out.write(("First Number "+a).getBytes());
			out.write(System.lineSeparator().getBytes());
			out.write(("Second number "+b).getBytes());
			out.write(System.lineSeparator().getBytes());
			int c=a+b;
			out.write(("adding above two numbers "+c).getBytes());
			out.write(System.lineSeparator().getBytes());
			
			return "data saved in file"+"<br>"+"adding two numbers: "+c;
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
}

