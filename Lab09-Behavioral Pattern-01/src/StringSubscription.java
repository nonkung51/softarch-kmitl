import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {
    private final ExecutorService executor;

    private Flow.Subscriber subscriber;

    public StringSubscription(Flow.Subscriber subscriber, ExecutorService executor) {
        this.subscriber = subscriber;
        this.executor = executor;
    }

    @Override
    public void request(long n) {
        if (n < 0)
            executor.execute(() -> subscriber.onError(new IllegalArgumentException()));
    }

    @Override
    public void cancel() {}

    public void publish(String str) {
        executor.execute(() -> {
            subscriber.onNext(str);
        });
    }
}
