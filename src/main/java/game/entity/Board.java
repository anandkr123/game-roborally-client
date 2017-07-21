package game.entity;

/**
 * Holds the board elements
 */
public class Board {
    Size size;
    Fields []fields;

    public Size getSize() {
        return size;
    }

    /**
     * set the size of the board (length*width)
     * @param size size of the board
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     *
     * @return returns the description of all fileds in the board
     */
    public Fields[] getFields() {
        return fields;
    }

    /**
     * set the description of all fields in the board
     * @param fields fields of the board
     */
    public void setFields(Fields[] fields) {
        this.fields = fields;
    }
}
