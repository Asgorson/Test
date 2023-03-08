import java.io.*;
import static java.lang.System.out;

public class FileInputOutputStream_7 {
    /*
     * PrintStream - класс, который используется для вывода на консоль, также его можно использовать для записи информации в поток вывода. 
     * Конструкторы: 
     * PrintStream(OutputStream someOutputStream) - OutputStream - объект, в который производится запись. 
     * PrintStream(OutputStream someOutputStream, boolean autoFlushingOn) - autoFlushingOn по умолчанию false, позволяет записывать данные в поток вывода автоматически. 
     * PrintStream(OutputStream someOutputStream, boolean autoFlushingOn, String charSet) throws UsupportedEncodingException
     * PrintStream(File outputFile) throws FileNotFoundException - в качестве параметра задается объект File, в котрый будет производится запись. 
     * PrintStream(File outputFile, String charSet) throws FileNotFoundException, throws UnsupportedEncodingException
     * PrintStream(String outputFileName) throws FileNotFoundException - в качестве параметра задается путь до файла. 
     * PringStream(String outputFileName, String charSet) throws FileNotFoundException, throws UnsupportedEncodingException
     */
    public static void main(String[] args){
        /*
         * Запись информации в файл
         */
        String text = "This is an example of using PrintSteams. "; 
        try(FileOutputStream someOutputStream = new FileOutputStream("Docs/PrintSteamDoc.txt");
            PrintStream somePrintStream = new PrintStream(someOutputStream)){
                somePrintStream.println(text);
                System.out.println("Запись в файл произведена.");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        out.println("Подключение этой библиотеки помогает сократить команду вывода.");

        /*
         * Также в файл можно выводить не только String данные, но и просто данные в ""
         */
        String somePath = "Docs/PrintStreamDoc_2.txt";

        try(FileOutputStream someOutputStream_2 = new FileOutputStream(somePath); PrintStream output = new PrintStream(someOutputStream_2)){
            int n = 100;

            output.println("Вывод простого текста командой println().");
            output.printf("\nРабота команды printf() выполняется на %d процентов.", n);
            out.println("Запись в файл произведена.");
            /*
             * Кроме того как и любой поток вывода, данный поток имеет метод write()
             */
            String someMessage = "\nДанное сообщение показывет, что метод write() работает.";
            byte someBuf[] = someMessage.getBytes();
            output.write(someBuf);
        }catch(IOException ex){
            out.println(ex.getMessage());
        }


        /*
         * PrintWriter - класс который можно использовать как для вывода данных на консоль, так и в любой другой поток вывода. 
         * Конструкторы:
         * 
         * PrintWriter(File file)                                       - автоматически добавляет данные в указанный файл. 
         * PrintWriter(File file, String csn)                           - автоматически добавляет данные в указанный файл с учетом кодировки csn.
         * PrintWriter(OutputStream outputStream)                       - для вывода информации используется существующий объект OutputStream, автоматически сбрасывая в него данные. 
         * PrintWriter(OutputStream outputStream, boolean autoFlush)    - для вывода информации используется существующий объект OutputStream, второй параметр указывает, надо ли 
         *                                                                автоматически добавлять в OutputStream данные. 
         * PrintWriter(String fileName)                                 - автоматически добавляет данные в файл по указанному имени.
         * PrintWriter(String fileName, String cns)                     - автоматически добавляет данные в файл по указанному имени, используя кодирвку csn. 
         * PrintWriter(Writer out)                                      - автоматически добавляет данные в файл по существующему объкту Writer.
         * PrintWriter(Writer out, boolean autoFlush)                   - для вывода информации используется существующий объект Writer, второй параметр указывает, надо ли
         *                                                                автоматически добавлять в Writer данные.
         * Данный поток также надо закрывать методом close() или использовать try-with-resources
         */
        /*
         * Вывод в консоль 
         */
        try(PrintWriter pw = new PrintWriter(System.out)){
            pw.println("\nHello, world!");
        }catch(Exception ex){
            out.println(ex.getMessage());
        }

        /*
         * Вывод в файл 
         */
        try(PrintWriter pw = new PrintWriter("Docs/PrintWriterDoc.txt")){
            pw.println("Вывод в файл данных с помощью класса PrintWriter.");
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
    }
}
