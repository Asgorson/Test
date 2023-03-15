import java.io.*;

class FileInputOutputStream_4{
    /*
     * Чтение массива байтов и класс ByteArrayInputStream
     * Конструкторы: 
     * ByteArrayInputStream(byte[] buff)
     * ByteArrayInputStream(byte[] buff, int offset, int length)
     * 
     * Для закрытия объектов данного класса не надо использовать метод close()
     */
    public static void main(String[] args){

        byte array[] = {116, 119, 66, 79};
        ByteArrayInputStream someByteStream = new ByteArrayInputStream(array);
        int b; 

        while((b=someByteStream.read())!=-1){
            System.out.print((char)b);
        }
        System.out.println();
        String text = "Hello world! ";
        byte array_2[] = text.getBytes();
        ByteArrayInputStream byteStream_2 = new ByteArrayInputStream(array_2);
        while((b=byteStream_2.read())!=-1){
            System.out.print((char)b);
        }
        /*
         * Пример работы с некоторым файлом. 
         * Производится получение байтов данных из файла объектом ByteArrayInputStream. 
         */
        String path = "S:/Programming/Java_projects/JavaCore/FileInputOutputStream/Docs/FOutputStream.txt";

        try(FileInputStream readFile = new FileInputStream(path)){
            byte someBuff[] = new byte[readFile.available()];
            int f; 
            someBuff = readFile.readAllBytes(); //можно исопльзовать оба способа 
            // readFile.read(someBuff);     
            ByteArrayInputStream byteArr = new ByteArrayInputStream(someBuff);
           
            System.out.println("\nData from file: \n");
            while((f =byteArr.read())!=-1){
                System.out.print((char)f);
            }

        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}