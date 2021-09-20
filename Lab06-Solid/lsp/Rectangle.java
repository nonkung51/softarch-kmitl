// XXX: Changing Package location
package lsp;

// XXX: Rectangle now implement RectangleLike interface
public class Rectangle implements RectangleLike {
    // DO NOT EDIT THE FILE FROM THIS LINE ONWARD!!
    private int width;
    private int height;

    Rectangle() {
    }

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}
