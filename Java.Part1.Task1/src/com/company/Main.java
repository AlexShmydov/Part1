package com.company;

import Enums.Texts;
import Utils.StringHandler;
import java.util.Scanner;

public class Main{

    private static final Character CHARACTER = '*';
    private static int FROM_POSITION = 5;
    private static int TO_POSITION = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    System.out.println(Texts.WELCOME_MSG.getValue());
        String inputData = scanner.nextLine();
	    /*Reverse order*/
        StringHandler.reverseSentenceAndPrint(inputData);
        /*Split words and print it in console one by one*/
        StringHandler.splitWordsAndPrint(inputData);
        /*Replace all spaces on * and print it*/
        StringHandler.replaceSpacesAndPrint(inputData, CHARACTER);
        /*Sentence in UPPER_CASE*/
        StringHandler.changeToUpperCaseAndPrint(inputData);
        /*Cut substrings by positions*/
        StringHandler.getSubstringByPositionsAndPrint(inputData,FROM_POSITION,TO_POSITION);
    }
}
