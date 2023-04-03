package fileWorkers;

import general.GeneralVars;
import collection.InteractiveCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private final static Logger LOGGER = LogManager.getLogger(WriterCSV.class);

    public void save(InteractiveCollection curCol) {
        try (BufferedWriter writter =
                     new BufferedWriter(new FileWriter(GeneralVars.saveFileName, false))) {
            List<String> saveLines = curCol.toListCSV();
            writter.write(GeneralVars.HEADLINES + "\n");
            for (String saveLine : saveLines) {
                writter.write(saveLine + "\n");
            }
            LOGGER.info("Collection saved successfully");
        } catch (FileNotFoundException | SecurityException | NullPointerException e) {
            LOGGER.error(e.getMessage());
            LOGGER.error("Couldn't find given file. It's impossible to save.");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            LOGGER.error("Some content might be lost.");
        } catch (Exception e) {
            LOGGER.fatal(e.getMessage());
            System.out.println("Unreachable block. Just in case.");
        }
    }
}