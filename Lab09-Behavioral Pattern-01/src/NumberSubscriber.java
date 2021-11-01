
public class NumberSubscriber extends StringSubscriber {

    public NumberSubscriber() {
        super("number");
    }

    @Override
    public String match() {
        return ".*[0-9].*";
    }
}
