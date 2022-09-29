import Convert.Convert;

import java.io.IOException;
import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String exp = scanner.nextLine();
        System.out.println(Calc(exp));
    }

    public static String Calc(String exp) {
        String[] data = exp.split(" ");
        if (data.length < 3) {
            System.out.println("строка не является математической операцией");
            System.exit(0);
        } else if (data.length > 3) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            System.exit(0);
        }

        String strResult = null;
        Convert convert = new Convert();

        if (convert.isRoman(data[0]) == convert.isRoman(data[2])) {
            int a, b;
            boolean isRoman = convert.isRoman(data[0]);


            if (isRoman) {
                a = convert.romanToInt(data[0]);
                b = convert.romanToInt(data[2]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[2]);
            }

            if (a < 1 || a > 10 || b < 1 || b > 10) {
                try {
                    throw new IOException();
                } catch (IOException c) {
                    System.out.println("Вы не ввели число от 1 до 10");
                    System.exit(0);

                }
            }

            int result;
            switch (data[1]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if (isRoman) {
                if (result <= 0) {
                    System.out.println("в римской системе нет отрицательных чисел");
                    System.exit(0);
                } else {


                    strResult = convert.intToRoman(result);
                }
            } else {
                strResult = String.valueOf(result);
            }
        } else {
            System.out.println("используются одновременно разные системы счисления");
            System.exit(0);
        }
        return strResult;

    }
}





