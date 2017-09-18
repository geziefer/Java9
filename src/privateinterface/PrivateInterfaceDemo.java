package privateinterface;

public class PrivateInterfaceDemo {
	public static void main(String[] args) {
		Person p1 = new Developer();
		Person p2 = new Salesperson();
		p1.greet();
		p1.greet("Alex");
		p1.greet("Alex", "Eschborn");
		p1.greet(null, "Eschborn");
		p1.greet("Alex", null);
		p1.greet(null, null);
		System.out.println();
		p2.greet();
		p2.greet("Alex");
		p2.greet("Alex", "Eschborn");
		p2.greet(null, "Eschborn");
		p2.greet("Alex", null);
		p2.greet(null, null);
	}
}
