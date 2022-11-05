package iaas.rest;

public class Employee {
int id;
String name;
String Designation;
String location;
public double sal;
public static String Company_Name="IAAS";

Employee(){
	id=0;
	name="arathi";
	sal=0;
}

Employee(int x, String y,double z){
	id=x;
	name=y;
	sal=z;
	
}
public String toString() {
	
	return "id="+id+"<br>"+"name="+name+"<br>"+"Designation="+Designation+"<br>"+"location="+location+"<br>"+"company name="+Company_Name+"<br>"+"Monthly salary="+sal+ "<br>"+"Annual salary:";
}
}
