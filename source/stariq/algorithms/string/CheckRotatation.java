package stariq.algorithms.string;

// Check if the second string is the rotated string of the first string.
// Rotates the string
public class CheckRotatation {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString2("abcde", "cdeab"));
    }

    public static boolean rotateString(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }
        for(int i = 0; i < a.length(); i++) {
            StringBuilder sb = new StringBuilder();
            if(!a.equals(b)) {
                for(int j = 1; j < a.length(); j++) {
                    sb.append(a.charAt(j));
                }
                sb.append(a.charAt(0));
                a = sb.toString();
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean rotateString2(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }
        String combined = a + a;
        for(int i = 0; i < combined.length() - b.length(); i++) {
            String sub = combined.substring(i, i + b.length());
            if(sub.equals(b)) {
                return true;
            }
        }

        return false;
    }
}
