package iaas.restExample;

public class varArgs {
public int addInt(String...x) {
	
	        int sum=0
	                ;
	        for(String n:x)//for every int n in x
	            sum+=Integer.parseInt(n);
	        return sum;
	    }

public float addFloat(String...x) {
	
    float sum=0
            ;
    for(String n:x)//for every int n in x
        sum+=Float.parseFloat(n);
    return sum;
}

}

