
public class SymbolSubscriber extends StringSubscriber{
    public SymbolSubscriber() {
        super("symbol");
    }

    @Override
    public String match() {
        return ".*[!-/:-@\\[-`{-~].*";
    }
}
