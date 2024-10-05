import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = scanner.nextLine();

        String result = calc(input);
        System.out.println(result);
        new Exception("throws Exception");


    }

    public static String calc(String input) throws Exception {
        input = input.replaceAll("\\s", "");
        String[] operators = {"+", "-", "*", "/"};
        String operator = "";
        for (String op : operators) {
            if (input.contains(op)) {
                operator = op;
                break;
            }
        }

        if (operator.isEmpty()) {
            throw new Exception("Неверный формат выражения");
        }

        String[] parts = input.split("\\\\" + operator);
        if (parts.length != 2) {
            throw new Exception("Неверный формат выражения");
        }

        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10 включительно");
        }

        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new Exception("Неверный формат выражения");
        }

        return String.valueOf(result);
    }
}
