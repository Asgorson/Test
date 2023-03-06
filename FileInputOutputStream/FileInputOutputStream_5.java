import java.io.*;

public class FileInputOutputStream_5 {
    /*
     * Запись массива байт и класс ByteArrayOutputStream
     * Конструктор:
     * ByteArrayOutputStream();
     * ByteArrayOutputStream(int size)
     * 
     * Методы: 
     * writeTo() - метод, с помощью которого можно перевести данные в другой поток, тем самым записав данные в файл. 
     */
    public static void main(String[] args){

        ByteArrayOutputStream someByteArray = new ByteArrayOutputStream();
        String text = "Hello world. \n";
        byte[] buffer = text.getBytes(); 

        try{
            someByteArray.write(buffer, 0, buffer.length);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(someByteArray.toString()); //Получаем данные в виде строки

        for(byte s: buffer){     //получаем данные посимвольно 
            System.out.print((char)s);
        }

        try(FileOutputStream fos = new FileOutputStream("Docs/Hello.txt")){
            someByteArray.writeTo(fos);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
