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
               FilePath = "S:/Programming/Java_projects/JavaCore/FileInputOutputStream/Docs/FOutputStream.txt";
               

        try (FileOutputStream FOStream = new FileOutputStream(FilePath)){   //Создание объкта в скобках конструкции создания исключения - это так называемый метод try-with resources
            byte[] buffer = Text.getBytes();                                //при котором, нет необходимости закрывать поток методом close(). Он закрывается автоматически. 
            FOStream.write(buffer, 0, buffer.length);
            //FOStream.close();     //не надо здесь его указывать, так как закрытие потока происходит автоматически. См. предыдущий коментарий. Если бы объект создавался не в 
        }catch(IOException ex){    //в скобках, тогда закрывать поток необходимо в блоке finally{}, см. пример 3. 
            System.out.println(ex.getMessage());
        }

        try (FileOutputStream FOStream_2 = new FileOutputStream(FilePath, true)){
            byte[] buffer = Text_2.getBytes();
            FOStream_2.write(buffer, 0, buffer.length);
            //FOStream_2.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        

    }
}
