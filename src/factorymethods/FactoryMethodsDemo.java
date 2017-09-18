package factorymethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FactoryMethodsDemo {

	public static void main(String[] args) {
		// pre Java 9 array
		String[] carsArray = { "VW", "Audi", "Porsche" };
		List<String> carsList = Arrays.asList(carsArray);
		carsList = Collections.unmodifiableList(carsList);
		System.out.println(carsList);

		// pre Java 9 list
		List<String> carsList2 = new ArrayList<>();
		carsList2.add("VW");
		carsList2.add("Audi");
		carsList2.add("Porsche");
		carsList2 = Collections.unmodifiableList(carsList2);
		System.out.println(carsList2);

		// Java 9 list
		List<String> carsList3 = List.of("VW", "Audi", "Porsche");
		System.out.println(carsList3);
	}

}
