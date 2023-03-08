import java.io.*; 

public class FileInputOutputStream_6 {
    /*
     * Использование буферизованных потоков BufferedInputStream -   оптимизирует операции ввода-вывода путем добалвение специального буфера, с помощью которого оптимизируется 
     *                                                              производительность при чтении и записи потоков. Использовать в сложных приложениях.
     * Конструкторы: 
     * BufferedInputStream(InputStream someIS)
     * BufferedInputStream(InputStream someIS, int buffSize)
     * 
     */
    public static void main(String[] args){
        String someText = "Hello world! ";
        byte[] buffer = someText.getBytes();
        ByteArrayInputStream  someByteArrInputStream = new ByteArrayInputStream(buffer);

        try(BufferedInputStream someBufferredInputStream = new BufferedInputStream(someByteArrInputStream)){
            int c; 
            while((c=someBufferredInputStream.read())!=-1){
                System.out.print((char)c);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        /*
         * Использование буферезованного потока BufferedOutputStream - накапливает выводимые байты без постоянного обращения к устройству и, когда буфер заполнен, производится их 
         * запись. Также осуществляется оптимизация работы потоков в сложных приложениях. 
         * Конструкторы: 
         * BufferedOutputStream(OutputStream someOutputStream)
         * BufferedOutputStream(OutputStream someOutputStream, int bufSize))
         */

        String somePhrase = "Hello programm! ";
        try(FileOutputStream someFileOutputStream = new FileOutputStream("Docs/BufferedOutputStreamDoc.txt");
            BufferedOutputStream someBufferedOutputStream = new BufferedOutputStream(someFileOutputStream);){

                byte[] someBuffer = somePhrase.getBytes();
                someBufferedOutputStream.write(someBuffer);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
