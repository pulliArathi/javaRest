package iaas.rest;

import javax.ws.rs.PathParam;
public class MethodOverloading {
	//float c;

	/*public String getOverloading(@PathParam("t1")int t1, @PathParam("t2")int t2) {
		c = t1+t1;
		return "sum of two numbers:"+c;
	}
	
	public String getOverloading(@PathParam("f1")float t1, @PathParam("f2")float t2) {
		 c = t1+t1;
		return "sum of two numbers:"+c;
	}
	public String getOverloading(@PathParam("f1")float f1, @PathParam("t1")int t1) {
		 c = f1+t1;
		return "sum of two numbers:"+c;
	}*/
	
	public String add(int t1, int t2) {
		int c =t1+t1;
		int d=t1*t2;
		return "sum of two numbers:"+c+"<br>"+d;
	}
	
	public String add(float t1,float t2) {
		float c = t1+t1;
		return "sum of two numbers:"+c;
	}
	public String add(float f1, int t1) {
		float c = f1+t1;
		return "sum of two numbers:"+c;
	}
}

