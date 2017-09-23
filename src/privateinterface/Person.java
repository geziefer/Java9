package privateinterface;

/**
 * Interface having Java 8 default methods and a Java 9 private methods used by
 * default methods
 * 
 * @author ARU
 */
public interface Person {
	default public void greet() {
		executeGreeting("Hi", null);
	}

	default public void greet(String name) {
		executeGreeting("Hi", name);
	}

	default public void greetFormal() {
		executeGreeting("Good afternoon", null);
	}

	default public void greetFormal(String name) {
		executeGreeting("Good afternoon", name);
	}

	private void executeGreeting(String salutation, String name) {
		StringBuilder sb = new StringBuilder();
		sb.append(salutation).append("! ").append("Nice to meet you").append(name != null ? ", " + name : "")
				.append("!");
		System.out.println(sb.toString());
	}
}
