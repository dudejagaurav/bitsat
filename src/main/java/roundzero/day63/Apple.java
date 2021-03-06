package day63;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;


/**
 * Created by Gaurav on 02/04/18.
 */


public class Apple {

    static class FastInputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public FastInputReader(InputStream stream) {
            this.stream = stream;
        }

        public FastInputReader() {
            this(System.in);
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c))
                    res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;

        }

        public char[] readCharArray(int size) {
            char[] array = new char[size];
            for (int i = 0; i < size; i++)
                array[i] = readCharacter();
            return array;
        }

        public int[][] readTable(int rowCount,
                                 int columnCount) {
            int[][] table = new int[rowCount][columnCount];
            for (int i = 0; i < rowCount; i++)
                table[i] = readIntArray(columnCount);
            return table;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }


        public static class MiscUtils {
            public static final int[] DX4 = {1, 0, -1, 0};
            public static final int[] DY4 = {0, -1, 0, 1};

            public static boolean isValidCell(int row, int column, int rowCount,
                                              int columnCount) {
                return row >= 0 && row < rowCount && column >= 0
                        && column < columnCount;
            }

            public static int min(int a, int b) {
                return a < b ? a : b;
            }

            public static long min(long a, long b) {
                return a < b ? a : b;
            }

            public static int max(int a, int b) {
                return a > b ? a : b;
            }


            public static long max(long a, long b) {
                return a > b ? a : b;
            }
        }
    }

    public static void main(String[] args) {


        FastInputReader fastInputReader = new FastInputReader();
        int T = fastInputReader.readInt();

        int[] ip = fastInputReader.readIntArray(T);

        System.out.println(solution(ip, T));
    }
    private static long solution(int[] ip, int t) {
        long max =  Integer.MIN_VALUE;
        long min =  Integer.MAX_VALUE;
        Arrays.sort(ip);

        int total = 0;
        for (int i = ip.length-1; i >0; i--) {
            total+=  ip[i]-ip[i-1];

        }

        return total;
    }


}
