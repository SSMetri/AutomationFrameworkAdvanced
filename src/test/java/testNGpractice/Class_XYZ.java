package testNGpractice;

class D
{
	protected void foo() {
	}
}

class Y extends D
{
//	void foo() {}
}


public class Class_XYZ 
{
	public static void main(String[] args) {
		Y y=new Y();
		y.foo();
	}

}
