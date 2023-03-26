package inputWorkers;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputHandler {
    private Scanner console = new Scanner(System.in);

    public String getLine(){
        try {
            System.out.print("-> ");
            return console.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Idk how that happened. Never mind.");
            this.console = new Scanner(System.in);
        }
        return null;
    }
}
