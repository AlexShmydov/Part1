package Enums;

public enum Settings {
    RHOMBUS_SYMBOL('*'),
    DEFAULT_SYMBOL(' ');

    private final char value;

    Settings(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }
}
