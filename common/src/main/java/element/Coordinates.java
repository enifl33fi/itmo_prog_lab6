package element;

import exceptions.WrongFieldException;

import java.io.Serializable;

/**
 * Class for storing x and y coordinates.
 *
 * @author Kirill Markov
 * @version 1.0
 */
public class Coordinates implements Serializable {
    /** x coordinate. Must be less than or equal to 201. */
    private int x; // Максимальное значение поля: 201
    /** y coordinate. Must be greater than -440. */
    private int y; // Значение поля должно быть больше -440

    /**
     * Constructs a new Coordinate object with specified x and y coordinates.
     *
     * @param x x coordinate
     * @param y y coordinate
     * @throws exceptions.WrongFieldException if x field is greater than 201 or y field is less than
     *     or equal to -440.
     */
    public Coordinates(int x, int y) {
        if (y <= -440) {
            throw new WrongFieldException("The value of the y field must be greater than -440");
        }
        if (x > 201) {
            throw new WrongFieldException("The value of the x field must be less than or equal to 201");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Returns x coordinate.
     *
     * @return x coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Set x coordinate. Must be less than or equal to 201.
     *
     * @param x x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Returns y coordinate.
     *
     * @return y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Set y coordinate. Must be greater than -440.
     *
     * @param y y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
}
