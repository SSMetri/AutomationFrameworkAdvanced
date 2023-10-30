package practice;

public class MainMethodOverloadingExample {
	public static void main(String[] args) {
		System.out.println("MAIN method");
		main(10);
		main("String");
	}
	public static void main(int a) {
		System.out.println("Main int");
	}
	public static void main(String x) {
		System.out.println("Main str");
	}
}

