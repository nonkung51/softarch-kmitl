
public class AlphabetSubscriber extends StringSubscriber {

    public AlphabetSubscriber() {
        super("alphabet");
    }

    @Override
    public String match() {
        return ".*[a-zA-Z].*";
    }
}
