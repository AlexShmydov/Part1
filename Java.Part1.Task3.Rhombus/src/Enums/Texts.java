package Enums;

public enum Texts {
    WELCOME_MSG("Hello!\nPart #1.\nPut count of '*' and press ENTER to submit it. It will be length of rhombuses side.");
    private final String value;

    Texts(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
