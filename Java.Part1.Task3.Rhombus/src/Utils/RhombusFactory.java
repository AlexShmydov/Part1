package Utils;

import Enums.Settings;

public class RhombusFactory {

    public static void drawRhombus(int length) {
        int rowLength = length * 2 - 1;
        int cursor = length - 1;
        int counter = 0;

        for (int i = 0; i < rowLength; i++) {
            char[] row = generateCharArray(rowLength, Settings.DEFAULT_SYMBOL.getValue());
            if (i == rowLength - 1 || i == 0) {
                row[length - 1] = Settings.RHOMBUS_SYMBOL.getValue();
            } else {
                if (cursor - i < 0) {
                    counter++;
                }
                row[cursor - i + counter * 2] = Settings.RHOMBUS_SYMBOL.getValue();
                row[cursor + i - counter * 2] = Settings.RHOMBUS_SYMBOL.getValue();
            }
            printRow(row);
        }
    }

    private static char[] generateCharArray(int length, char defaultValue) {
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = defaultValue;
        }
        return result;
    }

    private static void printRow(char[] row) {
        String result = "";
        for (char character : row) {
            result += character;
        }
        System.out.println(result);
    }
}
