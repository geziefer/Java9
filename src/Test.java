import java.time.LocalDateTime;

public class Test {

	public static void main(String[] args) {
		LocalDateTime l = LocalDateTime.now().plusDays(1).withHour(12).withMinute(0);
		System.out.println("Next lunch: " + l);
	}
}
