import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Publisher;

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
        for (StringSubscription subscription: subscriptions) {
            subscription.publish(s);
        }
    }
}
