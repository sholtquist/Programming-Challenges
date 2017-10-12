import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String str;

        int[] sequence = new int[3000];
        int[] diff = new int[2999];

        while(!(str = reader.readLine()).equals(null)) {

            int i;

            if(str.equals("")) {
                break;
            }

            String[] tmp = str.split(" ");

            int n = Integer.parseInt(tmp[0]);

            //sequence = new int[tmp.length - 1];

            for(i = 1; i < tmp.length; i++) {
                sequence[i-1] = Integer.parseInt(tmp[i]);
            }

            for(i = 1; i < n; i++ ) {
                diff[i] = 0;
            }

            for(i = 0; i < n-1; i++ )
            {
                int d = Math.abs( sequence[i]-sequence[i+1] );
                if( d < 1 || d > n-1 || diff[d] == 1 )
                {
                    System.out.println("Not jolly");
                    break;
                }
                diff[d] = 1;
            }

            if(i == n-1)
            {
                System.out.println("Jolly");
            }

        }

    }

}
