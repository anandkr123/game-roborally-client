package game.entity;

/**
 * Holds the board size and width
 */
public class Size {
    int width;
    int height;

    /**
     *
     * @return returns the width of the Board
     */
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {this.width = width;}

    /**
     *
     * @return returns the height of the Board
     */
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
