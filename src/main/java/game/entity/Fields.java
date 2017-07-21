package game.entity;

/**
 * Holds the fiend values
 */
public class Fields {
    private int x;
    private int y;
    private Field field;

    public int getX() {
        return x;
    }

    public void setX(int x) {this.x = x;}

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
