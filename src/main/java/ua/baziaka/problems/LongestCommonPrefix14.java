package ua.baziaka.problems;

public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 1) {
            return strings[0];
        }
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < strings[0].length(); i++) {
            char c1 = strings[0].charAt(i);
            boolean toAdd = true;
            for (int j = 1; j < strings.length; j++) {
                if (i < strings[j].length()) {
                    char c2 = strings[j].charAt(i);
                    if (c1 != c2) {
                        toAdd = false;
                        break;
                    }
                } else {
                    toAdd = false;
                    break;
                }
            }
            if (toAdd) {
                prefix.append(c1);
            } else {
                break;
            }
        }
        return prefix.toString();
    }
}
