package collection;

import java.util.*;

import element.AstartesCategory;
import element.CollectionPart;

/**
 * Class that implements the collection with specified methods.
 *
 * @author Kirill Markov
 * @version 1.0
 */
public class SpaceMarineCollection implements InteractiveCollection {
    /**
     * Collection for elements storing.
     */
    private final LinkedList<CollectionPart> data = new LinkedList<>();
    /**
     * Collection initialization date.
     */
    private final java.time.LocalDate initDate;

    /**
     * Constructs a new SpaceMarineCollection object. And set the initialization date.
     */
    public SpaceMarineCollection() {
        this.initDate = java.time.LocalDate.now();
    }
    @Override
    public String info() {
        StringBuilder answer = new StringBuilder();
        answer.append("Initialization date: ").append(this.initDate).append("\n");
        answer.append("Type of collection: ").append(this.data.getClass().getName()).append("\n");
        answer.append("Length of current collection: ").append(this.data.size()).append("\n");
        return answer.toString();
    }

    @Override
    public void add(CollectionPart elem) {
        this.data.add(elem);
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public String show() {
        StringBuilder answer = new StringBuilder();
        for (CollectionPart curElem : this.data) {
            answer.append(curElem);
        }
        return answer.toString();
    }

    @Override
    public String update(long id, CollectionPart elem) {
        int i = 0;
        String answer = null;
        for (CollectionPart curElem : this.data) {
            if (curElem.getId() == id) {
                this.set(curElem, elem);
                answer = String.format("Element with id %d updated successfully", id);
                break;
            }
            if (i == this.data.size() - 1) {
                answer = "No such id.";
            }
            i++;
        }
        return answer;
    }

    @Override
    public String removeById(long id) {
        int i = 0;
        String answer = null;
        if (this.data.size() == 0) {
            answer = "Collection is empty";
        }
        for (CollectionPart curElem : this.data) {
            if (curElem.getId() == id) {
                answer = String.format("Element with id %d deleted.%n", curElem.getId());
                this.data.remove(i);
                break;
            }
            if (i == this.data.size() - 1) {
                answer = "No such id.";
            }
            i++;
        }
        return answer;
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public String removeFirst() {
        String answer = null;
        try {
            this.data.removeFirst();
            answer = "First element successfully removed";
        } catch (NoSuchElementException e) {
            answer = "Collection is empty";
        }
        return answer;
    }

    @Override
    public String head() {
        try {
            return this.data.getFirst().toString();
        } catch (NoSuchElementException e) {
            return "Collection is empty";
        }
    }

    @Override
    public String removeLower(CollectionPart elem) {
        StringBuilder answer = new StringBuilder();
        Iterator<CollectionPart> iterator = this.data.iterator();
        CollectionPart curElem;
        while (iterator.hasNext()) {
            curElem = iterator.next();
            if (elem.compareTo(curElem) > 0) {
                answer.append(String.format("Element with id %d deleted.%n", curElem.getId()));
                iterator.remove();
            }
        }
        if (answer.length() == 0){
            answer.append("Where is no elements lower than this.").append("\n");
        }
        return answer.toString();
    }

    @Override
    public int countByCategory(AstartesCategory category) {
        int counter = 0;
        for (CollectionPart curElem : this.data) {

            if (Objects.equals(curElem.getCategory(), category)) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String filterContainsName(String namePart) {
        StringBuilder answer = new StringBuilder();
        for (CollectionPart curElem : this.data) {
            if (curElem.getName().contains(namePart)) {
                answer.append(curElem);
            }
        }
        return answer.toString();
    }

    @Override
    public String printFieldAscendingHeartCount() {
        StringBuilder answer = new StringBuilder();
        List<Integer> heartCounts = new ArrayList<>();
        for (CollectionPart curElem : this.data) {
            heartCounts.add(curElem.getHeartCount());
        }
        Collections.sort(heartCounts);
        for (Integer heartCount : heartCounts) {
            answer.append(heartCount).append("\n");
        }
        return answer.toString();
    }

    @Override
    public List<String> toListCSV() {
        List<String> strList = new ArrayList<>();
        for (CollectionPart curElem : this.data) {
            strList.add(curElem.toLineCSV());
        }
        return strList;
    }

    @Override
    public void set(CollectionPart updElem, CollectionPart elem) {
        updElem.setName(elem.getName());
        updElem.setCoordinates(elem.getCoordinates());
        updElem.setHealth(elem.getHealth());
        updElem.setHeartCount(elem.getHeartCount());
        updElem.setCategory(elem.getCategory());
        updElem.setMeleeWeapon(elem.getMeleeWeapon());
        updElem.setChapter(elem.getChapter());
    }
}