package com.company;

import Enums.Parameters;
import Enums.Texts;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Processor processor = new Processor(String.format("%s %s",Parameters.FIRST_NAME.getValue(),Parameters.SECOND_NAME.getValue()));
        printMsg(Texts.WELCOME_MSG.getValue());
        printMsg(Texts.RULE_MSG.getValue());
        printMsg(String.format(Texts.TEMPLATE_WORDS_MSG.getValue(),processor.getHiddenWord()));
        printMsg(Texts.SUBMIT_MSG.getValue());

        processor.handleInputData(scanner);
    }

    private static void printMsg(String message){
        System.out.println(message);
    }
}
