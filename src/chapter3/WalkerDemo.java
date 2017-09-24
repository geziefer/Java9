package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Shows walking through stack frames filter them and show details
 * 
 * @author ARU
 */
public class WalkerDemo {

	public static void main(String[] args) {
		recursive(10);
	}

	// allow for a few recursive method calls to fill some stack frames
	public static void recursive(int a) {
		if (a > 0) {
			recursive(--a);
		} else {
			finish();
		}
	}

	// run after certain amount of sub calls
	public static void finish() {
		// pre Java 9 way to examine stack trace
		StackTraceElement[] stackTrace = new Throwable().getStackTrace();
		Arrays.stream(stackTrace).forEach(f -> System.out.println(f.getMethodName() + ":" + f.getLineNumber()));
		System.out.println();

		// Java 9 way to walk thhrough stack frames
		StackWalker sw = StackWalker.getInstance();
		List<StackWalker.StackFrame> frames = sw.walk(f -> f.collect(Collectors.toList()));
		frames.forEach(f -> System.out.println(f.getMethodName() + ":" + f.getLineNumber()));
	}
}
