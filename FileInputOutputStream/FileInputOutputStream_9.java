import java.io.*;
import java.util.Arrays;

import static java.lang.System.out;

public class FileInputOutputStream_9 {
    /*
     * Чтение и запись текстовых файлов
     * 
     * FileWriter - класс для полноценной работы с текстовыми файлами. Раннее были рассмотрены классы, которые работают с файлами неполноценно. 
     * Конструкторы: 
     * FileWriter(File file)
     * FileWriter(File file, boolean append)
     * FileWriter(FileDescriptor fd)
     * FileWriter(String fileName)
     * FileWriter(String fileName, boolean append)
     * 
     * Все конструкторы работают по тем же параметрам, что и в предыдущих примерах.     
     */
    public static void main(String[] args){
        try(FileWriter fWriter = new FileWriter("Docs/FileWriter.txt", false)){
            String text = "hello world!";
            /*
             * Запись данных в файл 
             */
            fWriter.write(text);
            /*
             * Посимвольная запись 
             */
            fWriter.write("\n");
            fWriter.write("Hello, java!");
            out.println("File encoding: " + fWriter.getEncoding());
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
        /*
         * FileReader - класс для ввода(считывания) данных 
         * Конструкторы:
         * FileReader(String fileName)
         * FileReader(File file)
         * FileReader(FileDescriptor)
         */

        /*
         * Считывание посимвольно
         */
        try(FileReader fReader = new FileReader("Docs/FileWriter.txt")){
           
            int c; 

            while((c=fReader.read())!=-1){
                out.print((char)c);
            }
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
        /*
         * Считывание в промежуточный буфер из массива символов
         */
        try(FileReader fReader = new FileReader("Docs/FileWriter.txt")){

            char[] buff = new char[256];  

            fReader.read(buff);
            for(char s: buff){
                if(s>0){                //сделано для того, чтобы, если текст помещенный в буфер меньше этого буфера, не выводилось пустое место 
                    out.println(s);
                }
            }
            //Странные пример, да к тому же не работает, верхний лучше 
            // while((c=fReader.read(buff))>0){
            //     if(c<256){
            //         buff = Arrays.copyOf(buff, c);
            //     }
            //     out.print("\nЧтение из промежуточного буфера: " + buff.toString());
            // }
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
    }
}
