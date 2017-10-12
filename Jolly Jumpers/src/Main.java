//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.*;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String str;

        while((str = reader.readLine()) != null) {

            if(str.equals("")) {break;}

            String[] tmp = str.split(" ");

            if(Integer.parseInt(tmp[0]) == 0) {

                System.out.println("Not jolly");
                continue;

            }

            int[] sequence = new int[tmp.length - 1];

            for(int i = 1; i < tmp.length; i++) {
                sequence[i-1] = Integer.parseInt(tmp[i]);
            }

            boolean[] differences = new boolean[sequence.length - 1];
            for(int i = 0; i < differences.length; i++) {
                differences[i] = false;
            }

            boolean jolly = true;

            for(int i = 0; i < sequence.length - 1; i++) {

                int t = Math.abs(sequence[i+ 1] - sequence[i]) - 1;

                if(t < 0) {

                    jolly = false;
                    break;

                }

                if(t < differences.length) {
                    differences[t] = true;
                }

            }

            for(boolean a : differences) {
                if(!a) {
                    jolly = false;
                    break;
                }
            }

            if(jolly) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }

        }

    }

}
