import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int location = 0;
    static int[] registers = new int[10];
    static  int[] ram = new int[1000];

    public static void main(String[] args) throws IOException {

        int cases = Integer.parseInt(reader.readLine());//number of cases to complete
        reader.readLine();//skip blank line

        for(int i = 0; i < cases; i++) {

            init();
            location = 0;


            int a = 0;
            String line;

            while((line = reader.readLine()) != null && !line.equals("")){
                ram[a++] = Integer.parseInt(line.trim());
            }

            int instructions = 1;

            while (interpret()) {
                instructions++;
                location++;
            }

            System.out.println(instructions);
            if (i < cases - 1) {
                System.out.println();
            }

        }

    }

    private static void init() {

        for(int i = 0; i < 10; i++) {
            registers[i] = 0;
        }
        for(int i = 0; i < 1000; i++) {
            ram[i] = 0;
        }

    }

    private static boolean interpret() {

        int command = ram[location] / 100;
        int reg = (ram[location] % 100) / 10;
        int num = ram[location] % 10;

        switch (command) {

            case 0://goto
                if(registers[num] != 0) {
                    location = registers[reg] - 1;
                }
                return true;
            case 1://halt
                return false;
            case 2://set reg to num
                registers[reg] = num;
                return true;
            case 3://set num to reg
                registers[reg] = (registers[reg] + num) % 1000;
                return true;
            case 4://mult reg by num
                registers[reg] = (registers[reg] * num) % 1000;
                return true;
            case 5://set reg to value of num
                registers[reg] = registers[num];
                return true;
            case 6://add value of num to reg
                registers[reg] = (registers[reg] + registers[num]) % 1000;
                return true;
            case 7://multiply reg by value of num
                registers[reg] = (registers[reg] * registers[num]) % 1000;
                return true;
            case 8://set reg to ram location at num's value
                registers[reg] = ram[registers[num]];
                return true;
            case 9://set the value in ram at num to value of reg
                ram[registers[num]] = registers[reg];
                return true;

        }

        return false;

    }

}
