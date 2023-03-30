package element;

import exceptions.NullFieldException;
import exceptions.WrongFieldException;

import java.io.Serializable;

/** Class for storing information about chapter.
 * @author Kirill Markov
 * @version 1.0*/
public class Chapter implements Serializable {
    /** Name of the chapter. Cannot be null or empty and cannot contain commas. */
    private String name; // Поле не может быть null, Строка не может быть пустой
    /** Value of marines count. Can't be null. Must be greater than 0, the maximum value: 1000. */
    private Integer
            marinesCount; // Поле не может быть null, Значение поля должно быть больше 0, Максимальное
    // значение поля: 1000

    /**
     * Constructs a new Chapter object with specified name and marinesCount values.
     *
     * @param name chapter's name.
     * @param marinesCount chapter's marinesCount.
     * @throws exceptions.NullFieldException if chapterName is null or marinesCount is null.
     * @throws exceptions.WrongFieldException if marinesCount is less than or equal to 0 or greater
     *     than 1000.
     */
    public Chapter(String name, Integer marinesCount) {
        if (name == null || name.equals("")) {
            throw new NullFieldException("chapterName");
        }
        if (marinesCount != null && (marinesCount <= 0 || marinesCount > 1000)) {
            throw new WrongFieldException(
                    "The value of the field marinesCount must be greater than 0, the maximum value of the field: 1000");
        } else if (marinesCount == null) {
            throw new NullFieldException("marinesCount");
        }
        this.name = name;
        this.marinesCount = marinesCount;
    }

    /**
     * Returns chapter's name.
     *
     * @return Chapter's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set chapter's name. Cannot be null or empty and cannot contain commas.
     *
     * @param name chapter's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns chapter's marinesCount.
     *
     * @return Chapter's marinesCount.
     */
    public Integer getMarinesCount() {
        return marinesCount;
    }

    /**
     * Set chapter's marinesCount. Can't be null. Must be greater than 0, the maximum value: 1000.
     *
     * @param marinesCount chapter's marinesCount.
     */
    public void setMarinesCount(Integer marinesCount) {
        this.marinesCount = marinesCount;
    }
}
