package creational;

import javax.xml.parsers.ParserConfigurationException;

public class XMLBookMetadataExporter extends BookMetadataExporter {
    private BookMetadataFormatter formatter = null;
    @Override
    public BookMetadataFormatter getFormatter() {
        // Implement as Singleton
        try{
            if(formatter == null) {
                formatter = new XMLBookMetadataFormatter();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return formatter;
    }
}
