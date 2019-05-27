package ua.baziaka.problems;

import java.util.HashMap
import java.util.Map;

public class IntegerToRoman12 {

    static Map<Integer, String> romans;

    static {

        romans = new HashMap<>();

        romans.put(1, "I");
        romans.put(5, "V");
        romans.put(10, "X");
        romans.put(50, "L");
        romans.put(100, "C");
        romans.put(500, "D");
        romans.put(1000, "M");
    }


    public String intToRoman(int input) {

        StringBuilder output = new StringBuilder();
        int i = 1;

        while (input > 0) {
            int x = input % 10;

            if (x == 4 || x == 9) {
                output
                    .insert(0, romans.get((x + 1) * i))
                    .insert(0, romans.get(i));
            } else {
                if (x >= 5) {
                    output.insert(0, romans.get(5 * i));

                    for (int j = 0; j < x - 5; j++) {
                        output.insert(j + 1, romans.get(i));
                    }
                } else  {
                    for (int j = 0; j < x; j++) {
                        output.insert(0, romans.get(i));
                    }
                }
            }
            input /= 10;
            i *= 10;
        }
        return output.toString();
    }
}
