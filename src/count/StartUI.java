package count;

import java.util.Scanner;

public class StartUI {
    public static void main(String[] args) {
        CountOperation countOperation = new CountOperation();
        Counter counter = countOperation.loadCounter();

        System.out.println("Состояние счетчика: " + counter.getValue());
        System.out.println("Введите команду (/inc, /reset, /stop):");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "/inc":
                    counter.increment();
                    break;

                case "/reset":
                    counter.reset();
                    break;

                case "/stop":
                    System.out.println("Счетчик: " + counter.getValue());
                    System.out.println("Завершаю работу...");
                    countOperation.saveCounter(counter);
                    return;

                default:
                    System.out.println("Неизвестная команда. Попробуйте ещё раз.");
            }
        }
    }
}