package process;

import java.time.Duration;

public class ProcessDemo {

	public static void main(String[] args) throws Exception {
		System.out.println("All processes: ");
		ProcessHandle.allProcesses().filter(pa -> pa.info().command().isPresent()).forEach(pa -> System.out
				.println(pa.pid() + ": " + pa.info().command() + " - " + pa.info().user().orElse("N/A")));

		ProcessBuilder pb = new ProcessBuilder("jshell");
		Process p = pb.inheritIO().start();
		System.out.println("\nProcess " + p.pid() + " started");
		ProcessHandle.Info info = p.info();
		StringBuilder sb = new StringBuilder();
		sb.append("PID: " + p.pid()).append("\n").append("Command: ").append(info.command().orElse("N/A")).append("\n")
				.append("Start: ").append(info.startInstant().isPresent() ? info.startInstant() : "N/A").append("\n")
				.append(info.user().orElse("N/A")).append("\n").append("Output: ").append("\n");
		System.out.println(sb.toString());

		p.onExit().thenAccept(ps -> System.out.println("Process " + ps.pid() + " killed"));
		Thread.sleep(2000);
		System.out.println("\nDuration: " + info.totalCpuDuration().orElse(Duration.ofMillis(0)));
		p.destroy();
		Thread.sleep(2000);

	}

}