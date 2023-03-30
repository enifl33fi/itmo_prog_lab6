package fileWorkers;

import general.GeneralVars;
import collection.InteractiveCollection;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Class that saves collection's elements to CSV file.
 * @author Kirill Markov
 * @version 1.0
 */
public class WriterCSV {
    /**
     * Saves given collection's elements to CSV file.
     * @param curCol given collection. {@link collection.InteractiveCollection}
     */
    public void save(InteractiveCollection curCol) {
        try (BufferedWriter writter =
                     new BufferedWriter(new FileWriter(GeneralVars.saveFileName, false))) {
            List<String> saveLines = curCol.toListCSV();
            writter.write(GeneralVars.HEADLINES + "\n");
            for (String saveLine : saveLines) {
                writter.write(saveLine + "\n");
            }
            System.out.println("Collection saved successfully");
        } catch (FileNotFoundException | SecurityException | NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Couldn't find given file. It's impossible to save.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Some content might be lost.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Unreachable block. Just in case.");
        }
    }
}