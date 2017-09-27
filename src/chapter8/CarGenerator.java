package chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarGenerator {
	public List<String> generateCars() {
		List<String> cars = null;
		// uncomment this part when compiling with Java 8
//		 cars = new ArrayList<>();
//		 cars.add("8er VW");
//		 cars.add("8er Audi");
//		 cars.add("8er Porsche");
//		 cars = Collections.unmodifiableList(cars);

		// uncomment this part when compiling with Java 9
//		 System.out.println("Java 9:");
//		 cars = List.of("9er VW", "9er Audi", "9er Porsche");
		return cars;
	}
}
