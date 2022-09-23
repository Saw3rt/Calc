import Convert.Convert;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Convert convert = new Convert();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String exp = scanner.nextLine();
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            System.out.println("Некорректное выражение");
            return;
        }

        String[] data = exp.split(regexActions[actionIndex]);

        if (convert.isRoman(data[0]) == convert.isRoman(data[1])) {
            int a, b;
            boolean isRoman = convert.isRoman(data[0]);
            if(isRoman){
                a = convert.romanToInt(data[0]);
                b = convert.romanToInt(data[1]);
            }else{
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[0]);
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
            if(isRoman) {
                System.out.println(convert.intToRoman(result));
            }
            else{
                System.out.println(result);
            }
        }
        else{
                System.out.println("Числы в разных форматах");
            }
        }
    }


