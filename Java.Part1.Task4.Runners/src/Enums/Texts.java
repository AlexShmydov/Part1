package Enums;

public enum Texts {
    WELCOME_MSG("Hello!\nTask #3. Best runner."),
    BEST_RUNNER_MSG("\nThe best runner is %s with time: %s"),
    ALL_RUNNERS_SORTED_MSG("\nResult of tournament:\n"),
    TEMPLATE_RUNNER("\nRunner: %s, Time: %s"),
    RUNNER_MSG("\nRunner who finished at %s place this %s with time %s\n");

    private final String VALUE;

    Texts(String VALUE) {
        this.VALUE = VALUE;
    }

    public String getValue() {
        return this.VALUE;
    }
}
