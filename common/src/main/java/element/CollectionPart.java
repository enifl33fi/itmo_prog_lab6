package element;

import java.io.Serializable;
import java.util.Date;
/**
 * Interface describing any item that can be stored in the collection.
 *
 * @author Kirill Markov
 * @version 1.0
 */
public interface CollectionPart extends Comparable<CollectionPart>, Serializable {
    /**
     * Returns value of element's id.
     *
     * @return Value of element's id.
     */
    long getId();

    /**
     * Returns element's name.
     *
     * @return Element's name.
     */
    String getName();

    /**
     * Set element's name. Cannot be null or empty and cannot contain commas.
     *
     * @param name element's name.
     */
    void setName(String name);

    /**
     * Returns element's coordinates({@link element.Coordinates}).
     *
     * @return Element's coordinates.
     */
    Coordinates getCoordinates();

    /**
     * Set element's coordinates({@link element.Coordinates}). Cannot be null.
     *
     * @param coordinates element's coordinates.
     */
    void setCoordinates(Coordinates coordinates);

    /**
     * Returns creation date of this element.
     *
     * @return creationDate of this element.
     */
    Date getCreationDate();

    /**
     * Returns value of element's health.
     *
     * @return Value of element's health. Can be null.
     */
    Double getHealth();

    /**
     * Set value of element's health. Must be greater than 0.
     *
     * @param health value of element's health.
     */
    void setHealth(Double health);

    /**
     * Returns value of element's heartCount.
     *
     * @return Value of element's heartCount.
     */
    int getHeartCount();

    /**
     * Set value of element's heartCount. Must be greater than 0 and less than or equal to 3.
     *
     * @param heartCount value of element's heartCount.
     */
    void setHeartCount(int heartCount);

    /**
     * Returns category({@link element.AstartesCategory}) of the element. Can be null.
     *
     * @return category of the element.
     */
    AstartesCategory getCategory();

    /**
     * Set category({@link element.AstartesCategory}) of the element.
     *
     * @param category category of the element.
     */
    void setCategory(AstartesCategory category);

    /**
     * Returns meleeWeapon({@link element.MeleeWeapon}) of the element. Can be null.
     *
     * @return meleeWeapon of the element.
     */
    MeleeWeapon getMeleeWeapon();

    /**
     * Set meleeWeapon({@link element.MeleeWeapon}) of the element.
     *
     * @param meleeWeapon meleeWeapon of the element.
     */
    void setMeleeWeapon(MeleeWeapon meleeWeapon);

    /**
     * Returns chapter({@link element.Chapter}) of the element.
     *
     * @return chapter of the element.
     */
    Chapter getChapter();

    /**
     * Set chapter({@link element.Chapter}) of the element. Cannot be null.
     *
     * @param chapter chapter of the element.
     */
    void setChapter(Chapter chapter);

    @Override
    int compareTo(CollectionPart o);

    /**
     * Returns a CSV representation of the object.
     *
     * @return A CSV representation of the object.
     */
    String toLineCSV();

}