package iaas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("ArrayExample")
public class ArrayExample{
	

@Produces(MediaType.TEXT_HTML)
	@GET
	@Path("arrayeg1")
	public String getArrayeg() {
	arrayeg1 a=new arrayeg1();
	String s=a.readvalue();
		return s;
	
}
}