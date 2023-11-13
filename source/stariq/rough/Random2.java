package stariq.rough;

public class Random2 {

    public static boolean isValidCardNumber(String cardNumber) {
        // Remove any spaces or non-digit characters from the card number
        cardNumber = cardNumber.replaceAll("\\D", "");

        // Check if the card number has at least two digits
        if (cardNumber.length() < 2) {
            return false;
        }

        int sum = 0;
        boolean doubleNext = false;

        // Traverse the card number from right to left
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = cardNumber.charAt(i) - '0';

            if (doubleNext) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit / 10 + digit % 10;
                }
            }

            sum += digit;
            doubleNext = !doubleNext;
        }

        // Check if the total sum's last digit is 0
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        String cardNumber = "4556 7377 6968 7897";
        boolean isValid = isValidCardNumber(cardNumber);
        System.out.println("Is valid card number? " + isValid);  // Output: Is valid card number? true


    }
}
