package collection;

import element.ElementValidator;
import general.GeneralVars;
import element.*;
import exceptions.IdCollapseException;
import exceptions.NotEnoughFieldsException;
import exceptions.NullFieldException;
import exceptions.WrongFieldException;
import fileWorkers.ReaderFiles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;


/**
 * Class that generates collection from CSV file.
 *
 * @author Kirill Markov
 * @version 1.0
 */
public class CollectionGenerator {
    /**
     * simplifies reading. {@link fileWorkers.ReaderFiles}
     */
    private final ReaderFiles reader = new ReaderFiles();
    private static final Logger LOGGER = LogManager.getLogger(CollectionGenerator.class);


    /**
     * Creates objects from CSV representation and puts it into the collection.
     * @param curCol  current collection. {@link collection.InteractiveCollection}
     */
    public void generateFromCSV(InteractiveCollection curCol) {
        try (InputStreamReader inputStream = new InputStreamReader(new FileInputStream(GeneralVars.saveFileName))) {
            String line = this.reader.getLine(inputStream);
            line = this.reader.getLine(inputStream);
            List<Long> ids = new ArrayList<>();
            ElementValidator elementValidator = new ElementValidator();
            int i = 1;
            while (line != null) {
                i++;
                String[] info = line.split(",", -1);
                try {
                    if (info.length != GeneralVars.VAR_COUNT) {
                        throw new NotEnoughFieldsException("line number " + i + " don't have enough fields");
                    }
                } catch (NotEnoughFieldsException e) {
                    LOGGER.warn("The whole line number " + i + " will be lost. Reason: "+ e.getMessage());
                    continue;
                }
                try {
                    SpaceMarine spaceMarine =
                            elementValidator.validateSpaceMarine(
                                    info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8],
                                    info[9], ids, info[10]);
                    curCol.add(spaceMarine);
                    ids.add(spaceMarine.getId());

                } catch (ParseException e) {

                    LOGGER.warn("The whole line number " + i + " will be lost. Reason: \n" +
                            "Not correct pattern for data.\nCorrect pattern: EEE MMM dd kk:mm:ss z yyyy.");
                } catch (NumberFormatException e) {
                    ;
                    LOGGER.warn("The whole line number " + i + " will be lost.Reason: \n" +
                            "One of number-format fields was empty or string");
                } catch (WrongFieldException | NullFieldException | IdCollapseException e) {
                    LOGGER.warn("The whole line number " + i + " will be lost. Reason: "+ e.getMessage());
                } catch (Exception e) {
                    LOGGER.fatal(e.getMessage());
                    System.out.println("Unreachable block. Just in case.");
                }
                line = this.reader.getLine(inputStream);
            }
        } catch (SecurityException | IOException | NullPointerException e) {
            LOGGER.error("Couldn't find given file. It's impossible to read. Reason: " + e.getMessage());
        } catch (Exception e) {
            LOGGER.fatal(e.getMessage());
            System.out.println("Unreachable block. Just in case.");
        }
        LOGGER.info("Collection read successfully");
    }
}
