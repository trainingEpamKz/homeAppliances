package kz.homeAppliances.appliances.exceptions;

/**
 * Ошибка загрузки данных из файла
 */
public class LoadPropFromFileException extends Exception {
    public LoadPropFromFileException(String message) {
        super(message);
    }
}
