// XXX: Changing Package location
package lsp;

// XXX: Square now implement RectangleLike interface
public class Square implements RectangleLike {
    private int side;

    Square(int side) {
        this.setSide(side);
    }

    public void setWidth(int width) {
        this.setSide(width);
    }

    public int getWidth() {
        return side;
    }

    public void setHeight(int height) {
        this.setSide(height);
    }

    public int getHeight() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getArea() {
        return side * side;
    }
}
