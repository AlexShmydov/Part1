package Enums;

public enum Texts {

    WELCOME_MSG("Hello!\nTask #2.\n"),
    SUBMIT_MSG("\nPut any number of weeks day (1-7) and press ENTER to submit it and you get name of day:");

    private final String VALUE;

    Texts(String VALUE) {
        this.VALUE = VALUE;
    }

    public String getValue() {
        return this.VALUE;
    }
}
