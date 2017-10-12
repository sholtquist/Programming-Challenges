import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        reader.mark(1);

        do {

            reader.reset();

            String in;
            while ((in = reader.readLine()) != null) {
                if(in.length() > 0) {
                    break;
                } else if(in.equals("0")) {
                    break;
                }
            }

            int students = Integer.parseInt(in.replace(" ", ""));

            if(students == 0) {return;}
            int[] spent = new int[students];
            int total = 0;

            for(int i = 0; i < students; i++) {

                int a = Math.round(Float.parseFloat(reader.readLine()) * 100);//get the amount spent by each student in total cents
                total += a;
                spent[i] = a;

            }

            int avg = (int)Math.round((double) total / students);
            int distribution = 0;
            int given = 0;
            int received = 0;

            for(int a : spent) {

                int diff = a - avg;

                if(diff > 0) {
                    received += diff;
                } else {
                    given -= diff;
                }

            }

            distribution = received < given ? received : given;

            System.out.print("$" + distribution / 100 + ".");
            if(distribution % 100 < 10) {
                System.out.print("0");
            }
            System.out.println(distribution % 100);

            reader.mark(6);

        } while (true);

    }

}
