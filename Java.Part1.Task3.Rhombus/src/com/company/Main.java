package com.company;

import Enums.Texts;
import Utils.RhombusFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Texts.WELCOME_MSG.getValue());
        String inputData = scanner.nextLine();

        int length = Integer.parseInt(inputData);
        RhombusFactory.drawRhombus(length);

    }
}
