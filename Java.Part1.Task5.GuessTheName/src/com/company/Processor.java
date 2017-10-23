package com.company;

import Enums.Parameters;
import Enums.Texts;

import java.util.Scanner;

public class Processor {
    private String word;
    private String hiddenWord;

    public Processor(String word) {
        this.word = word;
        this.hiddenWord = replaceLettersOnSymbols(word);
    }

    public void handleInputData(Scanner scanner) {
        do {
            String inputData = scanner.nextLine().trim();
            if (inputData.replaceAll(Parameters.DEFAULT_EXPRESSION.getValue(), "").trim().length() == 0) {
                if (inputData.length() == 1
                        || (inputData.split(" ").length < 2
                        && (inputData.length() == word.split(" ")[0].length() || inputData.length() == word.split(" ")[1].length()))
                        || (inputData.split(" ").length == 2 && inputData.length() == word.length())) {
                    String result = replaceSymbolsOnLetters(inputData);
                    if (result != null) {
                        if (getCountOfLostLettersInHiddenWord() == 0) {
                            printMsg(String.format(Texts.WINNER_MSG.getValue(),hiddenWord));
                            break;
                        } else {
                            if (!result.equals(Parameters.ALREADY_EXIST.getValue())) {
                                printMsg(Texts.MATCHES_FOUND_MSG.getValue());
                                printMsg(String.format(Texts.TEMPLATE_WORDS_MSG.getValue(), hiddenWord));
                                printMsg(Texts.SUBMIT_MSG.getValue());
                            } else {
                                printMsg(Texts.ALREADY_EXIST_MSG.getValue());
                            }
                        }
                    } else {
                        printMsg(Texts.NOT_MATCHES_FOUND_MSG.getValue());
                    }
                } else {
                    printMsg(Texts.ERROR_NO_CONDITIONAL_DATA_MSG.getValue());
                }
            } else {
                printMsg(Texts.ERROR_NON_LETTERS_MSG.getValue());
            }
        } while (true);
    }

    private String replaceSymbolsOnLetters(String inputData) {
        if (!hiddenWord.contains(inputData)) {
            if (inputData.length() == 1 && word.contains(inputData)) {
                char[] letters = word.toCharArray();
                for (int i = 0; i < letters.length; i++) {
                    if (inputData.equals(letters[i] + "")) {
                        char[] temp = hiddenWord.toCharArray();
                        temp[i] = letters[i];
                        hiddenWord = convertCharArrayToString(temp);
                    }
                }
                return hiddenWord;
            } else {
                if (word.contains(inputData)) {
                    String[] tempHiddenWordArray = hiddenWord.split(" ");
                    String[] tempWordArray = word.split(" ");
                    int counter = 0;
                    for (String tempString : tempWordArray) {
                        if (tempString.equals(inputData)) {
                            tempHiddenWordArray[counter] = inputData;
                        }
                        counter++;
                    }

                    hiddenWord = String.format("%s %s",tempHiddenWordArray[0],tempHiddenWordArray[1]);
                    //hiddenWord = String.format("%s %s", inputData, replaceLettersOnSymbols(convertCharArrayToString(word.replace(inputData, "").trim().toCharArray())));
                    return hiddenWord;
                }
            }
            return null;
        }
        return Parameters.ALREADY_EXIST.getValue();
    }

    private String replaceLettersOnSymbols(String inputData) {
        return inputData.replaceAll(Parameters.DEFAULT_EXPRESSION.getValue(), Parameters.DEFAULT_SYMBOL.getValue());
    }


    private String convertCharArrayToString(char[] array) {
        String result = "";
        for (char character : array) {
            result += character;
        }
        return result;
    }

    public String getWord() {
        return word;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

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
