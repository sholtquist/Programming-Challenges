import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board = new char[8][8];
    static int game = 1;

    public static void main(String[] args) throws IOException {

        /*
        black
        . . . .
        . . . .
        . . . .
        . . . .
        WHITE
         */

        while(true) {

            for(int i = 0; i < 8; i++) {

                String line = reader.readLine();
                board[i] = line.toCharArray();

            }

            int wki = -1;
            int wkj = -1;
            int bki = -1;
            int bkj = -1;
            boolean whiteCheck = false;
            boolean blackCheck = false;

            for(int i = 0; i < 8; i++) {

                for(int j = 0; j < 8; j++) {

                    if(board[i][j] == 'K') {
                        wki = i;
                        wkj = j;
                    } else if(board[i][j] == 'k') {
                        bki = i;
                        bkj = j;
                    }

                }

            }

            if(wki == -1) {return;}//no kings on board = empty board = END OF INPUT

            //check for pawns

            if(pawn(bki, bkj)) {//black king in check by a pawn
                blackCheck = true;
            } else if(pawn(wki, wkj)) {//White king in check by a pawn
                whiteCheck = true;
            }

            //check straight lines for rooks/queens

            if(RQ(bki, bkj, 'R', 'Q')) {//black king in check by a rook or a queen
                blackCheck = true;
            } else if(RQ(wki, wkj, 'r', 'q')) {//White king in check by a rook or a queen
                whiteCheck = true;
            }

            //check diagonals for bishops/queens

            if(BQ(bki, bkj, 'B', 'Q')) {//black king in check by a bishop or a queen
                blackCheck = true;
            } else if(BQ(wki, wkj, 'b', 'q')) {//White king in check by a bishop or a queen
                whiteCheck = true;
            }

            //check 8 Ls for knights

            if(knight(wki, wkj, 'n')) {//WHITE
                whiteCheck = true;
            } else if (knight(bki, bkj, 'N')) {//black
                blackCheck = true;
            }

            //ALL CHECKS DONE - report, prepare for next

            if(whiteCheck) {
                System.out.println("Game #" + game + ": white king is in check.");
            } else if(blackCheck) {
                System.out.println("Game #" + game + ": black king is in check.");
            } else {
                System.out.println("Game #" + game + ": no king is in check.");
            }

            game++;
            reader.readLine();

        }

    }

    private static boolean pawn(int ki, int kj){

        char pawn = ' ';

        if(board[ki][kj] == 'K')
        {
            ki--;
            pawn = 'p';
        }
        else if(board[ki][kj] == 'k')
        {
            ki++;
            pawn = 'P';
        }

        int right = kj + 1;
        int left = kj - 1;
        if(ki < 8 && ki >=0 && ((right < 8 && board[ki][right] == pawn) || (left >=0 && board[ki][left] == pawn))) {
            return true;
        }

        return false;
    }

    private static boolean RQ(int ki, int kj, char rook, char queen){
        int row = ki;
        int col = kj;

        for(int row1 = row - 1; row1 >= 0; row1--){
            char c = board[row1][col];

            if(c != '.'){
                if(c == rook || c == queen) {
                    return true;
                } else {
                    break;
                }
            }
        }

        for(int row2 = row + 1; row2 < 8; row2++){
            char c = board[row2][col];

            if(c != '.'){
                if(c == rook || c == queen) {
                    return true;
                } else {
                    break;
                }
            }
        }

        for(int col1 = col - 1; col1 >=0; col1--){
            char c = board[row][col1];

            if(c != '.'){
                if(c == rook || c == queen) {
                    return true;
                } else {
                    break;
                }
            }
        }

        for(int col2 = col + 1; col2 < 8; col2++){
            char c = board[row][col2];

            if(c != '.'){
                if(c == rook || c == queen) {
                    return true;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    private static boolean BQ(int ki, int kj, char bishop, char queen){
        int row = ki;
        int col = kj;

        int col1 = col + 1, row1 = row - 1;
        while(col1 < 8 && row1 >= 0){

            char piece = board[row1][col1];

            if(piece != '.'){
                if(piece == bishop || piece == queen) {
                    return true;
                } else {
                    break;
                }
            }

            col1++;
            row1--;
        }

        int col2 = col - 1, row2 = row + 1;
        while(col2 >= 0 && row2 < 8){

            char piece = board[row2][col2];

            if(piece != '.'){
                if(piece == bishop || piece == queen) {
                    return true;
                } else {
                    break;
                }
            }

            col2--;
            row2++;
        }

        int col3 = col + 1, row3 = row + 1;
        while(col3 < 8 && row3 < 8){

            char piece = board[row3][col3];

            if(piece != '.'){
                if(piece == bishop || piece == queen) {
                    return true;
                } else {
                    break;
                }
            }

            col3++;
            row3++;
        }

        int col4 = col - 1, row4 = row - 1;
        while(col4 >= 0 && row4 >= 0){

            char piece = board[row4][col4];

            if(piece != '.'){
                if(piece == bishop || piece == queen) {
                    return true;
                } else {
                    break;
                }
            }

            col4--;
            row4--;
        }

        return false;
    }

    private static boolean knight(int ki, int kj, char knight) {

        int row1 = ki - 2;
        int row2 = ki - 1;
        int row3 = ki + 1;
        int row4 = ki + 2;

        int col1 = kj - 2;
        int col2 = kj - 1;
        int col3 = kj + 1;
        int col4 = kj + 2;

        if(row1 >= 0){
            if(col2 >= 0 && board[row1][col2] == knight)
                return true;
            if(col3 < 8 && board[row1][col3] == knight)
                return true;
        }

        if(row2 >= 0){
            if(col1 >= 0 && board[row2][col1] == knight)
                return true;
            if(col4 < 8 && board[row2][col4] == knight)
                return true;
        }

        if(row3 < 8){
            if(col1 >= 0 && board[row3][col1] == knight)
                return true;
            if(col4 < 8 && board[row3][col4] == knight)
                return true;
        }

        if(row4 < 8){
            if(col2 >= 0 && board[row4][col2] == knight)
                return true;
            if(col3 < 8 && board[row4][col3] == knight)
                return true;
        }

        return false;

    }

}