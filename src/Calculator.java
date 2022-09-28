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
        String[] calc_exp = exp.split("");
        if(calc_exp.length !=3){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Неверный формат");
            exp =  scanner.nextLine();

        }
        String strResult = null;
        Convert convert = new Convert();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        int actionIndex = -1;
        int count = 0;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                count++;

            }
        }
        if (actionIndex == -1 || count > 1) {

            System.out.println("Некорректное выражение");
        }

        String[] data = exp.split(regexActions[actionIndex]);

        if (convert.isRoman(data[0]) == convert.isRoman(data[1])) {
            int a, b;
            boolean isRoman = convert.isRoman(data[0]);
            if (isRoman) {
                a = convert.romanToInt(data[0]);
                b = convert.romanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[0]);
            }

            if (a < 1 || a > 10) {
                try {
                    throw new IOException();
                } catch (IOException c) {
                    System.out.println("Вы не ввели число от 1 до 10");
                    System.exit(0);

                }
            }
            int result;
                switch (actions[actionIndex]) {
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
                        System.out.println("В римской системе нет отрицательных чисел");
                    } else {


                        strResult = convert.intToRoman(result);
                    }
                } else {
                    strResult = String.valueOf(result);
                }
            } else {
                System.out.println("Числы в разных форматах");
            }
            return strResult;

        }
    }





