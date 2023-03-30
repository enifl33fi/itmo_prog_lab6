package element;

import element.*;
import exceptions.IdCollapseException;
import exceptions.NullFieldException;
import exceptions.WrongFieldException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Class that validates every field of SpaceMarine class. {@link element.SpaceMarine}
 *
 * @author Kirill Markov
 * @version 1.0
 */
public class ElementValidator {
    /**
     * Validates name field.
     * @param name given name field
     * @return name if it is valid
     * @throws exceptions.NullFieldException if name is null or empty
     * @throws exceptions.WrongFieldException if name contains commas
     */
    public String validateName(String name) {
        if (name == null) {
            throw new NullFieldException("name");
        }
        name = name.strip();
        if (name.equals("")) {
            throw new NullFieldException("name");
        }
        if (name.contains(",")) {
            throw new WrongFieldException("name cannot contain commas");
        }
        return name;
    }

    /**
     * Validates x field.
     * @param xStr string representation of x coordinate
     * @return x coordinate if it is valid
     * @throws exceptions.WrongFieldException if value of x coordinate is greater than 201
     * @throws NumberFormatException if it can't parse x coordinate to int
     */
    public int validateX(String xStr) {
        int x = Integer.parseInt(xStr);
        if (x > 201) {
            throw new WrongFieldException("The value of the field x must be less than or equal to 201.");
        }
        return x;
    }
    /**
     * Validates y field.
     * @param yStr string representation of y coordinate
     * @return y coordinate if it is valid
     * @throws exceptions.WrongFieldException if value of y coordinate is less than or equal to -440
     * @throws NumberFormatException if it can't parse y coordinate to int
     */
    public int validateY(String yStr) {
        int y = Integer.parseInt(yStr);
        if (y <= -440) {
            throw new WrongFieldException("The value of the y field must be greater than -440.");
        }
        return y;
    }

    /**
     * Validates health field.
     * @param healthStr string representation of health field
     * @return health value if it is valid
     * @throws NumberFormatException if it can't parse health field to Double
     * @throws exceptions.WrongFieldException if health field is less than or equal to 0
     */
    public Double validateHealth(String healthStr) {
        Double health = null;
        if (healthStr.equals("")) {
            return health;
        }
        health = Double.parseDouble(healthStr);
        if (health <= 0) {
            throw new WrongFieldException("The value of the field health must be greater than 0.");
        }
        return health;
    }

    /**
     * Validates heartCount field.
     * @param heartCountStr string representation of heartCount field
     * @return heart count if it is valid.
     * @throws NumberFormatException if it can't parse heartCount field to int
     * @throws exceptions.WrongFieldException if value of field heartCount is less than or equal to 0 or greater than 3.
     */
    public int validateHeartCount(String heartCountStr) {
        int heartCount = Integer.parseInt(heartCountStr);
        if (heartCount <= 0 || heartCount > 3) {
            throw new WrongFieldException(
                    "The value of the field heartCount must be greater than 0.The value of the heartCount field must be less than or equal to 3.");
        }
        return heartCount;
    }

    /**
     * Validates category field.
     * @param categoryStr string representation of category field
     * @return category if it is valid
     * @throws IllegalArgumentException if it can't find given value in AstartesCategory enum {@link element.AstartesCategory}
     */
    public AstartesCategory validateCategory(String categoryStr) {
        AstartesCategory category = null;
        if (categoryStr.equals("")) {
            return category;
        }
        category = AstartesCategory.valueOf(categoryStr);
        return category;
    }
    /**
     * Validates meleeWeapon field.
     * @param meleeWeaponStr string representation of meleeWeapon field
     * @return melee weapon if it is valid
     * @throws IllegalArgumentException if it can't find given value in MeleeWeapon enum {@link element.MeleeWeapon}
     */
    public MeleeWeapon validateMeleeWeapon(String meleeWeaponStr) {
        MeleeWeapon meleeWeapon = null;
        if (meleeWeaponStr.equals("")) {
            return meleeWeapon;
        }
        meleeWeapon = MeleeWeapon.valueOf(meleeWeaponStr);
        return meleeWeapon;
    }

    /**
     * Validates chapterName field.
     * @param chapterName given chapterName field
     * @return chapter name if it is valid
     * @throws exceptions.NullFieldException if chapterName is null or empty
     * @throws exceptions.WrongFieldException if chapterName contains commas
     */
    public String validateChapterName(String chapterName) {
        if (chapterName == null) {
            throw new NullFieldException("chapterName");
        }
        chapterName = chapterName.strip();
        if (chapterName.equals("")) {
            throw new NullFieldException("chapterName");
        }
        if (chapterName.contains(",")) {
            throw new WrongFieldException("chapterName cannot contain commas");
        }
        return chapterName;
    }

    /**
     * Validates marinesCount field.
     * @param marinesCountStr string representation of marinesCount field
     * @return marines count if it is valid
     * @throws NumberFormatException if it can't parse marinesCount field to Integer
     * @throws exceptions.WrongFieldException if value of field heartCount is less than or equal to 0 or greater than 1000.
     */
    public Integer validateMarinesCount(String marinesCountStr) {
        Integer marinesCount = Integer.parseInt(marinesCountStr);
        if (marinesCount <= 0 || marinesCount > 1000) {
            throw new WrongFieldException(
                    "The value of the field marinesCount must be greater than 0, the maximum value of the field: 1000.");
        }
        return marinesCount;
    }

    /**
     * Validates id field.
     * @param idStr string representation of id field.
     * @param ids list of currently validated ids
     * @return id if it is valid
     * @throws exceptions.IdCollapseException if given id is contained in used ids list
     * @throws NullFieldException if it can't parse marinesCount field to long
     */
    public long validateId(String idStr, List<Long> ids) {
        long id = Long.parseLong(idStr);
        if (ids.contains(id)) {
            throw new IdCollapseException();
        }
        return id;
    }

    /**
     * Validates creationDate field.
     * @param creationDateStr string representation of creationDate field
     * @return creation date if it is valid.
     * @throws ParseException if the beginning of the specified string cannot be parsed.
     */
    public Date validateCreationDate(String creationDateStr) throws ParseException {
        Date creationDate = new Date();
        if (creationDateStr != null) {
            creationDate =
                    new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH).parse(creationDateStr);
        }
        return creationDate;
    }

    /**
     * Validates SpaceMarine object.
     * @param name given name field
     * @param xStr string representation of x coordinate
     * @param yStr string representation of y coordinate
     * @param healthStr string representation of health field
     * @param heartCountStr string representation of heartCount field
     * @param categoryStr string representation of category field
     * @param meleeWeaponStr string representation of meleeWeapon field
     * @param chapterName given chapterName field
     * @param marinesCountStr string representation of marinesCount field
     * @param idStr string representation of id field.
     * @param ids list of currently validated ids
     * @param creationDateStr string representation of creationDate field
     * @return SpaceMarine object if all it's fields are valid.
     * @throws ParseException if the beginning of the specified string cannot be parsed.
     * @throws NumberFormatException if it can't parse some numeric field
     * @throws IllegalArgumentException if it can't parse some enum field
     * @throws exceptions.IdCollapseException if given id is contained in used ids list.
     */
    public SpaceMarine validateSpaceMarine(
            String name,
            String xStr,
            String yStr,
            String healthStr,
            String heartCountStr,
            String categoryStr,
            String meleeWeaponStr,
            String chapterName,
            String marinesCountStr,
            String idStr,
            List<Long> ids,
            String creationDateStr)
            throws ParseException {
        name = this.validateName(name);
        int x = this.validateX(xStr);
        int y = this.validateY(yStr);
        Coordinates coordinates = new Coordinates(x, y);
        Double health = this.validateHealth(healthStr);
        int heartCount = this.validateHeartCount(heartCountStr);
        AstartesCategory category = this.validateCategory(categoryStr);
        MeleeWeapon meleeWeapon = this.validateMeleeWeapon(meleeWeaponStr);
        chapterName = this.validateChapterName(chapterName);
        Integer marinesCount = this.validateMarinesCount(marinesCountStr);
        Chapter chapter = new Chapter(chapterName, marinesCount);
        long id = this.validateId(idStr, ids);
        Date creationDate = this.validateCreationDate(creationDateStr);
        return new SpaceMarine(
                name, coordinates, health, heartCount, category, meleeWeapon, chapter, id, creationDate);
    }

    /**
     * Validates SpaceMarine object.
     *
     * @param args - string array with object's fields in this order: name, xStr, yStr, healthStr,
     *     heartCountStr, categoryStr, meleeWeaponStr, chapterName, marinesCountStr
     * @return SpaceMarine object if all it's fields are valid
     * @throws NumberFormatException if it can't parse some numeric field
     * @throws IllegalArgumentException if it can't parse some enum field
     * @throws exceptions.IdCollapseException if given id is contained in used ids list
     */
    public SpaceMarine validateSpaceMarine(String[] args) {
        String name = this.validateName(args[0]);
        int x = this.validateX(args[1]);
        int y = this.validateY(args[2]);
        Coordinates coordinates = new Coordinates(x, y);
        Double health = this.validateHealth(args[3]);
        int heartCount = this.validateHeartCount(args[4]);
        AstartesCategory category = this.validateCategory(args[5]);
        MeleeWeapon meleeWeapon = this.validateMeleeWeapon(args[6]);
        String chapterName = this.validateChapterName(args[7]);
        Integer marinesCount = this.validateMarinesCount(args[8]);
        Chapter chapter = new Chapter(chapterName, marinesCount);
        return new SpaceMarine(name, coordinates, health, heartCount, category, meleeWeapon, chapter);
    }
}
