
public class AlphabetSubscriber extends StringSubscriber {

    public AlphabetSubscriber() {
        super("alphabet");
    }

    @Override
    public String process(String str) {
        return str.replaceAll("[^a-zA-Z]","");
    }
}
