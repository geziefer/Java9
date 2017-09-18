package privateinterface;

public class Salesperson implements Person { 

	@Override
	public void greet() {
		System.out.println("Helooo, it's so nice to meet you! How are you?");
	}
}
