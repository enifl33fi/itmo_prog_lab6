package commands;

import collection.InteractiveCollection;
import fileWorkers.WriterCSV;

public class SaveCommand {
    private final WriterCSV writerCSV = new WriterCSV();
    private final InteractiveCollection curCol;

    public SaveCommand(InteractiveCollection curCol) {
        this.curCol = curCol;
    }

    public void execute() {
        this.writerCSV.save(this.curCol);

    }
}
