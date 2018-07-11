package testProject;

import java.util.HashMap;
import java.util.Map;

public class Text2Digits {

    private final static String[] units = {"", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};

    private final static String[] tens = {"", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety"};

    private final static String[] scales = {"hundred", "thousand"};

    private final static Map<String, ScaleIncrement> numWords = new HashMap<>();

    static {
        numWords.put("and", testProject.ScaleIncrement.valueOf(1, 0));
        for (int i = 0; i < units.length; i++)
            numWords.put(units[i], ScaleIncrement.valueOf(1, i));

        for (int i = 0; i < tens.length; i++)
            numWords.put(tens[i], ScaleIncrement.valueOf(1, i * 10));

        for (int i = 0; i < scales.length; i++) {
            int exponent = (i * 3 == 0) ? 2 : i * 3;
            numWords.put(scales[i],
                    ScaleIncrement.valueOf((int) Math.pow(10, exponent), 0));
        }
    }

    public static int convertText(String text) throws RuntimeException {

        int current = 0;
        int result = 0;
        int lastIncrement = 0;
        for (String word : text.split(" ")) {

            if (!numWords.containsKey(word))
                throw new RuntimeException("Illegal word: " + word);

            int scale = numWords.get(word).scale;
            int increment = numWords.get(word).increment;
            if ((lastIncrement == 0 && increment == 0)) {
                throw new RuntimeException("Illegal construction: " + text);
            }
            lastIncrement = increment;
            current = current * scale + increment;
            if (scale > 100) {
                result += current;
                current = 0;
            }
        }

        return result + current;
    }
}