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
        
        String text = "Hello world! ";
        byte array_2[] = text.getBytes();
        ByteArrayInputStream byteStream_2 = new ByteArrayInputStream(array_2);
        
        System.out.println();
        while((b=byteStream_2.read())!=-1){
            System.out.print((char)b);
        }
    }
}