package privateinterface;

public class PrivateInterfaceDemo {
	public static void main(String[] args) {
		Person p1 = new Developer();
		Person p2 = new Salesperson();
		p1.greet();
		p2.greet(); 
		p1.greet("Alex");
		p1.greetFormal();
		p1.greetFormal("Alex");
	}
}
