import java.util.*;

public class StringsWork {


     /*
     * Работа со строками.
     * Объект String является Immutable. Это значит, что при изменении строки, будет создаваться новая строка в области памяти.
     */

    public static void main(String[] args){
        
        /*
         * Разные вариации объявления строки
         */
        String str = "Hello";
        String str_1 = new String();
        String str_2 = new String(new char[] {'h', 'e', 'l', 'l', 'o'});
        String str_3 = new String(new char[] {'h', 'e', 'l', 'l', 'o'}, 1, 2);
        String str_4 = new String("some");
        
        System.out.println(str);
        System.out.println(str_1);
        System.out.println(str_2);
        System.out.println(str_3);
        System.out.println(str_4);

        /*
         * Можно определить длину строки
         */
        System.out.println("Lenght of str_2: " + str_2.length());

        /*
         * метод toCharArray  можно преобразовать строку обратно в массив символов
         */
        char[] someArr = str_2.toCharArray();
        System.out.println(someArr);

        /*
         * Метод isEmpty позволяет определить пустая строка или нет
         */
        if(str_1.isEmpty()){
            System.out.println("String is Empty.");
        }

        /*
         * String может иметь значение null. Это не одно и тоже, что "". 
         */
        String str_5 = null; 
        try{
            if(str_5.isEmpty()){
                System.out.println("String is empty.");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("End.");
        
    }

   
    
}