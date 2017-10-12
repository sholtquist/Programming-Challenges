import java.io.*;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String str;

        while((str = reader.readLine()) != null) {

            char[] explode = str.toCharArray();
            char[] out = new char[explode.length];

            for(int i = 0; i < explode.length; i++) {

                char c = explode[i];

                switch (c) {

                    case '1':
                        out[i] = '`';
                        break;
                    case '2':
                        out[i] = '1';
                        break;
                    case '3':
                        out[i] = '2';
                        break;
                    case '4':
                        out[i] = '3';
                        break;
                    case '5':
                        out[i] = '4';
                        break;
                    case '6':
                        out[i] = '5';
                        break;
                    case '7':
                        out[i] = '6';
                        break;
                    case '8':
                        out[i] = '7';
                        break;
                    case '9':
                        out[i] = '8';
                        break;
                    case '0':
                        out[i] = '9';
                        break;
                    case '-':
                        out[i] = '0';
                        break;
                    case '=':
                        out[i] = '-';
                        break;
                    case 'W':
                        out[i] = 'Q';
                        break;
                    case 'E':
                        out[i] = 'W';
                        break;
                    case 'R':
                        out[i] = 'E';
                        break;
                    case 'T':
                        out[i] = 'R';
                        break;
                    case 'Y':
                        out[i] = 'T';
                        break;
                    case 'U':
                        out[i] = 'Y';
                        break;
                    case 'I':
                        out[i] = 'U';
                        break;
                    case 'O':
                        out[i] = 'I';
                        break;
                    case 'P':
                        out[i] = 'O';
                        break;
                    case '[':
                        out[i] = 'P';
                        break;
                    case ']':
                        out[i] = '[';
                        break;
                    case '\\':
                        out[i] = ']';
                        break;
                    case 'S':
                        out[i] = 'A';
                        break;
                    case 'D':
                        out[i] = 'S';
                        break;
                    case 'F':
                        out[i] = 'D';
                        break;
                    case 'G':
                        out[i] = 'F';
                        break;
                    case 'H':
                        out[i] = 'G';
                        break;
                    case 'J':
                        out[i] = 'H';
                        break;
                    case 'K':
                        out[i] = 'J';
                        break;
                    case 'L':
                        out[i] = 'K';
                        break;
                    case ';':
                        out[i] = 'L';
                        break;
                    case '\'':
                        out[i] = ';';
                        break;
                    case 'X':
                        out[i] = 'Z';
                        break;
                    case 'C':
                        out[i] = 'X';
                        break;
                    case 'V':
                        out[i] = 'C';
                        break;
                    case 'B':
                        out[i] = 'V';
                        break;
                    case 'N':
                        out[i] = 'B';
                        break;
                    case 'M':
                        out[i] = 'N';
                        break;
                    case ',':
                        out[i] = 'M';
                        break;
                    case '.':
                        out[i] = ',';
                        break;
                    case '/':
                        out[i] = '.';
                        break;
                    default:
                        out[i] = c;
                        break;

                }

            }

            String output = "";
            for(char a : out) {output += a;}
            System.out.println(output);

        }

    }

}
