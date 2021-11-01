import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

abstract public class StringSubscriber implements Subscriber<String> {
    private Flow.Subscription subscription;
    private FileWriter writer;
    private String filename;

    public StringSubscriber(String name) {
        try {
            filename = name + ".txt";
            File myObj = new File(filename);

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    abstract public String match();

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void onNext(String item) {
        if (item != null) {
            try {
                writer = new FileWriter(filename, true);
                writer.write(item);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            subscription.request(1);
        } else {
            System.out.println("Null Item!");
        }
    }

    @Override
    public void onComplete() {
        System.out.println("Complete!");
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("Subscriber Error >> " + t.toString());
    }
}
