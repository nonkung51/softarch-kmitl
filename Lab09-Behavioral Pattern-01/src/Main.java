import java.util.Scanner;
import java.util.concurrent.Flow;

public class Main {
    public static void main(String args[])
    {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        String s = "";

        // Setting up Publisher & Subscriber
        StringPublisher publisher = new StringPublisher();
        Flow.Subscriber sub1 = new NumberSubscriber();
        Flow.Subscriber sub2 = new SymbolSubscriber();
        Flow.Subscriber sub3 = new AlphabetSubscriber();

        publisher.subscribe(sub1);
        publisher.subscribe(sub2);
        publisher.subscribe(sub3);

        while (true) {

            System.out.print("Enter some text: ");
            s = in.nextLine();
            if (s.equals(":q!")) {
                break;
            }
            publisher.publish(s);
            System.out.println("You entered string " + s);
        }

        // closing scanner
        in.close();

        if (s.equals(":q!")) {
            System.exit(0);
        }
    }
}
