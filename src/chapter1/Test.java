package chapter1;

import java.time.LocalDateTime;

/**
 * The typical test class before having jshell
 * 
 * @author ARU
 */
public class Test {

	public static void main(String[] args) {
		// next line is which was intended to be tested
		LocalDateTime l = LocalDateTime.now().plusDays(1).withHour(12).withMinute(0);
		System.out.println("Next lunch: " + l);
	}
}
