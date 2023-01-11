import java.util.*;

public class StringWork_2 {
    public static void main(String[] args){

        /*
         * Рыбота с классами StringBuffer и StringBuilder.
         * Они необходимы для оптимизации создания строк. При изменении строки в данном случае не будет создаваться новая строка в памяти. 
         * StringBuffer - используется для работы в многопоточном приложении (синхронизированный и потокобезопасный). 
         * StringBuilder - используется для работы в однопоточном приложении (непотокобезопасный). 
         * 
         * Методы классов одинаковы:
         * capacity() - получить количество символов, для которых зарезервирована память.
         * insureCapacity() - измеинть минимальную емкость буфера, но даже после изменения ескость, сама java может изменять новую емкость в некоторых пределах для повышения эффективности.
         * length() - получить длину строки. 
         * toString() - получить строку.
         */
        String someString = "I love java!";
        StringBuffer someStrBuffer = new StringBuffer(someString);
        System.out.println("Capacity of string: " + someStrBuffer.capacity());
        someStrBuffer.ensureCapacity(58);
        System.out.println("Changed capacity of string: " + someStrBuffer.capacity());
        System.out.println("Length of string: " + someStrBuffer.length());
        String str = someStrBuffer.toString();
        System.out.println(str);

        /*
         * Методы для работы со строкой в StringBuffer и StringBuilder.
         * charAt() - получает символ по указанному индексу 
         * setCharAt() - устанавливает символ по указанному индексу
         * getChars() - получает набор сиволов между определенными индексами
         */
        System.out.println(someStrBuffer.charAt(0));

        someStrBuffer.setCharAt(7, 'l');
        System.out.println(someStrBuffer);

        char someChar[] = new char[6];
        someStrBuffer.getChars(0, 6, someChar, 0);
        System.out.println(someChar);

        /*
         * Добавление в строку 
         * append() - добавляет подстроку в конец StringBuffer
         * insert() - добавляет строку или символ по указанному индексу
         * delete() - удаляет все символы в указанном диапазоне
         * deleteCharAt() - удаляет один символ по определенному индексу 
         */
        someStrBuffer = new StringBuffer("Hello");
        someStrBuffer.append(" world!");
        System.out.println(someStrBuffer);

        System.out.println(someStrBuffer.insert(12, ' '));
        System.out.println(someStrBuffer.insert(13, "I love you!"));

        System.out.println(someStrBuffer.delete(0, 13));

        System.out.println(someStrBuffer.deleteCharAt(someStrBuffer.length()-1));

        /*
         * substring - получает строку с определенного индекса до конца, или до определенного индекса
         */
        System.out.println(someStrBuffer.substring(2, 6));

        /*
         * setLength - изменение длины строки(не емкости буфера)
         */
        someStrBuffer.setLength(5);
        System.out.println(someStrBuffer.toString());

        /*
         * replace - замена подстроки новой подстрокой
         */
        someStrBuffer = new StringBuffer("someprog.exe");
        System.out.println(someStrBuffer.replace(9, someStrBuffer.length(), "bat"));

        /*
         * reverse - обратный порядо символов строки
         */
        System.out.println(someStrBuffer.reverse());
    }
}
