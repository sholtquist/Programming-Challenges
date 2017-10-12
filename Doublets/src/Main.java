import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static String[] tmpDict;
    static String[] dict;
    static int dictLen = 0;

    public static void main(String[] args) throws IOException {

        tmpDict = new  String[25143];

        String str;
        for(int i = 0; i < 25143; i++) {//fill the dictionary

            str = reader.readLine();

            if(str.equals("")) {
                dictLen = i;
                break;
            } else if (i == 25142) {
                dictLen = 25143;
            }

            tmpDict[i] = str;

        }

        dict = new String[dictLen];

        System.arraycopy(tmpDict, 0, dict, 0, dictLen);

        while(!(str = reader.readLine()).equals("")) {

            String first = str.split(" ")[0];//first word
            String second = str.split(" ")[1];//second word

            int firstLen = first.length();
            int secondLen = second.length();

            if(firstLen != secondLen) {
                System.out.println("No solution.\n");
                continue;
            } else if (first.equals(second)) {//can't make a sequence differing one letter at a time if diff lengths
                System.out.println(first);
                System.out.println(second);
            }
            Arrays.sort(dict);//sort the dictionary lexicographically

            char[] firstArr = first.toCharArray();
            char[] secondArr = second.toCharArray();

            ArrayList<String> path = new ArrayList<String>();//the path we take from the first word to the second
            path.add(first);//start with the first word

            ArrayList<Integer> differences = new ArrayList<Integer>();
            for (int i = 0; i < firstLen; i++) {
                if(firstArr[i] != secondArr[i]) {//spot where the strings are different
                    differences.add(i);//yay for auto-boxing!
                }
            }

            String current = first;//what we start with
            int testLoc = 0;
            while(differences.size() > 0) {

                int diff = differences.get(testLoc);
                String lookingFor = current.substring(0, diff + 1) + secondArr[testLoc];//what to look for

                for(String dictMatch : dict) {

                    if(dictMatch.substring(0, lookingFor.length()).equals(lookingFor)) {//if what we look for is the beginning
                        current = dictMatch;//work on the new word
                        path.add(current);//add the new word to the path
                        differences.remove(testLoc);//don't keep testing!
                        break;
                    }

                }

                testLoc = testLoc + 1 < differences.size() ? testLoc + 1 : 0;//check the next spot or loop around

            }

            path.add(second);

            for (String a : path) {
                System.out.println(a);
            }

        }

    }

}
