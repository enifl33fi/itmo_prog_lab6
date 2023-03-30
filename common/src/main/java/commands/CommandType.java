package commands;

import exceptions.WrongCommandException;

public enum CommandType {
    ADD("add"),
    CLEAR("clear"),
    COUNT_BY_CATEGORY("count_by_category"),
    EXECUTE_SCRIPT("execute_script"),
    EXIT("exit"),
    FILTER_CONTAINS_NAME("filter_contains_name"),
    HEAD("head"),
    HELP("help"),
    INFO("info"),
    PRINT_FIELD_ASCENDING_HEART_COUNT("print_field_ascending_heart_count"),
    REMOVE_BY_ID("remove_by_id"),
    REMOVE_FIRST("remove_first"),
    REMOVE_LOWER("remove_lower"),
    SHOW("show"),
    UPDATE("update");


    private final String name;

    CommandType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static CommandType getByName(String name){
        for (CommandType commandType : CommandType.values()){
            if (commandType.name.equals(name)){
                return commandType;
            }
        }
        throw new WrongCommandException();
    }
}