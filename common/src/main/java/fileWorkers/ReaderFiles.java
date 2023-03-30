package fileWorkers;

import general.GeneralVars;

import java.io.*;

/** Class that simplifies reading from file via InputStreamReader.
 * @author Kirill Markov
 * @version 1.0
 */
public class ReaderFiles {
    /** Line Feed ASCII code. */
    private static final int asciin = '\n';
    /** Carriage Return ASCII code. */
    private static final int asciir = '\r';

    /**
     * Reads line of text. A line is considered to be terminated by any one of a line feed ('\n'), a
     * carriage return ('\r'), a carriage return followed immediately by a line feed, or by reaching
     * the end-of-file (EOF).
     *
     * @param fileReader current InputStreamReader.
     * @return Line of text.
     * @throws IOException if an I/O error occurs.
     */
    private String readLine(InputStreamReader fileReader) throws IOException {
        boolean newLine = false;
        int cur, prev = -2;
        StringBuilder line = new StringBuilder();
        while ((cur = fileReader.read()) != -1) {
            if (cur == asciir){
                cur = fileReader.read();
            }
            if (cur == asciin) {
                newLine = true;
            } else {
                line.append((char) cur);
            }
            if (newLine) {
                return line.toString();
            }
            prev = cur;
        }
        if (line.length() > 0) {
            return line.toString();
        }
        return null;
    }

    /**
     * Reads line of text. A line is considered to be terminated by any one of a line feed ('\n'), a *
     * carriage return ('\r'), a carriage return followed immediately by a line feed, or by reaching *
     * the end-of-file (EOF). If file ended returns null.
     *
     * @param reader current InputStreamReader.
     * @return Line of text.
     */
    public String getLine(InputStreamReader reader) {
        String line = null;

        try {
            InputStreamReader fileReader = reader;
            line = readLine(fileReader);
            return line;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to read");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Unreachable block. Just in case.");
        }
        return line;
    }

    /**
     * Returns array with specified number of lines from text.
     * @param reader current InputStreamReader
     * @return Array with specified number of lines from text.
     */
    public String[] readElem(InputStreamReader reader) {
        String[] elemParts = new String[GeneralVars.VAR_COUNT - 2];
        InputStreamReader fileReader = reader;
        for (int i = 0; i < GeneralVars.VAR_COUNT - 2; i++) {
            elemParts[i] = this.getLine(reader);
        }

        return elemParts;
    }
}
