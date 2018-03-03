package ident;

public class ParenthesisUtils {

    public static boolean validParentheses(String value) {
        int pairCount = 0;

        for (char c : value.toCharArray()) {
            if (c == '(') {
                pairCount++;
            } else if (c == ')') {
                pairCount--;
            }

            if (pairCount < 0) {
                return false;
            }
        }

        return pairCount == 0;

    }

    public static String specialFormatter(String value) {
        if (!validParentheses(value)) {
            throw new IllegalArgumentException("Value is not valid.");
        }

        char[] charArray = value.toCharArray();
        int indexOfLastOpen = 0;
        String result = value;

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(') {
                indexOfLastOpen = i;
            } else if (c == ')') {
                String prefix = value.substring(0, indexOfLastOpen);
                String contents = value.substring(indexOfLastOpen + 1, i);
                String reversed = new StringBuilder(contents).reverse().toString();
                String postfix = value.substring(i + 1);
                result = prefix + reversed + postfix;
                return specialFormatter(result);
            }
        }

        return result;
    }



}
