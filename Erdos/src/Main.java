import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static String E = "Erdos, P.";

    public static void main(String[] args) throws IOException {

        int cases = Integer.parseInt(reader.readLine());

        for(int i = 0; i < cases; i++) {

            String[] tmp = reader.readLine().split(" ");
            int P = Integer.parseInt(tmp[0]);
            int N = Integer.parseInt(tmp[1]);
            String[] papers = new String[P];
            String[] names = new String[N];
            int[] degree = new int[N];

            for(int j = 0; j < P; j++) {
                String placeholder = reader.readLine();
                int colon = placeholder.indexOf(":");
                papers[j] = placeholder.substring(0, colon);
            }

            for(int j = 0; j < N; j++) {
                names[j] = reader.readLine();
            }

            for(int j = 0; j < N; j++) {
                degree[j] = 0;
            }

            boolean namesRemaining = true;
            while(namesRemaining) {

                int blanks = 0;
                for(int j = 0; j < P; j++) {

                    if(papers[j] == "") {
                        blanks++;
                        if(blanks == P - 1) {
                            namesRemaining = false;
                        }
                        break;
                    }

                    if(papers[j].contains(E)) {//paper with Erdos: ALL OTHER AUTHORS DEGREE 1
                        //System.out.println("CONTAINTS E: " + E);
                        //System.out.println(papers[j]);
                        String explode[] = papers[j].split(",");
                        String[] tmpNames = new String[explode.length/2];

                        for(int k = 0; k < tmpNames.length; k++) {

                            tmpNames[k] = (explode[2 * k] + "," + explode[(2 * k) + 1]).trim();

                        }

                        for(String a : tmpNames) {

                            if(a.equals(E)) {
                                continue;
                            }

                            for(int k = 0; k < N; k++) {

                                //System.out.println(names[k] + "   :   " + a);

                                if(names[k].equals(a)) {

                                    degree[k] = 1;
                                    break;

                                }

                            }

                        }

                        papers[j] = "";

                    } else if(papers[j] != "") {

                        papers[j] = "";

                    }

                }

                System.out.print("[ ");
                for(int a : degree) {
                    System.out.print(a + " ");
                }
                System.out.println("]");
                namesRemaining = false;


            }

        }

    }

}
