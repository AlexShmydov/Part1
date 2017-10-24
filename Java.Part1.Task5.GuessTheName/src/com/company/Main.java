package com.company;

import Enums.Parameters;
import Enums.Texts;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Processor processor = new Processor(String.format("%s %s", Parameters.FIRST_NAME.getValue(), Parameters.SECOND_NAME.getValue()));
        processor.printMsg(Texts.WELCOME_MSG.getValue());
        processor.printMsg(Texts.RULE_MSG.getValue());
        processor.printMsg(String.format(Texts.TEMPLATE_WORDS_MSG.getValue(), processor.getHiddenWord()));
        processor.printMsg(Texts.SUBMIT_MSG.getValue());
        processor.handleInputData(scanner);
    }
}
