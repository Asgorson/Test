import java.io.*;
import static java.lang.System.out;
import java.util.Scanner;

public class FileInputOutputStream_10 {
    /*
     * Буферизация символьных потоков 
     * Запись текста через буфер и BufferedWriter 
     * 
     * BufferedWriter - класс записывает текст в поток, предварительно буферизируя записываемые данные, тем самым снижая количество обращений к фезическому носителю для записи
     *                  данных. 
     * Конструкторы: 
     * BufferedWriter(Writer out)
     * BufferedWriter(Writer out, int size) - второй параметр - размер буфера 
     *  
     */
    public static void main(String[] args){
        try(BufferedWriter someBuffWriter = new BufferedWriter(new FileWriter("Docs/BufferWriterDoc.txt"), 1)){

            String text = "Hello world! \nJava is cool!";
            String text_2 = "\nGood morning!";

            someBuffWriter.write(text);
            someBuffWriter.append(text_2);
            out.println("Текст записан.");
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
        /*
         * Чтение текста через буфер и BufferedReader
         * BufferedReader - класс считывает текст из символьного потока ввода, буферизируя прочитанные символы. Использование буфера увеличивает производительность чтения данных из 
         *                  потока. 
         * Конструкторы:
         * BufferedReader(Reader in)
         * BufferedReader(Reader in, int size)
         * 
         * Данный класс имеет собственный метод для чтения данных из потока построчно. 
         * Метод:
         * readLine() 
         * 
         */

        /*
         * Чтение данных посимвольно
         */
        try(BufferedReader someBuffReader = new BufferedReader(new FileReader("Docs/BufferWriterDoc.txt"))){
            
            int c;

            while((c=someBuffReader.read())!=-1){
                out.print((char)c);
            }
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
        /*
         * Чтение данных построчно 
         */
        try(BufferedReader someBuffReader = new BufferedReader(new FileReader("Docs/BufferWriterDoc.txt"))){
           
            String getText; 

            out.print("\n");
            while((getText=someBuffReader.readLine())!=null){
                out.println(getText);
            }
        }catch(Exception ex){
            out.println(ex.getMessage());
        }

        /*
         * Считывание с консоли в файл 
         */
        try(BufferedReader someBuffReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter someBuffWriter = new BufferedWriter(new FileWriter("Docs/BufferedWriter_2.txt"))){
            
            String text; 

            while(!(text=someBuffReader.readLine()).equals("ESC")){
                someBuffWriter.write(text + "\n");
                someBuffWriter.flush();
            }
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
    }
}
