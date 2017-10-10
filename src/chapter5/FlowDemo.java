package chapter5;

import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

/**
 * Shows the publish-subscribe framework for reactive streams
 * 
 * @author ARU
 */
public class FlowDemo {

	public static void main(String[] args) throws Exception {
		// create a publisher and subscriber
		SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
		MySubscriber<String> subscriber = new MySubscriber<>();
		publisher.subscribe(subscriber);

		// publish data and close publisher
		System.out.println("Publishing data items");
		List<String> items = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
		items.stream().forEach(i -> publisher.submit(i));

		// wait for demo purposes
		Thread.sleep(1000);

		// continue publishing
		System.out.println("Publishing data items");
		items.stream().forEach(i -> publisher.submit(i));

		// wait for demo purposes
		Thread.sleep(2000);

		// end publishing
		publisher.close();
		System.out.println("Publishing data finished.");
	}
}

/**
 * Subscriber subclass for processing data
 */
class MySubscriber<T> implements Subscriber<T> {
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		// initialize subscription
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(T item) {
		// receive data item and simulate processing
		System.out.println("Processing " + item);
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
		}
		subscription.request(1);
	}

	@Override
	public void onError(Throwable t) {
		// error handling can go here
		t.printStackTrace();
	}

	@Override
	public void onComplete() {
		// triggered when stream is closed
		System.out.println("Done");
	}
}
