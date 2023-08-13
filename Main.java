import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        int m = 4; // Number of rows
        int n = 8; // Number of columns

        char[][] array = new char[m][n];

        // Initialize the array with '*'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = '*';
            }
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.in"));
            String inputText = reader.readLine();
            reader.close();

            int index = 0;
            for (int i = 0; i < m; i++) {
                if (i % 2 == 0) { // Even numbered rows
                    for (int j = 0; j < n && index < inputText.length(); j++) {
                        if (inputText.charAt(index) != ' ') {
                            array[i][j] = inputText.charAt(index++);
                        } else {
                            j--;
                            index++;
                        }
                    }
                } else { // Odd numbered rows
                    for (int j = n - 1; j >= 0 && index < inputText.length(); j--) {
                        if (inputText.charAt(index) != ' ') {
                            array[i][j] = inputText.charAt(index++);
                        } else {
                            j++;
                            index++;
                        }
                    }
                }
            }

            StringBuilder outputText = new StringBuilder();
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    if (array[i][j] != '*') {
                        outputText.append(array[i][j]);
                    }
                }
            }

            System.out.println("Output string: \"" + outputText.toString() + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
