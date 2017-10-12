import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[][] rolls = new int[13][5];
    static int[] scoreCard = new int[13];
    static int bonus = 0;

    public static void main(String[] args) throws IOException {

        String str;

        while((str = reader.readLine()) != null) {

            if(str == "") {
                break;
            }

            for(int i = 0; i < 13; i++) {

                String[] explode = str.split(" ");

                for(int j = 0; j < 5; j++) {
                    rolls[i][j] = Integer.parseInt(explode[j]);
                }

                if(i  < 12) {
                    str = reader.readLine();
                }

            }//read the current game into rolls



        }

    }

    static void assign(int[] round) {

        //five of a kind
        //full house
        //long straight
        //short straight
        //three of a kind
        //four of a kind
        //CHECK TOTALS OF FACES - CHANCE OR #s
        //[0 ones, 1 twos, 2 threes, 3 fours, 4 fives, 5 sixes, 6 chance, 7 3OK, 8 4OK, 9 5OK, 10 short, 11 long, 12 full]
        
        if()

    }
    
    static int[] countOccurences(int[] round) {
    
        int[] occur = new int[6];
        
        for(int a : round) {
        
            occur[a - 1]++;
        
        }
    
    }
    
    static boolean fiveOfAKind(int[] round) {
    
        int a = round[0];
        
        for(int i = 1; i < 5; i ++) {
        
            if (round[i] != a) {return false;}
            
        }
        
        return true;
    
    }
    
    static boolean fullHouse(int[] round) {
    
        boolean two = false;
        boolean three = false;
        
        for(int o : countOccurences(round)) {
        
            if (o == 2) {
                two = true;
            } else if(o == 3) {
                three = true;
            }
        
        }
    
        return two && three;
        
    }
    
    static boolean longStraight(int[] round) {
    
        int[] occur = countOccurrences(round);
        
        return (occur[1] > 0 && occur[2] > 0 && occur[3] > 0 && occur && (occur[0] > 0 || occur[5] > 0));
    
    }
    
    static boolean shortStraight(int[] round) {
    
        int[] occur = countOccurrences(round);
        //HAS to include 3, 4 (occur[2], occur[3])
        return(occur[2] > 0 && occur[3] > 0 && ((occur[0] > 0 && occur[1] > 0) || (occur[1] > 0 && occur[4] > 0) || (occur[4] > 0 && occur[5] > 0)));
    
    }
    
    static boolean three(int[] round) {
    
        int[] occur = countOccurrences(round);
        
        for(int a : occur) {
        
            if(a > 2) {
                return 3;
            }
        
        }
    
    }
    
    static boolean four(int[] round) {
    
        int[] occur = countOccurrences(round);
        
        for(int a : occur) {
        
            if(a > 3) {
                return 3;
            }
        
        }
    
    }
    
    public int chance(int[] round) {
    
        int a = 0;
        
        for(int val : round) {
            a += val;
        }
        
        return a;
    
    }
    
    public int ones(int[] round) {
    
        int a = 0;
        
        for(int val : round) {
            if(val == 1) {
                a += 1;
            }
        }
        
        return a;
    
    }
    
    public int twos(int[] round) {
    
        int a = 0;
        
        for(int val : round) {
            if(val == 2) {
                a += 2;
            }
        }
        
        return a;
    
    }
    
    public int threes(int[] round) {
    
        int a = 0;
        
        for(int val : round) {
            if(val == 3) {
                a += 3;
            }
        }
        
        return a;
    
    }
    
    public int fours(int[] round) {
    
        int a = 0;
        
        for(int val : round) {
            if(val == 4) {
                a += 4;
            }
        }
        
        return a;
    
    }
    
    public int fives(int[] round) {
    
        int a = 0;
        
        for(int val : round) {
            if(val == 5) {
                a += 5;
            }
        }
        
        return a;
    
    }
    
    public int sixes(int[] round) {
    
        int a = 0;
        
        for(int val : round) {
            if(val == 6) {
                a += 6;
            }
        }
        
        return a;
    
    }

}
