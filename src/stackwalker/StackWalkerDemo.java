package stackwalker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StackWalkerDemo {

	public static void main(String[] args) {
		recursive(10);
	}

	public static void recursive(int a) {
		if (a > 0) {
			recursive(--a);
		} else {
			finish();
		}
	}

	public static void finish() {
		StackTraceElement[] stackTrace = new Throwable().getStackTrace();
		Arrays.stream(stackTrace).forEach(f -> System.out.println(f.getMethodName() + ":" + f.getLineNumber()));
		System.out.println();

		StackWalker sw = StackWalker.getInstance();
		List<StackWalker.StackFrame> frames = sw.walk(f -> f.collect(Collectors.toList()));
		frames.forEach(f -> System.out.println(f.getMethodName() + ":" + f.getLineNumber()));
	}
}
