import java.util.Stack;
import static org.junit.jupiter.api.Assertions.*;

public class Main {

    public static boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    private static String buildString(String str) {
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                builder.append(c);
            } else if (builder.length() > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s1 = "xy#z";
        String s2 = "xzz#";
        boolean result = backspaceCompare(s1, s2);
        System.out.println(result); // Expected to print true
    }
}
