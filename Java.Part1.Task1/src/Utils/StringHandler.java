package Utils;

import Enums.Texts;

import java.util.ArrayList;
import java.util.Collections;

public class StringHandler {

    public static void reverseSentenceAndPrint(String inputData) {
        ArrayList<Character> chars = new ArrayList<Character>();
        for (Character c : inputData.toCharArray()) {
            chars.add(c);
        }
        Collections.reverse(chars);
        String result = "";
        for (Character c : chars) {
            result += c;
        }
        System.out.println(Texts.REVERSE_ORDER_MSG.getValue());
        System.out.println(result);
    }

    public static void splitWordsAndPrint(String inputData) {
        System.out.println(Texts.SPLITED_WORDS_MSG.getValue());
        for (String word : inputData.split("\\s+")) {
            System.out.println(word);
        }
    }

    public static void replaceSpacesAndPrint(String inputData, char character) {
        System.out.println(String.format(Texts.REPLACED_SPACES_MSG.getValue(), character));
        System.out.println(inputData.replaceAll("\\s", String.valueOf(character)));
    }

    public static void changeToUpperCaseAndPrint(String inputData){
        System.out.println(Texts.UPPER_CASE_MSG.getValue());
        System.out.println(inputData.toUpperCase());
    }

    public static void  getSubstringByPositionsAndPrint(String inputData, int from, int to){
        System.out.println(Texts.SUBSTRING_MSG.getValue());
        System.out.println(inputData.substring(from,to));
    }
}
