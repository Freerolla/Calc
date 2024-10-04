import java.util.Scanner; // Импортируем класс Scanner для чтения ввода пользователя

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для считывания ввода с консоли
        System.out.println("Введите выражение:"); // Выводим приглашение для ввода арифметического выражения
        String input = scanner.nextLine(); // Считываем строку ввода от пользователя
        try {
            String result = calc(input); // Пробуем вычислить результат с помощью метода calc
            System.out.println(result); // Выводим результат
        } catch (Exception e) {
            System.out.println("throws Exception"); // Обрабатываем исключения и выводим сообщение об ошибке
        }
    }

    public static String calc(String input) throws Exception {
        input = input.replaceAll("\\s", ""); // Удаляем все пробелы из строки ввода
        String[] operators = {"+", "-", "*", "/"}; // Массив возможных операторов
        String operator = ""; // Переменная для хранения найденного оператора
        for (String op : operators) { // Проходим по массиву операторов
            if (input.contains(op)) { // Если строка содержит оператор
                operator = op; // Сохраняем оператор
                break; // Прерываем цикл
            }
        }

        if (operator.isEmpty()) { // Если оператор не найден
            throw new Exception("Неверный формат выражения"); // Выбрасываем исключение
        }

        String[] parts = input.split("\\" + operator); // Разделяем строку ввода на две части: два числа
        if (parts.length != 2) { // Если частей не две
            throw new Exception("Неверный формат выражения"); // Выбрасываем исключение
        }

        int num1 = Integer.parseInt(parts[0]); // Парсим первое число
        int num2 = Integer.parseInt(parts[1]); // Парсим второе число

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) { // Проверяем диапазон чисел
            throw new Exception("Числа должны быть от 1 до 10 включительно"); // Выбрасываем исключение
        }

        int result; // Переменная для хранения результата
        switch (operator) { // Выполняем арифметическую операцию в зависимости от оператора
            case "+":
                result = num1 + num2; // Сложение
                break;
            case "-":
                result = num1 - num2; // Вычитание
                break;
            case "*":
                result = num1 * num2; // Умножение
                break;
            case "/":
                result = num1 / num2; // Деление
                break;
            default:
                throw new Exception("Неверный оператор"); // Выбрасываем исключение, если оператор не распознан
        }

        return String.valueOf(result); // Возвращаем результат в виде строки
    }
}
