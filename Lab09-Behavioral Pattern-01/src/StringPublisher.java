import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;

/*
    // If we've got other than 0.
    // Loop check for each char then send.
    String template = ((StringSubscriber) subscriber).match();
    String c = buffer.substring(0, 1);
    buffer = buffer.substring(1);

    // Send only template that matches.
    if (c.matches(template)) {
        subscriber.onNext(c);
    } else {
        request(1);
    }
*/

public class StringPublisher implements Publisher<String> {
    final ExecutorService executor = Executors.newFixedThreadPool(8);
    private ArrayList<StringSubscription> subscriptions = new ArrayList();

    @Override
    public void subscribe(Subscriber subscriber) {
        StringSubscription subscription = new StringSubscription(subscriber, executor);

        subscriptions.add(subscription);

        subscriber.onSubscribe(subscription);
    }

    public void publish(String s) {
        System.out.println("Publish " + s + " to subscribers.");

        int strLen = s.length();
        for (int ch = 0; ch < strLen; ch++) {
            String c = s.substring(0, 1);
            s = s.substring(1);
            for (StringSubscription subscription: subscriptions) {
                String template = ((StringSubscriber) subscription.subscriber).match();
                if (c.matches(template)) {
                    // Publish Char by Char
                    subscription.publish(c);
                }
            }
        }
    }
}
