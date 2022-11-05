package iaas.restExample;

public class child extends Parent {
	int b=77;
	
	public String getSavings(double sal) {
		String ps=super.getSavings(sal);
		return ps+"<br> "+"Child savings:"+sal*80/100;
		
	}
	public String getValue(int a) {
		String pa=super.getValue(b);
		return pa+"<br>"+"child value:"+b;
	}

}
