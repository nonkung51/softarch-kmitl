// XXX: Changing Package location
package lsp;

// XXX: Square now extends Quadrilateral class
public class Square extends Quadrilateral {
    private int side;

    Square(int side) {
        this.setSide(side);
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}
