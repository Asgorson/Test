import java.io.*;
/*
 * FileInputStream - предназначен для считывания данных из файла. Он является производным от класса InputStream, поэтому наследует все его 
                     функциональность.

 *
 * Методы: 
 *  int available():                                    возвращает количество байтов, доступных для чтения в потоке
 *  void close():                                       закрывает поток
 *  int read():                                         возвращает целочисленное представление следующего байта в потоке. Когда в потоке не останется доступных для чтения байтов, 
 *                                                      данный метод возвратит число -1
 *  int read(byte[] buffer):                            считывает байты из потока в массив buffer. После чтения возвращает число считанных байтов. Если ни одного байта не было 
 *                                                      считано, то возвращается число -1
 *  int read(byte[] buffer, int offset, int length):    считывает некоторое количество байтов, равное length, из потока в массив buffer. При этом считанные байты помещаются в массиве, 
 *                                                      начиная со смещения offset, то есть с элемента buffer[offset]. Метод возвращает число успешно прочитанных байтов.
 *  long skip(long number):                             пропускает в потоке при чтении некоторое количество байт, которое равно number
 *  void mark(int readLimit):                           создает метку текущей позиции в потоке, чтобы, при вызове метода reset(), можно было вернуться в эту позицию.
 *  void reset():                                       метод для возвращения к позиции, установленной меткой mark().
 */

public class FileInputOutputStream_2 {
    public static void main(String[] args){
        
        String filePath = "S:/Programming/Java_projects/JavaCore/FileInputOutputStream/Docs/FOstream.txt";
        /*
         * Вариант побайтового чтения 
         * /
        try(FileInputStream readFile = new FileInputStream(filePath)){
            System.out.printf("Size of file: %d \n", readFile.available());
            int i = -1; 
            while((i = readFile.read())!=-1){
                System.out.println((char)i);
            }
        }catch(IOException ex){
            ex.getMessage();
        }
        */

        /*
         * Вариант загрузки данных в буфер и чтение из него
         */
        try(FileInputStream readFile = new FileInputStream(filePath)){
            System.out.printf("Size of file: %d \n", readFile.available());
            byte[] buffer = new byte[readFile.available()];
            readFile.read(buffer);
            System.out.println("File data: ");
            for(int i=0; i<buffer.length; i++){
                System.out.print((char)buffer[i]);
            }

        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

