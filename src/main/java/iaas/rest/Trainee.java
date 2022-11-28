package iaas.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeSet;

import javax.print.attribute.Size2DSyntax;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import iaas.restExample.Circle;
import iaas.restExample.InstanceOf;
import iaas.restExample.Item;
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
	@Path("{add_1}/{add_2}") //adding two values
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
	@Path("add")//add all values given url 
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
	@Path("Student") 	//print student data by creating objects of student class
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
	@Path("int/{f}")	//converting float to int
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
	@Path("ascii/{c}")	//getting ASCII values of given character
	public String getchar(@PathParam("c")String c) {
		int i = (int) c.charAt(0);
		return i+"";
	}
	

	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("lastchar/{s}")	//getting last character of given one string
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
	@Path("word_lastcharecter/{s}")		//getting last character of every word and make it as a string
	public String getlastchar_word(@PathParam("s")String s) {
		char array[]=s.toCharArray();
		String str="";
		String a=s;
		  String words[]=a.split(" ");
		  for(String s1:words) 
			 str+=s1.charAt(s1.length()-1);
			 return str+"";
	}
	
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("getSavings/{s},{i}")	//getting savings of parents and child
	public String getSavings(@PathParam("s")String s,@PathParam("i")int i) {
		child c=new child();
		double d=Double.parseDouble(s);
	
		return c.getSavings(d)+"<br>"+c.getValue(i);
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("varArgs/{values}/{f}")	//adding values based on data type given url by using varArgs
	public String getadd(@PathParam("values")String values,@PathParam("f") String f) {
	String[] vals=values.split(",");
	String[] v=f.split(",");
	varArgs va=new varArgs();
	
	return va.addInt(vals)+""+"<br>"+va.addFloat(v)+"";
	
}
	@GET
	@Path("Find_type")	//finding type of a variable
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
	@Path("create_array")	//creating an array
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
	@Path("AbstractClass_Shape/{v}")	//getting shape by using abstract class
	@Produces(MediaType.TEXT_HTML)
	public String getShape(@PathParam("v")float v) {
		Circle c1=new Circle() ;
			String c2=c1.area(v)+"";
			Square s1=new Square();
			String s2=s1.area(v)+"";
			
			return "Circle:  "+c2+" "+c1.drawnBy("   arathi")+"<br>"+"Square: "+s2+" "+s1.drawnBy("   ArathiDevendra reddy");
		
	}
	
	
	@GET
	@Path("Interface_Number1/{v}")	//performing different operation on number by using interface
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
	@Path("signal/{color}")	//getting signals data by using annum
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
	@Path("all_signals")	//getting all signals data 
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
	@Path("seasons/{sname}")	//getting seasons data by using ennum
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
	@Path("read_file/{fname}")	//read a file by using fileInputStream
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
	@Path("write_file/{fname}/{data}")	//writing a file by using FileOutPutStream
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
	@Path("write_file/{fname}/{a},{b}")	//writing a file and add two number and save data in a file
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
	
	@GET
	@Path("FileCopy/{a},{b}")	//copy data  one file to another file
	@Produces(MediaType.TEXT_HTML)
	public String filecopy(@PathParam("a")int a,@PathParam("b")int b) {
String s="";
		try {
			FileWriter fw=new FileWriter("C:\\Users\\user\\eclipse-workspace\\javaRest\\FileOperation\\ReadFile.txt\\");
			  int c = a + b;
	            fw.write("First value: " + a + "\n" +"Second value: "+ b + "\n" + "Adding of two numbers: " + c);        
	            fw.close();
			FileInputStream in=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\javaRest\\FileOperation\\ReadFile.txt\\");
			FileOutputStream out=new FileOutputStream("C:\\Users\\user\\eclipse-workspace\\javaRest\\FileOPerationExample\\example\\");
			  int i = 0;
	            while ((i = in.read()) != -1) {         
	                
	                if (i == 13) {                     
	                    s+="<br>";
	                    out.write((char) i);
	                }
	                
	                else {
	                s+= (char) i;                    
	               out.write((char) i);
	                }
	            }
	            
	            return s;
	        }
	        
	        catch (Exception e) {
	            return "no file is present";
	        }
	}
	
	@GET
	@Path("list_commonValues")	//getting common values from a list
	@Produces(MediaType.TEXT_HTML)
		public String getlist() {
			List<Integer> list=new ArrayList<>();
			list .add(12);
			list.add(24);
			list.add(26);
			list.add(67);
			list.add(45);
			list.add(64);
			List<Integer> list2=new LinkedList<>();
			list2.add(45);
			list2.add(67);
			list2.add(26);
			list2.add(56);
			//list.addAll(2,list2);				//we can add all values from linkedList to arrayList
			String res="";
			Collections.sort(list);
			list.contains(26);					//checking the given number is present or not
			int x=list.get(2);					//getting value from the given index
			int in=list.indexOf(26);			// we find the value in given index
			String s="";
			if(list.equals(list2)==true)
				 s+="true";
			else
			s+="false";
			/*list.retainAll(list2);			//will have only list2 values in list
			list2.removeAll(list);
			list.remove(list2);*/
			List<Integer> list3=new ArrayList<>();
			for(Integer in1:list)
				if(list2.contains(in1))
					list3.add(in1);
			for(Integer i1:list)
				res+=i1+"<br>";
			String res1= res+"<br>"+"getting value from given index: "+x+"<br>"+"finding value from given index: "+in+"<br>"+"compare two list: "+s+"<br>"+"Common elements in two list: "+list3;
				
			return res1;
}
	
	
	@GET
	@Path("list_String")	//sort list based on string
	@Produces(MediaType.TEXT_HTML)
		public String getlist_String() {
		List<String> list=new ArrayList<>();
		list.add("Arathi");
		list.add("Abhggh");
		list.add("Anitha");
		list.add("Irfan");
		list.add("Naser");
		list.add("Akash");
		list.add("Vinayak");
		list.add("adth");
		list.add("arathi");
		 List<List<String>> l=Arrays.asList(list);
		 Collections.sort(list);
		 String s="";
		for(String s1:list)
			s+=s1+"<br>";
		return s+"<br>";
	}
	
	@GET
	@Path("String_sort/{s}")	//sort a string 
	@Produces(MediaType.TEXT_HTML)
		public String getString_sort(@PathParam("s")String s) {
		String st="";
		st+=s;
		char CharArray[]=st.toCharArray();
	
		Arrays.sort(CharArray);
	String str=new String(CharArray);
		return str;
	}
	
	@GET
	@Path("list_cvremove")	//remove common values in a list
	@Produces(MediaType.TEXT_HTML)
		public String getlistRemoveValues() {
			List<Object> list=new ArrayList<>();
			list.add(23);
			list.add("arathi");
			list.add(24);
			list.add(23);
			list.add(45.7);
			list.add(45);
			list.add("anith");
			List<Object> list2=new LinkedList<>();
			list2.add(45);
			list2.add(45.7);
			list2.add(26);
			list2.add(56);
			list2.add(23);
			list2.add("arathi");
			list2.add(2);
			list2.add(23);
			list2.add(456);
			list2.add(45);
			list2.add(2);
			list2.add(67);
			list.add("hanu");
			list2.add("arathi");
			list2.add(23);
			List<Object> list3=new ArrayList<>();
			List<Object> list4=new ArrayList<>();
			List<Object> list5=new ArrayList<>();
			for(Object in1:list2)
				if(list.contains(in1))
					list3.remove(in1);
				else
					list3.add(in1);
			for(Object in1:list)
				if(list2.contains(in1))
					list4.remove(in1);
				else
					list4.add(in1);

			for(Object o:list2)
				if(!list5.contains(o))
					list5.add(o);
			
			String res1="After removing all common values from two lists in list2: "+list3+"<br>"+"After removing all common values from two lists in list"+list4
					+"<br>"+"Remove all common values from one list: "+list5;
				
			return res1;
	}	
			
	@GET
	@Path("String_shuffiling/{s}") 	//Shuffle the given string
	@Produces(MediaType.TEXT_HTML)
		public String getString_shuffiling(@PathParam("s")String s) {
		String st="";
		st+=s;
		List<String> s1=Arrays.asList(st.split(""));
		Collections.shuffle(s1);
		// Object str = StringJoiner.on("").join(s1);  
		return "After shuffing of a string: "+s;
	}
	
	@GET
    @Path("item")	//adding item objects to list
    @Produces(MediaType.APPLICATION_XML)
    public List<Item> getItems(){
        Item i1=new Item(10, "biryani", 250);
        Item i2=new Item(11, "roti", 25);
        Item i3=new Item(12,"curry",150);
        List<Item> items=new ArrayList<>();
        items.add(i1);
        items.add(i2);
        items.add(i3);
        Collections.sort(items);
        return items;
    }
	
	@GET
    @Path("semp")	//sort employee based on bonus
    @Produces(MediaType.APPLICATION_XML)
    public List<Employee> getEmployee(){
        Employee e1=new Employee(101, "Arathi", 25000);
        Employee e2=new Employee(102, "Anitha", 35000);
        Employee e3=new Employee(103, "Kavitha", 10000);
        List<Employee> employee=new ArrayList<>();
        employee.add(e1);
        employee.add(e2);
        employee.add(e3);
       Collections.sort(employee);
        return employee;
    }
	
	@GET
    @Path("cfile_list")//copy  each line in a file into list
    @Produces(MediaType.TEXT_HTML)
	public String getcfile_list() throws Exception{
		BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\user\\eclipse-workspace\\javaRest\\FileOperation\\ReadFile.txt\\"));
		List<String> listOfLines = new ArrayList<>(); 
		String line = bf.readLine();
		while (line != null) 
		{
			listOfLines.add(line); 
		line = bf.readLine(); 
		} 
		bf.close();
		return listOfLines.toString();
		
	}
	@GET
    @Path("map")
    @Produces(MediaType.TEXT_HTML)
    public String getMap() {
        Map<Integer,String> map=new HashMap<>();
        String names[]= {"arathi","aamani","naser","irfan","vinayak","akash"};
        for(int i=101;i<=100+names.length;i++)
            map.put(i, names[i-101]);
        String s="";
        for(Map.Entry<Integer, String> entry:map.entrySet())
            if(entry.getKey()==103)
                s+=entry.getKey()+","+entry.getValue()+"<br>";
        //s+=map.get(103);
        return s;
    }
    
    @GET
    @Path("marks_map")
    @Produces(MediaType.TEXT_HTML)
    public String getMarks() {
        Map<Integer,List<Integer>> map=new HashMap<>();
        List<Integer> list1=Arrays.asList(67,78,98);
        List<Integer> list2=Arrays.asList(77,89,88);
        List<Integer> list3=Arrays.asList(67,77,98);
        map.put(101, list1);
        map.put(102, list2);
        map.put(103, list3);
        String s="";
        for(Map.Entry<Integer, List<Integer>> entry:map.entrySet())
            s+=entry.getKey()+":"+entry.getValue()+"<br>";
        return s;
        
    }
	@GET
    @Path("connect_db")	//connecting database
    @Produces(MediaType.TEXT_HTML)
    public String connectToDatabase() {
        try {
            Connection c=Db.connect();
            return "connected";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return e.getMessage();
        }
    }
	
	
	@GET
	@Path("scan_file/{fileName}")	//copy all data in a file to list by using scanner
	@Produces(MediaType.TEXT_HTML)
	public String readFileScan(@PathParam("fileName")String fileName) {
		List<String> lines=new ArrayList<>();
		try {
			Scanner sc=new Scanner(new File("\\Users\\user\\eclipse-workspace\\javaRest\\FileOperation\\"+fileName));
			while(sc.hasNextLine())
				lines.add(sc.nextLine());
			return lines.toString();
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	@GET
	@Path("sort_set")	
	@Produces(MediaType.TEXT_HTML)
	public String getset_sort(){
		Set<Object> s=new TreeSet<>();
		s.add(2);
		s.add(5);
		s.add(87);
		s.add(67);
		s.add(54);
		TreeSet<Object> ss=(TreeSet<Object>) ((TreeSet<Object>) s).descendingSet();
		return ss.toString();
	}
}



