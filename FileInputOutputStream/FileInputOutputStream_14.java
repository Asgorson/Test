import static java.lang.System.out;
import java.io.Console;

public class FileInputOutputStream_14 {
    /*
     * Console -    класс созданный специально для работы с консолью. Он не получает консольный ввод-вывод сам по себе, но использует уже имеющиеся потоки System.in
     *              и System.out. Данный класс упрощает ряд операция связанных с консолью. 
     * Методы:
     * flush() - выводит на консоль все данные из буфера
     * format() - выводит на консоль строку с использованием форматирования 
     * printf() - выводит на консоль строку с использованием форматирования, фактически тоже самое, что и выше
     * String readLine() - считывает строку с консоли
     * char[] readPassword() - считывает строку, при этом ввводимые символы не отображаются
     */
    public static void main(String[] args){
        Console console = System.console();
        if(console!=null){
            String login = console.readLine("Введите логин: ");
            char[] pass = console.readPassword("Введите пароль: ");

            console.printf("Введенный логин: %s\n", login);
            console.printf("Введенный пароль: %s\n", new String (pass));

        }
    }
}
