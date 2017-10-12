import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int cases = Integer.parseInt(reader.readLine());

        for(int i = 0; i < cases; i++) {

            int N = Integer.parseInt(reader.readLine());//number of simulated days
            int P = Integer.parseInt(reader.readLine());//number of parties
            int[] parameters = new int[P];//hartal parameters for each party
            int lostDays = 0;

            for(int j = 0; j < P; j++) {

                parameters[j] = Integer.parseInt(reader.readLine());

            }

            for(int day = 0; day < N; day++) {

                if(day % 7 == 5 || day % 7 == 6) {
                    continue;
                }

                for(int param : parameters) {

                    if((day + 1) % param == 0) {

                        lostDays++;
                        break;

                    }

                }

            }

            System.out.println(lostDays);

        }

    }

}