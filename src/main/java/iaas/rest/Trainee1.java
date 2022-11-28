package iaas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import iaas.restExample.AccessModifiers;
import iaas.restExample.Constructor;


@Path("/trainee1")
public class Trainee1 {
	public String Total;
	@Produces(MediaType.TEXT_HTML)
	@GET
	
	@Path("Employee")
	
	public String getEmployee() {
		Employee e1=new Employee();
		
		e1.id=101 ;
		e1.name="arathi ";
		//e1.Designation="java developer ";
		//e1.location="Bang ";
		e1.sal=4500;
		double as=((Employee1) e1).Salary();
		return e1.toString()+"<br>"+as;


}

	/*@Produces(MediaType.TEXT_HTML)
	@GET
	
	@Path("Employee/{sal}")
	public String getSal(@PathParam("sal")String sal)
{
		Employee e1=new Employee();
		e1.id=101;
		e1.name="arathi ";
		e1.Designation="java developer ";
		e1.location="Bang ";
		e1.sal=Double.parseDouble(sal);
	return e1.toString()+e1.Salary();
			


}*/
	@Produces(MediaType.TEXT_HTML)
	@GET
	
	@Path("array")
	public String getArray() {
		//String a[]=new String[6];
		/*a[0]="naser";
		a[1]="irfan";
		a[2]="akash";
		a[3]="amani";
		a[4]="arathi";
		a[5]="vinayak";*/
		String a[]= {"bng","tpt","atp","hvg","hyb"};
		String s="";
		for(int i=0;i<a.length;i++) 
			s+=a[i]+"<br>";
			return s;
			
			
		}
	
	@Produces(MediaType.TEXT_HTML)
	@GET
	
	@Path("Student")
	
	
	
	public String getStudents() {
		
		/*Student s1=new Student();
		
		s1.ids="ids";
		s1.name="name";
		s1.course="course";
		s1.ages="ages";
		s1.college="college";*/
		
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
	
	/*@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("Employee1")
	public String getEmployee1() {
	Employee1 arr[]=new Employee1[6];
	int ids[]= {101,102,103,104,105,106};
	String names[]= {"arathi","irfan","akash","arathi","vinayak","aamani"};
	double salary[]= {12000,30000,60000,6700,45000,67980};
	String s="<table border=5><tr><th>Id</th><th>Name</th><th>Salary</th></tr>";

    
    for(int i=0;i<arr.length;i++) {
    	
    	arr[i]=new Employee1();
    	arr[i].id=ids[i];
    	arr[i].name=names[i];
    	arr[i].sal=salary[i];
    	s+="<tr><td>"+arr[i].id+"</td><td>"+arr[i].name+"</td><td>"+arr[i].sal+"</td></tr>";
	}
    s+="</table>";
    return s;
	}*/
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("MethodOverloading/{t1},{t2}")
	public String getadd_int(@PathParam("t1")int t1, @PathParam("t2")int t2) {
		MethodOverloading m=new MethodOverloading();
		
		return m.add(t2, t2);
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("add_float/{t1},{t2}")
	public String getadd_float(@PathParam("t1")float t1, @PathParam("t2")float t2) {
		MethodOverloading m=new MethodOverloading();
		
		return m.add(t2, t2);
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("add_int_float/{t1},{t2}")
	public String getadd_int_float(@PathParam("t1")float t1, @PathParam("t2")int t2) {
		MethodOverloading m=new MethodOverloading();
		
		return m.add(t2, t2);
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("AccessModifiers")
	public String getAcess() {
		AccessModifiers am=new AccessModifiers();
		double s=am.access();
		return s+"";
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("Constructor/{id},{name},{add},{p}")
	public String getconstructor(@PathParam("id")int id,@PathParam("name")String name,@PathParam("add")String add,@PathParam("p")String p) {
		
		Constructor c=new Constructor(id,name,add);
		
		String pin="Arathi";
		String s1="";
		if(p.equals(pin))	   
			s1+=c.pin();  
		return s1+"<br>"+c.toString();
		
	}
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("wordCount/{str}")
	public String getword(@PathParam("str")String str) {
    String a=str;
  String words[]=a.split("\\s");
  int length=words.length;
	return length+"";
}
	
	@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("Employee1/{sal}")
	public String getinheritance(@PathParam("sal")double sal) {
		Employee1 e=new Employee1();
		e.sal=sal;
		 double d=e.Salary();
		return d+"";
		
	}
	
}
	
	

