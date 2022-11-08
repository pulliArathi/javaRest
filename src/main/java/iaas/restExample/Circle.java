package iaas.restExample;

public class Circle extends Shape {

	@Override
	public float area(float x) {
		float c=pi*(x*x);
		return c;
	}

}
