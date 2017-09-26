package chapter6;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import jdk.incubator.http.HttpResponse.BodyHandler;

/**
 * Shows new HTTP/2 client
 * <p>
 * Important: HTTP/2 is incubating feature in JDK9, so JVM needs parameter
 * "--add-modules jdk.incubator.httpclient" in order to have it on the classpath
 * 
 * @author ARU
 */
public class Http2Demo {

	public static void main(String[] args) throws Exception {
		// HTTP GET to webpage synchronously
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder(new URI("https://syrocon.de/")).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandler.asString());
		System.out.println("Status: " + response.statusCode());
		System.out.println("\nHeaders:");
		response.headers().map().values().stream().forEach(v -> System.out.println(v));
		System.out.println("\nBody:\n" + response.body());

		// HTTP GET to webpage asynchronously
		System.out.println();
		long start = System.currentTimeMillis();
		CompletableFuture<HttpResponse<String>> fr = client.sendAsync(request, BodyHandler.asString());
		while (!fr.isDone()) {
			System.out.println("Still processing since " + (System.currentTimeMillis() - start) + "ms");
			// simulate processing parallel to the async GET
			Thread.sleep(100);
		}
		System.out.println(
				"Done with status " + fr.get().statusCode() + " after " + (System.currentTimeMillis() - start) + "ms");
	}
}
