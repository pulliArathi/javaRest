package iaas.restExample;

public abstract class Shape {
	final float pi=3.14f;
	public abstract float area(float x);
	public String drawnBy(String name) {
		return "drawn by "+name;
	}

}
