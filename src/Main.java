import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] ch_line;
        char[] ch_linea = new char[10];
        char[] ch_lineb = new char[10];
        char[] ch_linex = new char[10];
        char[] ch_liney = new char[10];
        int c = -1;
        int ci = 0;
        int z = 0;
        int result = 0;
        ch_line = line.toCharArray();
        //////////////////////проверка ввода////////////////////////////////////////////////////////////////
        for (int i = 0; i < ch_line.length; i++) { // проверка ввода
            if (!(ch_line[i] >= 48 && ch_line[i] <= 57) && ch_line[i] != 'I' && ch_line[i] != 'V' && ch_line[i] != 'X' && ch_line[i] != '-' && ch_line[i] != '+' && ch_line[i] != '*' && ch_line[i] != '/') {// проверка ввода
                throw new IOException();// проверка ввода
            }// проверка ввода
            if (ch_line[0] == 48) {// проверка ввода
                throw new IOException();// проверка ввода
            }// проверка ввода
        }
        //////////////////////проверка и заполнение массива для первого арабского числа//////////////////////////////////////////////////////////////////////////
        if (ch_line[0] >= 49 && ch_line[0] <= 57) {
            z = 1;
            for (int i = 0; i < ch_line.length; i++) {
                if (ch_line[i] >= 48 && ch_line[i] <= 57) {
                    ch_linea[i] = ch_line[i];

                    //break;
                } else break;

            }
        }
        //////////////////////проверка и заполнение массива для первого римского числа////////////////////////////////
        if (ch_line[0] == 'I' || ch_line[0] == 'V' || ch_line[0] == 'X') {
            z = 2;
            for (int i = 0; i < ch_line.length; i++) {
                if (ch_line[i] == 'I' || ch_line[i] == 'V' || ch_line[i] == 'X') {
                    ch_linex[i] = ch_line[i];
                } else break;

            }
        }
        /////////////////////////нахождение знака///////////////////////////////////////////
        if (z == 1 || z == 2) {
            for (int i = 0; i < ch_line.length; i++) {
                if (ch_line[i] == '-' || ch_line[i] == '+' || ch_line[i] == '*' || ch_line[i] == '/') {
                    c = ch_line[i];
                    ci = i + 1;
                    if (c > 1) {
                        break;
                    }

                }
            }
            if (c < 0) {
                throw new IOException();
            }
        }
        //////////////////////////проверка и заполнение массива для второго арабского числа//////////////////////////////////
        if (z == 1) {
            if (ch_line[ci] >= 48 && ch_line[ci] <= 57) {
                ch_lineb = Arrays.copyOfRange(ch_line, ci, ch_line.length);

            }
        }
        ////////////////////////////проверка и заполнение массива для второго римского числа////////////////////////////////////
        if (z == 2) {
            if (ch_line[0] == 'I' || ch_line[0] == 'V' || ch_line[0] == 'X') {
                ch_liney = Arrays.copyOfRange(ch_line, ci, ch_line.length);

            }
        }
        ////////////////////////////////калькулятор арабский/////////////////////////////////
        if (z == 1) {
            String stra = new String(ch_linea);
            int a = Integer.parseInt(stra.trim());
            String strb = new String(ch_lineb);
            int b = Integer.parseInt(strb.trim());
            if (a > 0 && a <= 10 && b > 0 && b <= 10) {

                switch (c) {
                    case 43:
                        result = a + b;
                        break;
                    case 45:
                        result = a - b;
                        break;
                    case 42:
                        result = a * b;
                        break;
                    case 47:
                        result = a / b;
                        break;
                }
                System.out.println(result);
            } else {
                throw new IOException();
            }
        }
        //////////////////////////////////////калькулятор римский///////////////////////////////////////
        if (z == 2) {
            String strx = new String(ch_linex);
            strx = strx.trim();
            String stry = new String(ch_liney);
            int x = RomToArb.romToArb(strx);
            int y = RomToArb.romToArb(stry);
            if (x < 0 || y < 0) {throw new IOException();}
            switch (c) {
                case 43:
                    result = x + y;
                    break;
                case 45:
                    result = x - y;
                    break;
                case 42:
                    result = x * y;
                    break;
                case 47:
                    result = x / y;
                    break;
            }
            String srresult = TransRom.transRom(result);
            System.out.println(srresult);
        }

    }
}







