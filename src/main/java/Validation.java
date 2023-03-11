public class Validation {

    public static int isValid(String s) {
        if (s.charAt(0) == '*' || s.charAt(0) == '^') return 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (i + 1 < s.length() && s.charAt(i) == '*' && s.charAt(i + 1) != 'x') return 0;
            if (i - 1 >= 0 && s.charAt(i) == '*' && !Character.isDigit(s.charAt(i - 1))) return 0;
            if (i - 1 >= 0 && s.charAt(i) == '^' && s.charAt(i - 1) != 'x') return 0;
            if (i + 1 < s.length() && s.charAt(i) == '^' && !Character.isDigit(s.charAt(i + 1))) return 0;
            if (i + 1 < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-') && (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-'))
                return 0;
            if (i + 1 < s.length() && s.charAt(i) == 'x' && !(s.charAt(i + 1) == '^' || s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-'))
                return 0;
            if (i - 1 >= 0 && s.charAt(i) == 'x' && !(s.charAt(i - 1) == '*' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-'))
                return 0;
            if (i + 1 < s.length() && Character.isDigit(s.charAt(i)) && !(s.charAt(i + 1) == '*' || s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-' || Character.isDigit(s.charAt(i + 1))))
                return 0;
        }
        return 1;
    }
}
