package managers;
import collection.InteractiveCollection;
import commands.*;

public class CommandLoader {
    private final CommandManager commandManager;

    public CommandLoader(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public void load(InteractiveCollection curCol) {
        Command addCommand = new AddCommand(curCol);
        Command clearCommand = new ClearCommand(curCol);
        Command countByCategoryCommand = new CountByCategoryCommand(curCol);
        Command exitCommand = new ExitCommand(curCol);
        Command filterContainsNameCommand = new FilterContainsNameCommand(curCol);
        Command headCommand = new HeadCommand(curCol);
        Command helpCommand = new HelpCommand(curCol, this.commandManager);
        Command infoCommand = new InfoCommand(curCol);
        Command printFieldAscendingHeartCountCommand = new PrintFieldAscendingHeartCountCommand(curCol);
        Command removeByIdCommand = new RemoveByIdCommand(curCol);
        Command removeFirstCommand = new RemoveFirstCommand(curCol);
        Command removeLowerCommand = new RemoveLowerCommand(curCol);
        Command showCommand = new ShowCommand(curCol);
        Command updateCommand = new UpdateCommand(curCol);

        this.commandManager.addCommand(addCommand);
        this.commandManager.addCommand(clearCommand);
        this.commandManager.addCommand(countByCategoryCommand);
        this.commandManager.addCommand(exitCommand);
        this.commandManager.addCommand(filterContainsNameCommand);
        this.commandManager.addCommand(headCommand);
        this.commandManager.addCommand(helpCommand);
        this.commandManager.addCommand(infoCommand);
        this.commandManager.addCommand(printFieldAscendingHeartCountCommand);
        this.commandManager.addCommand(removeByIdCommand);
        this.commandManager.addCommand(removeFirstCommand);
        this.commandManager.addCommand(removeLowerCommand);
        this.commandManager.addCommand(showCommand);
        this.commandManager.addCommand(updateCommand);
    }
}