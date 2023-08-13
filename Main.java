import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        int kt_m = 4; // Number of rows
        int kt_n = 8; // Number of columns

        char[][] kt_array = new char[kt_m][kt_n];

        // Initialize the array with '*'
        for (int kt_i = 0; kt_i < kt_m; kt_i++) {
            for (int kt_j = 0; kt_j < kt_n; kt_j++) {
                kt_array[kt_i][kt_j] = '*';
            }
        }

        try {
            BufferedReader kt_reader = new BufferedReader(new FileReader("input.in"));
            String kt_inputText = kt_reader.readLine();
            kt_reader.close();

            int kt_index = 0;
            for (int kt_i = 0; kt_i < kt_m; kt_i++) {
                if (kt_i % 2 == 0) { // Even numbered rows
                    for (int kt_j = 0; kt_j < kt_n && kt_index < kt_inputText.length(); kt_j++) {
                        if (kt_inputText.charAt(kt_index) != ' ') {
                            kt_array[kt_i][kt_j] = kt_inputText.charAt(kt_index++);
                        } else {
                            kt_j--;
                            kt_index++;
                        }
                    }
                } else { // Odd numbered rows
                    for (int kt_j = kt_n - 1; kt_j >= 0 && kt_index < kt_inputText.length(); kt_j--) {
                        if (kt_inputText.charAt(kt_index) != ' ') {
                            kt_array[kt_i][kt_j] = kt_inputText.charAt(kt_index++);
                        } else {
                            kt_j++;
                            kt_index++;
                        }
                    }
                }
            }

            StringBuilder kt_outputText = new StringBuilder();
            for (int kt_j = 0; kt_j < kt_n; kt_j++) {
                for (int kt_i = 0; kt_i < kt_m; kt_i++) {
                    if (kt_array[kt_i][kt_j] != '*') {
                        kt_outputText.append(kt_array[kt_i][kt_j]);
                    }
                }
            }

            System.out.println("Output string: \"" + kt_outputText.toString() + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
