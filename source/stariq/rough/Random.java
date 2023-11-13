package stariq.rough;

import java.util.List;

public class Random {


    private static final List<Character> COLUMNS = List.of('a', 'b');

    public static String movePawn(String startingSquare, int R, int C) {
        // Parse the starting square
        int startRow = Character.getNumericValue(startingSquare.charAt(0));
        char startColumn = startingSquare.charAt(1);

        // Calculate the new row after moving R rows (loop around if needed)
        int newRow = ((startRow - 1 + R) % 8) + 1;

        // Calculate the new column after moving C columns (loop around if needed)
        int startColumnIndex = COLUMNS.indexOf(startColumn);
        int newColumnIndex = (startColumnIndex + C) % COLUMNS.size();
        if (newColumnIndex < 0) {
            newColumnIndex += COLUMNS.size();
        }
        char newColumn = COLUMNS.get(newColumnIndex);

        // Combine the row and column to get the final end square
        String endSquare = newRow + "" + newColumn;

        return endSquare;
    }

    public static void main(String[] args) {
        String startingSquare = "2c";
        int R = 3;
        int C = 2;
        String endSquare = movePawn(startingSquare, R, C);
        System.out.println("End Square: " + endSquare);  // Output: End Square: 5e
    }
}
