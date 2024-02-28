package Exceptions;

public class NotCorrectCountOfParametrs extends Exception{
    public NotCorrectCountOfParametrs(int count) {
        super("Некорректное количество параметров - " + count + ". Должно быть 6 параметров");
    }
}
