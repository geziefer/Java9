package chapter8;

/**
 * Due to more complex setup for demonstrating the new multi-release feature,
 * there is manual work to do in order demonstrate it: This class holds two
 * functional identical parts where the first part uses a pre-Java 9 way to
 * construct a list and the second part uses the new feature for doing it. Now
 * it is necessary to compile each part separately with compiler level 8 and 9
 * and put both class files in the structure shown below and create a
 * multi-release jar. Then is't possible to execute the JAR file with both 8 and
 * 9 JVMs.
 * 
 * @author ARU
 */
// Structure for creating jar:
// v1 (for compiled with JDK 8)
// ..chapter8
// ....CarGenerator.class
// ....MultiDemo.class
// v2 (for compiled with JDK 8)
//..chapter8
//....CarGenerator.class
//....MultiDemo.class
//
// Command to create jar from folder where above structure was created:
// jar -cfe MultiDemo.jar chapter8.MultiDemo -C v1 chapter8/MultiDemo.class -C v1 chapter8/CarGenerator.class --release 9 -C v2 chapter8/CarGenerator.class
//
// Created jar structure:
// chapter8
// ..CarGenerator.class
// ..MultiDemo.class
// META-INF
// ..MANIFEST.MF
// ..versions
// ....9
// ......chapter8
// ........CarGenerator.class
public class MultiDemo {

	public static void main(String[] args) {
		System.out.println(new CarGenerator().generateCars());

	}
}
