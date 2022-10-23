import java.io.*;

/*
 *FileOutputStream - предназначен для записи байтов в файл. Он является произовдным от класса OutputStream, поэтому наследует всю его
                     функциональность. 
                     Варианты создания объекта FileOutputStream:
                                                                FileOutputStream(String filePath)
                                                                FileOutputStream(File fileObj)
                                                                FileOutputStream(String filePath, boolean append)
                                                                FileOutputStream(File fileObj, boolean append)

 *FileInputStream - предназначен для считывания данных из файла. Он является производным от класса InputStream, поэтому наследует все его 
                    функциональность.
 */
 
public class FileInputOutputStream {
    public static void main(String[] args){
        
        String Text = "Hello world. Goodbye uderworld.",
               FilePath = "S://Programming/Java_projects/Test/FileOutputInputTest/FOstream.txt",
               Text_2 = "Legends never die.";

        try (FileOutputStream FOStream = new FileOutputStream(FilePath)){
            byte[] buffer = Text.getBytes();
            FOStream.write(buffer, 3, buffer.length - 3);
            FOStream.close();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        try (FileOutputStream FOStream_2 = new FileOutputStream(FilePath, true)){
            byte[] buffer_2 = Text_2.getBytes();
            FOStream_2.write(buffer_2, 0, buffer_2.length);
            FOStream_2.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
