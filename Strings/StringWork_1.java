import java.util.*;

/*
 * Основные операции над строками
 */

public class StringWork_1 {
    public static void main(String[] args){

        /*
         * Соединение строк
         */
        String str_1 = "Hello";
        String str_2 = "world!";

        System.out.println(str_1 + " " + str_2);
        
        /*
         * Через метод concat()
         */
        System.out.println(str_1.concat(str_2));
        
        /*
         * Через статический метод join(). Позволяет соединять строки с учетом рарзедлителя. 
         */
        System.out.println(String.join(" ", str_1, str_2, str_1));

        /*
         * Извлечение символов и строк
         * charAt() извлекает символ по указанному индексу
         */
        char someChar = str_2.charAt(2);
        System.out.println(someChar);

        /*
         * Метод getChars(scrBegin, srcEnd, dst, dstBegin) необходим для извлечения группы сиволов или подстроки
         */
        String str_3 = "Hello world!";
        char[] arrOfChar = new char[6]; 
        str_3.getChars(2,8, arrOfChar, 0);
        System.out.println(arrOfChar);

        /*
         * Сравнение строк
         * Метод equals() и equalsIgnoreCase()
         * Для сравнения строк не может применяться опреанд ==, вместо него используется вышеуказанные методы
         */
        String str_4 = "hello";
        String str_5 = "Hello";
        System.out.println(str_4.equals(str_5));
        System.out.println(str_4.equalsIgnoreCase(str_5));

        /*
         * Сравнение подстрок в двух строках определяется методами regionMatches(ignoreCase, toffset, other, oofset, len)
         */
        str_4 = "something";
        str_5 = "sometimes";
        boolean result = str_4.regionMatches(0, str_5, 0, 4);
        System.out.println("Result of match: " + result);

        /*
         * Сравнение длины строк методами compareTo() и compareToIgnoreCase(). Только результат метода выводится в числовом формате. Если первая строка меньше второй, результат 
         * отрицательный, если больше второй, результат положительный. 
         * Идет проверка по буквам по лексикографическому порядку. 
         */
        str_4 = "b";
        str_5 = "a";
        System.out.println(str_4.compareTo(str_5));

        /*
         * Поиск в строке осуществляется методами indexOf() (находит индекс первого вхождения буквы в строке) и lastIndexOf() (находит индекс последнего вхождения буквы в строке). 
         * Если подстрока не найдена возвращает -1.
         */
        str_5 = "Some word";
        System.out.println("First letter in word: " + str_5.indexOf("o"));
        System.out.println("Last letter in word: " + str_5.lastIndexOf("o"));

        /*
         * startsWith(), endsWith() - позволяют определить начинается ли или заканчивается ли строка с опеределенной подстроки
         */
        str_5 = "someprog.exe";
        System.out.println("\n" + str_5.startsWith("so"));
        System.out.println(str_5.endsWith(".exe"));

        /*
         * replace() - замена в строке одной последовательности на другую
         */
        System.out.println("\n" + str_5.replace("exe", "bat"));
        System.out.println(str_5.replace("some", ""));

        /*
         * trim() - позволяет убрать начальные и конечные пробелы
         */
        str_5 = " some prog.exe ";
        System.out.println(str_5.trim());

        /*
         * substring() - возвращает подстроку, начиная с определенного индекса до конца или до указанного индекса
         */
        str_5 = "Someprog.exe";
        System.out.println(str_5.substring(0, 8));
        
        /*
         * toLowerCase()  и toUpperCase() - позволяет переводить строку из одного регистра в другой 
         */
        System.out.println(str_5.toUpperCase());

        /*
         * split() - позволяет разбить строку на подстроки по определенному разделителю, точка почему - то не учитывается, а вот запятая вполне
         */
        str_5 = "hello world and good bye";
        String[] strArr = str_5.split(" ");
        for(String str: strArr){
            System.out.println(str);
        }
    }
}
