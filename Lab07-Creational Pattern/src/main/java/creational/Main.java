package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // Current usage
        BookMetadataFormatter formatter = null;
        try {
            formatter = BookMetadataFormatterFactory.getBookMetadataFormatter(BookMetadataFormatterFactory.Format.JSON);
            formatter.append(TestData.dragonBook);
            formatter.append(TestData.dinosaurBook);
            System.out.println(formatter.getMetadataString());
            formatter.reset();
            System.out.println("Reset!!");
            System.out.println(formatter.getMetadataString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        System.out.println("=============================");

        // Expected usage (Provided)
        BookMetadataExporter exporter = new XMLBookMetadataExporter();
        exporter.add(TestData.sailboatBook);
        exporter.add(TestData.GoFBook);
        exporter.export(System.out);

        System.out.println("=============================");

        // Expected usage -> Factory Method
        BookMetadataExporter exporter2 = null;

        String exporterType = "JSON";
        if (exporterType.equals("CSV")) {
            exporter2 = new CSVBookMetadataExporter();
        } else if (exporterType.equals("XML")) {
            exporter2 = new XMLBookMetadataExporter();
        } else if (exporterType.equals("JSON")) {
            exporter2 = new JSONBookMetadataExporter();
        } else {
            exporter2 = new JSONBookMetadataExporter();
        }

        exporter2.add(TestData.sailboatBook);
        exporter2.add(TestData.GoFBook);
        exporter2.export(System.out);
    }
}
