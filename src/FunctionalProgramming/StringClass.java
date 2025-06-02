package FunctionalProgramming;

public class StringClass {
    String value;

    public StringClass(String value) {
        this.value=value;
    }

    public static String toUpper(String str) {
        return str.toUpperCase();
    }

    public String toLower() {
        return value.toLowerCase();
    }
}
