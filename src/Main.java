import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        //Получение строки из консоли
        Scanner console = new Scanner(System.in);
        String answer = calc(console.nextLine());
        System.out.println(answer);

        //Предполагается, что между числами и арифметическим символом есть пробелы
    }

    public static String calc(String input) throws Exception{

        //Разбиение строки на элементы
        String[] elements = input.split(" ");

        try {
            //Выделение чисел для анализа
            String[] numbersString = {elements[0], elements[2]};

            //Проверка на числа и общее число элементов
            if (elements.length > 3 || !checkNums(numbersString)) {
                throw new Exception();
            }

            //При большем количестве чисел лучше использовать цикл
            int[] numbers = {Integer.parseInt(numbersString[0]),Integer.parseInt(numbersString[1])};

            //Выполнение математических операций
            int answer = switch (elements[1]) {
                case "+" -> numbers[0] + numbers[1];
                case "-" -> numbers[0] - numbers[1];
                case "/" -> numbers[0] / numbers[1];
                case "*" -> numbers[0] * numbers[1];
                default -> throw new Exception();
            };

            return "" + answer;

        } catch (Exception e) {
            //System.out.println("throws Exception");
            throw new Exception("throws Exception");
        }
    }

    public static boolean checkNums (String[]numbers){
        int indexOne = '1';
        int indexNine = '9';
        int counterNumbers = 0;

        for (String number : numbers)
            if (number.length() == 1
                    && number.codePointAt(0) >= indexOne
                    && number.codePointAt(0) <= indexNine
                    || number.equals("10"))
                counterNumbers++;

        return counterNumbers == numbers.length;
    }
}