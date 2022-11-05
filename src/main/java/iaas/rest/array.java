package iaas.rest;
import java.sql.Array;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/array")
public class array {
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("Employee1")
	public String getEmployee1() {
	Employee1 arr[]=new Employee1[6];
	int ids[]= {101,102,103,104,105,106};
	String names[]= {"arathi","irfan","akash","arathi","vinayak","aamani"};
	double salary[]= {12000,30000,60000,6700,45000,67980};
	String s="<table border=5><tr><th>Id</th><th>Name</th><th>Salary</th></tr>";

    
    for(int i=0;i<arr.length;i=i++) {
    	
    	arr[i]=new Employee1();
    	arr[i].id=ids[i];
    	arr[i].name=names[i];
    	arr[i].sal=salary[i];
    	s+="<tr><td>"+arr[i].id+"</td><td>"+arr[i].name+"</td><td>"+arr[i].sal+"</td></tr>";
	}
    s+="</table>";
    return s;
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	
	@Path("Student")
	
	
	
	public String getStudents() {
	
		Student arr[]=new Student[6];
		int ids[]= {101,102,103,104,105,106};
		String names[]= {"arathi","irfan","akash","arathi","vinayak","aamani"};
		String course[]= {"java","linux","python","salepoint","java","salesforse"};
	    int ages[]= {23,23,24,22,25,26,};
	    
        String s="<table border=5><tr><th>Id</th><th>Name</th><th>Course</th><th>Age</th><th>College</th></tr>";

     
	    for(int i=0;i<arr.length;i++) {

		arr[i]=new Student();
		arr[i].id=ids[i];
		arr[i].name=names[i];
		arr[i].course=course[i];
		arr[i].age=ages[i];
		
		String college="IAAS";
		s+="<tr><td>"+arr[i].id+"</td><td>"+arr[i].name+"</td><td>"+arr[i].course+"</td><td>"+arr[i].age+"</td><td>"+college+"</tr>";
	}
	   s+="</table>" ;
	return s;
	
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	
	@Path("Employee/{no}")
	public String getEmployee(@PathParam("no")String no) {
		Array ar[]=new Array[5];
		String s="";
		Employee1 e1=new Employee1();
		e1.no=Integer.parseInt(no);

        return e1.number();
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	
	@Path("Employee1/{size}")
	
	public String getEmployee1(@PathParam("size")int size) {
		int ar[]=new int[size];
		String s="";
		for (int j=0; j<size; j++) {
			ar[j]=10*(j+1);
			s+=ar[j];
		}
		return s;
	
	
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	
	@Path("String/{str}")
	public String getStringOp(@PathParam("str")String s) {
		int length=s.length();
		String caps=s.toLowerCase();
		char c=s.charAt(5);
		char c1=s.charAt(6);
		String in="c";
		String inds="";
		for(int i=0;i<in.length();i++) {
			inds+=s.indexOf(in.charAt(i))+"";
		}
		String last3=s.substring(length-3 , length);
		return length+"<br>"+caps+"<br>"+(c+"").toLowerCase()+"<br>"+(c1+"").toUpperCase()+"<br>"+last3.toUpperCase()+"<br>"+inds;
		
	}
}
