package privateinterface;

public class Salesperson implements Person {

	@Override
	public void greet() {
		System.out.println("Helooo, it's so nice to meet you! How are you?");
	}

	@Override
	public void greet(String name) {
		if (name == null) {
			greet();
		} else {
			System.out.println("Helooo " + name + " it's so nice to meet you again! How are you?");
		}
	}

	@Override
	public void greet(String name, String city) {
		if (name == null || city == null) {
			greet();
		} else {
			System.out.println("Helooo " + name + " it's so nice to meet you again! How's weather in " + city + "?");
		}
	}

}
