package mathemetics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author (Qey_coder) on 3/6/18
 **/
//https://www.hackerrank.com/challenges/maximum-draws/problem
public class MaximumDraw {
    /*
     * Complete the maximumDraws function below.
     */
    static int maximumDraws(int n) {
        return n+1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = maximumDraws(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }


        bufferedWriter.close();
    }
}
