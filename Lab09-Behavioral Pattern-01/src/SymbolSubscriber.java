
public class SymbolSubscriber extends StringSubscriber{
    public SymbolSubscriber() {
        super("symbol");
    }

    @Override
    public String process(String str) {
        return str.replaceAll("\\w|d+","");
    }
}
