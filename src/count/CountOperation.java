package count;

import java.io.*;

/**
 * Класс для управления сериализацией и десериализацией счетчика.
 */
public class CountOperation {

    private static final String FILE_NAME = "counter.ser";

    /**
     * Загружает объект счетчика из файла.
     *
     * @return объект Counter или новый экземпляр, если файл отсутствует
     */
    public Counter loadCounter() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Counter counter = (Counter) ois.readObject();
            System.out.println("Счетчик загружен, значение '" + counter.getValue() + "'");
            return counter;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Не удалось загрузить счетчик, создается новый.");
            return new Counter(); // Возвращаем новый счетчик, если файл отсутствует
        }

    }

    /**
     * Сохраняет объект счетчика в файл.
     *
     * @param counter объект Counter для сохранения
     */
    public void saveCounter(Counter counter) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(counter);
            System.out.println("Состояние счетчика сохранено.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении состояния счетчика: " + e.getMessage());
        }
    }
}