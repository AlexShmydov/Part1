package Enums;

public enum Parameters {
    FIRST_NAME("Alex"),
    SECOND_NAME("Shmydov"),
    DEFAULT_SYMBOL("*"),
    DEFAULT_EXPRESSION("[\\\\a-zA-Zа-яА-Я.]"),
    ALREADY_EXIST("EXIST"),
    DEFAULT_PATTER_IGNORE_CASE("(?i:.*%s.*)");

    private final String VALUE;

    Parameters(String VALUE) {
        this.VALUE = VALUE;
    }

    public String getValue() {
        return this.VALUE;
    }
}
