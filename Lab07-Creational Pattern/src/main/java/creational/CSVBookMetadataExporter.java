package creational;

import java.io.IOException;

public class CSVBookMetadataExporter extends BookMetadataExporter {
    private BookMetadataFormatter formatter = null;
    @Override
    public BookMetadataFormatter getFormatter() {
        // Implement as Singleton
        try{
            if(formatter == null) {
                formatter = new CSVBookMetadataFormatter();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return formatter;
    }
}