package chapter7;

/**
 * Uses 2 interfaces which use the new feature for private interface methods
 * 
 * @author ARU
 */
public class InterfaceDemo {
	public static void main(String[] args) {
		// Instantiate 2 different implementations of the interface using defaults and
		// private methods
		Person p1 = new Developer();
		Person p2 = new Salesperson();
		p1.greet();
		p2.greet();
		p1.greet("Alex");
		p1.greetFormal();
		p1.greetFormal("Alex");
	}
}
