package com.company;

import Enums.Parameters;
import Enums.Texts;

import java.util.Scanner;

public class Processor {
    /**
     * It's word before replacing letters on symbols
     */
    private String word;

    /**
     * Word with replacing letters on symbols.
     * If user puts a letter that is present in word or whole word or full name - needed symbols will be replace
     */
    private String hiddenWord;

    public Processor(String word) {
        this.word = word;
        this.hiddenWord = replaceLettersOnSymbols(word);
    }

    /**
     * Main method to process inputting data by user.
     * Method check input data, print messages (error or positive) and stopped the game if user win.
     */
    public void handleInputData(Scanner scanner) {
        do {
            String inputData = scanner.nextLine().trim();
            /**Check that putted value is correct (i.e. putted value is a string).
             if Spaces are puts with letter it will be ignored.*/
            if (inputData.replaceAll(Parameters.DEFAULT_EXPRESSION.getValue(), "").trim().length() == 0) {
                if (inputData.length() == 1 || (inputData.split(" ").length < 2 //Check is it a letter or user putted no more two words
                        && (inputData.length() == word.split(" ")[0].length() || inputData.length() == word.split(" ")[1].length())) //Check if user putted some word and this value has length like hidden words
                        || (inputData.split(" ").length == 2 && inputData.length() == word.length())) { //Check if user putted two words this words have to have length equals full hidden words
                    String result = replaceSymbolsOnLetters(inputData);
                    if (result != null) {
                        if (getCountOfLostLettersInHiddenWord() == 0) {//check that the hiddenword don't have symbols. If that - user wins
                            printMsg(String.format(Texts.WINNER_MSG.getValue(), hiddenWord));
                            break;
                        } else {
                            if (!result.equals(Parameters.ALREADY_EXIST.getValue())) { //print message if user putted some right value
                                printMsg(Texts.MATCHES_FOUND_MSG.getValue());
                                printMsg(String.format(Texts.TEMPLATE_WORDS_MSG.getValue(), hiddenWord));
                                printMsg(Texts.SUBMIT_MSG.getValue());
                            } else {
                                /**print messages if user putted value that hiddenword contains*/
                                printMsg(Texts.ALREADY_EXIST_MSG.getValue());
                            }
                        }
                    } else {
                        /**Print message if user putted no matches value*/
                        printMsg(Texts.NOT_MATCHES_FOUND_MSG.getValue());
                    }
                } else {
                    /**Print message if user putted a value that it does not satisfy the conditions*/
                    printMsg(Texts.ERROR_NO_CONDITIONAL_DATA_MSG.getValue());
                }
            } else {
                /**Print message if user putted a value that is not valid (no string)*/
                printMsg(Texts.ERROR_NON_LETTERS_MSG.getValue());
            }
        } while (true);
    }

    /**
     * Use this method to check input string for containing in searching word.
     * Method checks if it is a letter or whole word, and replace symbols on letters if user putted letter/letters
     * which contains in the word.
     *
     * @param inputData - putted value by user to check
     * @return the next value:
     * null - if not matched found,
     * hiddenWord - if matches found,
     * value from parameters - if user putted value that was putted before and hiddenword contains it.
     */
    private String replaceSymbolsOnLetters(String inputData) {
        if (!isContainsSubstringWithIgnoreCase(hiddenWord, inputData)) {
            if (inputData.length() == 1 && isContainsSubstringWithIgnoreCase(word, inputData)) {
                char[] letters = word.toCharArray();
                for (int i = 0; i < letters.length; i++) {
                    if (inputData.compareToIgnoreCase(letters[i] + "") == 0) {
                        char[] temp = hiddenWord.toCharArray();
                        temp[i] = letters[i];
                        hiddenWord = convertCharArrayToString(temp);
                    }
                }
                return hiddenWord;
            } else {
                if (isContainsSubstringWithIgnoreCase(word, inputData)) {
                    String[] tempHiddenWordArray = hiddenWord.split(" ");
                    String[] tempWordArray = word.split(" ");
                    int counter = 0;
                    for (String tempString : tempWordArray) {
                        if (tempString.compareToIgnoreCase(inputData) == 0) {
                            tempHiddenWordArray[counter] = tempString;
                        }
                        counter++;
                    }
                    hiddenWord = String.format("%s %s", tempHiddenWordArray[0], tempHiddenWordArray[1]);
                    return hiddenWord;
                }
            }
            return null;
        }
        return Parameters.ALREADY_EXIST.getValue();
    }

    /**
     * Method to help replace letter in word on symbol (value of symbol can be set in the Parameters enum
     *
     * @param inputData - any string to replace all letters on symbol
     * @return string with only symbols
     */
    private String replaceLettersOnSymbols(String inputData) {
        return inputData.replaceAll(Parameters.DEFAULT_EXPRESSION.getValue(), Parameters.DEFAULT_SYMBOL.getValue());
    }

    /**
     * Method to check that string contains some substring, but method ignores case.
     *
     * @param string     - string in which you want to know does it contain a substring
     * @param subsString - searching substring
     * @return true/false in accord with result of searching
     */
    private boolean isContainsSubstringWithIgnoreCase(String string, String subsString) {
        return string.matches(String.format(Parameters.DEFAULT_PATTER_IGNORE_CASE.getValue(), subsString));
    }

    /**
     * Helper method to convert char array to string
     *
     * @param array - array that need to convert
     * @return string that consists of characters from input array
     */
    private String convertCharArrayToString(char[] array) {
        String result = "";
        for (char character : array) {
            result += character;
        }
        return result;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    /**
     * Method to return count of symbols in the hidden word
     */
    private int getCountOfLostLettersInHiddenWord() {
        int counter = 0;
        for (Character temp : hiddenWord.toCharArray()) {
            if (temp.equals(Parameters.DEFAULT_SYMBOL.getValue().toCharArray()[0])) {
                counter++;
            }
        }
        return counter;
    }

    public void printMsg(String message) {
        System.out.println(message);
    }
}