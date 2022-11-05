package iaas.restExample;

public class Constructor {
int id;
String name;
String add;
public String pin;
public Constructor() {
	id=101;
	name="arathi";
	add="Banglotre";

}
public Constructor(String n,int i,String a) {
 this.id=i;
 this.name=n;
 this.add=a;
}
public Constructor(int i,String n) {
	this.name=n;
}

public Constructor(String p) {
	this.pin=p;
}
public Constructor(int id, String name, String add) {
	this.id=id;
	this.name=name;
	this.add=add;
	//this.pin=p;
	
}
public String pin() {
	int a=20;
	int b=30;
	String s=""+(a+b);
	return s;
	
}
public String toString() {
	return id+"<br>"+add+"<br>"+name+"<br>";
	
}
}
