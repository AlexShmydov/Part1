package Enums;

public enum Texts {
    WELCOME_MSG("Hello!\nTask #1.\nPut any sentences and press ENTER to submit it."),
    REVERSE_ORDER_MSG("\nYour sentence in reverse order:\n"),
    SPLITED_WORDS_MSG("\nYour splitted sentence:\n"),
    REPLACED_SPACES_MSG("\nAll spaces in your sentence were replaced on '%s' char:\n"),
    UPPER_CASE_MSG("\nYour sentence in UPPER_CASE:\n"),
    SUBSTRING_MSG("\nSubstring of your sentence:\n");

    private final String value;

    Texts(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
