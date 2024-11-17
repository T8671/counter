package count;

import java.io.Serializable;

/**
 * Класс счетчика, который инкапсулирует значение и логику работы.
 */
public class Counter implements Serializable {
    private static final long serialVersionUID = 1L; //Версия для сериализации
    private int value = 0;

    /**
     * Увеличивает значение счетчика на 1.
     */
    public void increment() {
        value++;
        System.out.println("Счетчик увеличен на: " + value);
    }

    /**
     * Сбрасывает значение счетчика на 0.
     */
    public void reset() {
        value = 0;
        System.out.println("Счетчик сброшен: " + value);
    }

    /**
     * Возвращает текущее значение счетчика.
     */
    public int getValue() {
        return value;
    }
}
