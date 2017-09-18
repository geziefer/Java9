package privateinterface;

public interface Person {
	default public void greet() {
		doGreet(null, null);
	}

	default public void greet(String name) {
		doGreet(name, null);
	}

	default public void greet(String name, String city) {
		doGreet(name, city);
	}

	private void doGreet(String name, String city) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hi");
		sb.append(name != null ? " " + name : "");
		sb.append(city != null && name == null ? " to " + city : "");
		sb.append(city != null && name != null ? " from " + city : "");
		sb.append(".");
		System.out.println(sb.toString());
	}
}
