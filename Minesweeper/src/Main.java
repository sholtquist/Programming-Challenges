import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    static char[][] inputBoard;
    static char[][] outputBoard;
    static int field = 1;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String dims;

        while ((dims = reader.readLine()) != null){

            if(dims.equals("0 0")) {
                break;
            }

            int n = Integer.parseInt(dims.substring(0, dims.indexOf(" ")));
            int m = Integer.parseInt(dims.substring(dims.indexOf(" ")+1));

            if(n == 0 && m == 0) {
                return;
            }

            if(field > 1) {
                System.out.println();
            }

            System.out.println("Field #" + field + ":");

            inputBoard = new char[n][m];
            outputBoard = new char[n][m];

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                for (int j = 0; j < m; j++) {
                    inputBoard[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {

                    outputBoard[i][j] = (inputBoard[i][j] == '*') ?
                            '*' : (char)(neighborMines(i, j) + '0');

                }
            }

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    System.out.print(outputBoard[i][j]);
                    if (j == m - 1) {
                        System.out.println();
                    }
                }
            }

            field++;

        }

    }

    private static int neighborMines(int n, int m) {

        int result = 0;

        for(int i = n-1; i <= n+1; i++) {

            for(int j = m-1; j<=m+1; j++) {

                if ((i == n && j == m) || i < 0 || j < 0 || i >= inputBoard.length || j>= inputBoard[0].length) {
                    continue;//dont check this tile if it's the one we're centered around OR if OUT OF BOUNDS
                } else if (inputBoard[i][j] == '*') {
                    result++;
                }

            }

        }

        return result;

    }

}