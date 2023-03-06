import java.io.*;

public class FileInputOutputStream_3 {
    /*
     * Закрытие потока ввода-вывода. Способ с явным использованием метода close().
     * Метод: 
     *
     * Close() - закрывает поток 
     * 
     * Метод закрытия потока при помощи try - with - resources: 
     * делается как в примере 1 и 2. try(название_класса имя_объекта = конструктор_класса(); еще один класс если надо, указывается через точку с запятой)
     */
    public static void main(String[] args){

        String filePath = "S:/Programming/Java_projects/JavaCore/FileInputOutputStream/Docs/FOstream.txt";
        FileInputStream readFile = null;

        try{
            readFile = new FileInputStream(filePath);
            byte[] buffer = new byte[readFile.available()];
            readFile.read(buffer);
            for(int i=0; i<buffer.length; i++){
                System.out.print((char)buffer[i]);
            }

        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                if(readFile!=null){
                    readFile.close();
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
               
        }
        
    }   
}
