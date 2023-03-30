package collection;

import element.AstartesCategory;
import element.CollectionPart;

import java.util.List;

/**
 * Interface that describes collection with specified methods
 * @author Kirill Markov
 * @version 1.0
 */
public interface InteractiveCollection {
    /**
     * Prints information about the current collection.
     * Such as initialization date, size etc.
     */
    String info();

    /**
     * Appends the specified element to the end of this collection.
     * @param elem  element that should be added. See {@link element.CollectionPart}
     */
    void add(CollectionPart elem);

    /**
     * Returns the number of elements in this collection.
     * @return the number of elements in this collection.
     */
    int size();

    /**
     * Prints all elements of the collection to the standard output stream in string representation.
     */
    String show();

    /**
     * Updates the value of an element in the collection whose id is equal to the given one.
     * @param id  given id.
     * @param elem  update element. {@link  element.CollectionPart}
     */
    String update(long id, CollectionPart elem);

    /**
     * Removes the element at the specified position in this collection.
     * @param id  given id.
     */
    String removeById(long id);

    /**
     * Removes all the elements from this collection. The collection will be empty after this call returns.
     */
    void clear();
    /**
     * Removes the first element from this list.
     */
    String removeFirst();

    /**
     * Prints the first element in this collection.
     */
    String head();

    /**
     * Remove all elements from the collection that are smaller than the given one.
     * @param elem  comparable element. {@link  element.CollectionPart}
     */
    String removeLower(CollectionPart elem);

    /**
     * Prints the number of elements with a category value equal to the given one.
     * @param category  given category. {@link element.AstartesCategory}
     */
    int countByCategory(AstartesCategory category);

    /**
     * Prints the elements whose name field value contains the specified substring.
     * @param namePart  given substring.
     */
    String filterContainsName(String namePart);

    /**
     *  Prints the heartCount values of all elements in ascending order.
     */
    String printFieldAscendingHeartCount();

    /**
     * Returns a CSV representation of all elements from the collection.
     * @return String list with CSV representation of all elements from the collection.
     */
    List<String> toListCSV();

    /**
     * Set all parameters from one element to another. But does not affect the id and creation date.
     * @param updElem  update element. {@link  element.CollectionPart}
     * @param elem  element that will be updated. {@link  element.CollectionPart}
     */
    void set(CollectionPart updElem, CollectionPart elem);
}
