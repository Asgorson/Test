import java.io.*;

/*
 *FileOutputStream - предназначен для записи байтов в файл. Он является произовдным от класса OutputStream, поэтому наследует всю его
                     функциональность. 
                     Варианты создания объекта FileOutputStream:
                                                                FileOutputStream(String filePath)
                                                                FileOutputStream(File fileObj)
                                                                FileOutputStream(String filePath, boolean append)
                                                                FileOutputStream(File fileObj, boolean append)
 *
 * Методы: 
 *   
 *  void close():               закрывает поток
 *  void flush():               очищает буфер вывода, записывая все его содержимое
 *  void write(int b):          записывает в выходной поток один байт, который представлен целочисленным параметром b
 *  void write(byte[] buffer):  записывает в выходной поток массив байтов buffer.
 *  void write(byte[] buffer, int offset, int length): записывает в выходной поток некоторое число байтов, равное length, из массива buffer, начиная со смещения offset, 
 *                                                     то есть с элемента buffer[offset].
 */
 
public class FileInputOutputStream_1 {
    public static void main(String[] args){
        
        String Text = "Hello world. ",
               Text_2 = "Goodbye underworld.", 
               FilePath = "S:/Programming/Java_projects/JavaCore/FileInputOutputStream/Docs/FOstream.txt";
               

        try (FileOutputStream FOStream = new FileOutputStream(FilePath)){
            byte[] buffer = Text.getBytes();
            FOStream.write(buffer, 0, buffer.length);
            FOStream.close();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        try (FileOutputStream FOStream_2 = new FileOutputStream(FilePath, true)){
            byte[] buffer = Text_2.getBytes();
            FOStream_2.write(buffer, 0, buffer.length);
            FOStream_2.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        

    }
}
