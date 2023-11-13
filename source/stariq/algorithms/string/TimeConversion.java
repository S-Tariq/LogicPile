package stariq.algorithms.string;

// https://www.hackerrank.com/challenges/time-conversion/problem
// Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
public class TimeConversion {

    public static void main(String[] args) {
        System.out.println(timeConversion("07:05:45PM"));
        System.out.println(timeConversion("06:07:23AM"));
        System.out.println(timeConversion("12:01:32PM"));
        System.out.println(timeConversion("12:01:45AM"));
    }

    public static String timeConversion(String s) {
        String converted = "";
        char amOrPm = s.charAt(s.length() - 2);
        String substring = s.substring(0, s.length() - 2);
        String num = s.substring(0, 2);
        if(amOrPm == 'P') {
            if(num.equals("12")) {
                converted = substring;
            } else {
                String number = String.valueOf(Integer.parseInt(num) + 12);
                converted = s.replaceFirst(num, number).substring(0, s.length() - 2);
            }
        } else {
            if(num.equals("12")) {
                converted = s.replaceFirst("12", "00").substring(0,s.length() - 2);
            } else {
                converted = substring;
            }
        }
        return converted;
    }
}
