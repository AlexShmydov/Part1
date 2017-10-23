package Enums;

public enum Texts {
    WELCOME_MSG("Hello!\nTask #5. Guess the name.\n"),
    RULE_MSG("You can put ONE letter or whole ONE word or full name: First and Second name separated by space.\n"),
    TEMPLATE_WORDS_MSG("See the hidden name:%s."),
    SUBMIT_MSG("Try to submit something.\n"),
    WINNER_MSG("Congratulations! You are right! The name is %s"),
    ERROR_NON_LETTERS_MSG("\nSorry!Your input value is not valid. Try again.\n"),
    ERROR_NO_CONDITIONAL_DATA_MSG("\nSorry!Your input value is not letter or whole word or full name. Try again.\n"),
    NOT_MATCHES_FOUND_MSG("\nSorry!But you are wrong!Your input data are not contained in the hidden word. Try again\n"),
    MATCHES_FOUND_MSG("\nGreat!Your input data are contained in the hidden word. Continue to win!"),
    ALREADY_EXIST_MSG("\nSorry! You have entered this value before. Try again!\n");

    private final String VALUE;

    Texts(String VALUE) {
        this.VALUE = VALUE;
    }

    public String getValue() {
        return this.VALUE;
    }
}
