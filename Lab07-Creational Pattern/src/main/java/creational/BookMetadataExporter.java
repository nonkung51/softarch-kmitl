package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    public void export(PrintStream stream) {
        BookMetadataFormatter formatter = null;
        try {
            formatter = this.getFormatter();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Reset old artifacts
        formatter.reset();

        // Loop add books in formatter
        for (Book book : books) {
            formatter.append(book);
        }

        stream.println(formatter.getMetadataString());
    }

    abstract protected BookMetadataFormatter getFormatter();
}
