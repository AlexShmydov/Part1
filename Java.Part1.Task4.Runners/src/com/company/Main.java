package com.company;

public class Main {

    private static final String[] NAMES = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
    private static final int[] TIME = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
    private static int DEFAULT_PLACE = 2;

    public static void main(String[] args) {
        System.out.println(Texts.WELCOME_MSG.getValue());
        /*Create instance of tournament and override by input data*/
        TournamentProcessor tournamentProcessor = new TournamentProcessor(NAMES,TIME);
        /*Call method to print all information about results*/
        tournamentProcessor.printResultsOfTournament();
        /*Print name of best runner*/
        tournamentProcessor.printBestRunner();
        /*Print name of runner which has inputting place in the tournament*/
        tournamentProcessor.printRunnerByPlace(DEFAULT_PLACE);
    }

}
