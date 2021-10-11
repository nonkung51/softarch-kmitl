package creational;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.IOException;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject books;

    public JSONBookMetadataFormatter() throws IOException {
        this.reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        books = new JSONObject();
        books.put("Books", new JSONArray());

        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        try {
            JSONArray booksArray = (JSONArray) books.get("Books");
            JSONObject book = new JSONObject();

            String[] authors = b.getAuthors();
            JSONArray authorsArray = new JSONArray();
            for (int i=0; i < authors.length; i++) {
                authorsArray.add(authors[i]);
            }

            book.put("ISBN", b.getISBN());
            book.put("Authors", authorsArray);
            book.put("Title", b.getTitle());
            book.put("Publisher", b.getPublisher());

            booksArray.add(book);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public String getMetadataString() {
        return books.toJSONString();
    }
}
