package com.company;

import Enums.Parameters;
import Enums.Texts;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Texts.WELCOME_MSG.getValue());
        System.out.println(Texts.SUBMIT_MSG.getValue());

        int dayNumber = Integer.parseInt(scanner.nextLine());

        System.out.println();
        System.out.println(Parameters.WEEK.getValue().get(dayNumber));
    }
}
