package element;

import exceptions.NullFieldException;
import exceptions.WrongFieldException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ElementParser {
    private final ElementValidator elementValidator = new ElementValidator();

    private Scanner console = new Scanner(System.in);
    public String parseName() {
        while (true) {
            try {
                System.out.println(
                        """
                                    Please enter the field name.
                                    Note: The field cannot be null or empty. The field cannot contain commas.
                                    Addition: Be careful, insignificant spaces are deleted. So a string of spaces is considered empty.
                                    """);
                String name = this.elementValidator.validateName(this.console.nextLine());
                return name;
            } catch (NullFieldException | WrongFieldException e) {
                System.out.println(e.getMessage());
                System.out.println("Read the note.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                System.out.println("Idk how that happened. Never mind.");
                console = new Scanner(System.in);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Unreachable block. Just in case.");
            }
        }
    }

    public int parseX() {
        while (true) {
            try {
                System.out.println(
                        """
                                    Please enter the field x in Coordinates.
                                    Note: x is a numeric field. The value of the field must be less than or equal to 201.
                                    """);
                int x = elementValidator.validateX(this.console.nextLine());
                return x;
            } catch (WrongFieldException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Read the note.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                System.out.println("Idk how that happened. Never mind.");
                console = new Scanner(System.in);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Unreachable block. Just in case.");
            }
        }
    }
    public int parseY() {
        while (true) {
            try {
                System.out.println(
                        """
                                    Please enter the field y in Coordinates.
                                    Note: y is a numeric field. The value of the field must be greater than -440.
                                    """);
                int y = elementValidator.validateY(this.console.nextLine());
                return y;
            } catch (WrongFieldException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Read the note.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                System.out.println("Idk how that happened. Never mind.");
                console = new Scanner(System.in);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Unreachable block. Just in case.");
            }
        }
    }
    public Double parseHealth() {
        while (true) {
            try {
                System.out.println(
                        """
                                    Please enter the field health.
                                    Note: Health is a fractional field. The field can be null. The value of the field must be greater than 0.
                                    """);
                Double health = elementValidator.validateHealth(this.console.nextLine());
                return health;
            } catch (WrongFieldException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Read the note.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                System.out.println("Idk how that happened. Never mind.");
                console = new Scanner(System.in);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Unreachable block. Just in case.");
            }
        }
    }
    public int parseHeartCount() {
        while (true) {
            try {
                System.out.println(
                        """
                                    Please enter the field heartCount.
                                    Note: heartCount is a numeric field. The value of the field must be greater than 0.The value of the field must be less than or equal to 3.
                                    """);
                int heartCount = elementValidator.validateHeartCount(this.console.nextLine());
                return heartCount;
            } catch (WrongFieldException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Read the note.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                System.out.println("Idk how that happened. Never mind.");
                console = new Scanner(System.in);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Unreachable block. Just in case.");
            }
        }
    }
    public AstartesCategory parseCategory() {
        AstartesCategory[] allCategoryValues = AstartesCategory.values();
        while (true) {
            try {
                System.out.println(
                        """
                                    Please enter the field category.
                                    Note: The field can be null.
                                    """);
                for (int i = 0; i < allCategoryValues.length; i++) {
                    System.out.printf("%d. %s%n", i + 1, allCategoryValues[i].toString());
                }
                System.out.println("Note: You can insert either numbers or values\n");
                String line = this.console.nextLine();
                try {
                    int index = Integer.parseInt(line);
                    AstartesCategory category = allCategoryValues[index - 1];
                    return category;
                } catch (NumberFormatException ignored) {

                }
                AstartesCategory category = elementValidator.validateCategory(line);
                return category;
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                System.out.println("Read the note.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                System.out.println("Idk how that happened. Never mind.");
                console = new Scanner(System.in);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Unreachable block. Just in case.");
            }
        }
    }
    public MeleeWeapon parseMeleeWeapon() {
        MeleeWeapon[] allWeaponValues = MeleeWeapon.values();
        while (true) {
            try {
                System.out.println(
                        """
                                    Please enter the field meleeWeapon.
                                    Note: The field can be null.
                                    """);
                for (int i = 0; i < allWeaponValues.length; i++) {
                    System.out.printf("%d. %s%n", i + 1, allWeaponValues[i].toString());
                }
                System.out.println("Note: You can insert either numbers or values\n");
                String line = this.console.nextLine();
                try {
                    int index = Integer.parseInt(line);
                    MeleeWeapon meleeWeapon = allWeaponValues[index - 1];
                    return meleeWeapon;
                } catch (NumberFormatException ignored) {

                }
                MeleeWeapon meleeWeapon = elementValidator.validateMeleeWeapon(line);
                return meleeWeapon;
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                System.out.println("Read the note.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                System.out.println("Idk how that happened. Never mind.");
                console = new Scanner(System.in);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Unreachable block. Just in case.");
            }
        }
    }
    public String parseChapterName() {
        while (true) {
            try {
                System.out.println(
                        """
                                    Please enter the field name in Chapter.
                                    Note: The field cannot be null or empty. The field cannot contain commas.
                                    Addition: Be careful, insignificant spaces are deleted. So a string of spaces is considered empty.
                                    """);
                String chapterName = elementValidator.validateChapterName(this.console.nextLine());
                return chapterName;
            } catch (NullFieldException | WrongFieldException e) {
                System.out.println(e.getMessage());
                System.out.println("Read the note.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                System.out.println("Idk how that happened. Never mind.");
                console = new Scanner(System.in);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Unreachable block. Just in case.");
            }
        }
    }
    public Integer parseMarinesCount() {
        while (true) {
            try {
                System.out.println(
                        """
                                    Please enter the field marinesCount in Chapter.
                                    Note: MarinesCount is a numeric field. The field can't be null. The value of the field must be greater than 0, the maximum value of the field: 1000.
                                    """);
                Integer marinesCount = elementValidator.validateMarinesCount(this.console.nextLine());
                return marinesCount;
            } catch (WrongFieldException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Read the note.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                System.out.println("Idk how that happened. Never mind.");
                console = new Scanner(System.in);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                System.out.println("Unreachable block. Just in case.");
            }
        }
    }
    public SpaceMarine parseElement() {
        String name = this.parseName();
        Coordinates coordinates = new Coordinates(this.parseX(), this.parseY());
        Double health = this.parseHealth();
        int heartCount = this.parseHeartCount();
        AstartesCategory category = this.parseCategory();
        MeleeWeapon meleeWeapon = this.parseMeleeWeapon();
        Chapter chapter = new Chapter(this.parseChapterName(), this.parseMarinesCount());
        return new SpaceMarine(name, coordinates, health, heartCount, category, meleeWeapon, chapter);
    }
}