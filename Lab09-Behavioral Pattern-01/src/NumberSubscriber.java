
public class NumberSubscriber extends StringSubscriber {

    public NumberSubscriber() {
        super("number");
    }

    @Override
    public String process(String str) {
        return str.replaceAll("\\D+","");
    }
}
