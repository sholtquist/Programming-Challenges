import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int cases = Integer.parseInt(reader.readLine());
        String[] fragments;
        int numFrags = 0;
        int n = 0;
        int originalLength = 0;
        int ones = 0;
        int zeros = 0;
        int stars;
        reader.readLine();

        for (int i = 0; i < cases; i++) {

            fragments = new String[288];
            stars = 0;

            String str;
            int tmpTotal = 0;

            for(int j = 0; j < 288; j++) {

                if(reader.ready()) {
                    str = reader.readLine();
                } else {
                    numFrags = j;
                    originalLength = tmpTotal / (j / 2);
                    break;
                }

                if(str.equals("")) {
                    numFrags = j;
                    originalLength = tmpTotal / (j / 2);
                    break;
                }

                fragments[j] = str;
                tmpTotal += str.length();

            }
            //System.out.println("number of fragments: " + numFrags);
/*
            System.out.print("[ ");
            for(String f : fragments) {System.out.print(f + " ");}
            System.out.println("] fragments for i = " + i);*/

            n = numFrags / 2;
            int[] onesInCol = new int[originalLength];

            ones = 0;

            for (int j = 0; j < numFrags; j++) {

                char[] num = fragments[j].toCharArray();
                int fragLen = num.length;

                for(int place = 0; place < fragLen; place++) {

                    if(num[place] == '1') {
                        ones++;
                        onesInCol[place]++;
                        onesInCol[originalLength-(fragLen-place)]++;
                    }

                }

            }
            //System.out.println("Original ones value: " + ones + " / n (" + n + ") = " + (ones / n));
            ones /= n;
            zeros = originalLength - ones;
            System.out.println("one: "  + ones + " and zero: " + zeros);
            char[] output = new char[originalLength];

            ArrayList<Integer> starLocs = new ArrayList<>();

            for(int pos = 0; pos < originalLength; pos++) {

                int tmpOne = onesInCol[pos];
                int tmpZero = numFrags - tmpOne;
                //System.out.println("one: "  + tmpOne + " and zero: " + tmpZero);

                if(tmpOne > tmpZero) {
                    output[pos] = '1';
                    ones--;
                } else if (tmpZero < tmpOne) {
                    output[pos] = '0';
                    zeros--;//use remaining zero count for unsure cases
                } else {
                    output[pos] = '*';
                    starLocs.add(pos);
                    stars++;
                }

            }

            if(stars == originalLength) {
                char[] tmp = fragments[0].toCharArray();
                for(int a = 0; a < tmp.length; a++) {
                    if(tmp[a] == '0') {
                        output[a] = '0';
                        zeros--;
                    } else {
                        output[a] = '1';
                        ones--;
                    }
                }
                stars -= tmp.length;
            }//a starting point

            ArrayList<String> fragList = new ArrayList<>();
            fragList.addAll(Arrays.asList(fragments));
            System.out.print("starloc: [");
            for(Integer a : starLocs) {System.out.print(a + " ");}
            System.out.println("]");

            while(stars > 0) {

                int firstStarLeft = starLocs.get(0);

                if(ones == 0) {
                    for (int j = 0; j < output.length; j++) {
                        if (output[j] == '*') {output[j] = '0';}
                    }
                    break;
                } else if (zeros == 0) {
                    for (int j = 0; j < output.length; j++) {
                        if (output[j] == '*') {output[j] = '1';}
                    }
                    break;
                } else if (firstStarLeft != 0) {
                    char[] tmp = new char[firstStarLeft];
                    System.arraycopy(output, 0, tmp, 0, firstStarLeft);
                    String begin = new String(tmp);
                    System.out.println("BEGIN: " + begin);
                }

                stars = 0;

            }

            System.out.println(new String(output) + "\n");

        }

    }

}