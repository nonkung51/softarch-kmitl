package creational;

public class JSONBookMetadataExporter extends BookMetadataExporter {
    private BookMetadataFormatter formatter = null;
    @Override
    public BookMetadataFormatter getFormatter() {
        // Implement as Singleton
        try{
            if(formatter == null) {
                formatter = new JSONBookMetadataFormatter();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatter;
    }
}