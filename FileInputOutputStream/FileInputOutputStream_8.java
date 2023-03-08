import java.io.*;
import static java.lang.System.out;

public class FileInputOutputStream_8 {
    /*
     * DataOutputStream - представляет поток вывода и предназначен для записи данных примитивных типов, таких как int, char и т.д.
     * Чтобы записать каждый из примитивных типов необходимо использовать свой метод:
     *  
     * writeBoolean(boolean v)      - записывает в поток булевое однобатовое значение 
     * writeBytre(int v)            - записывает в поток 1 байт, который представлен в виде целочисленного значения 
     * writeChar(char v)            - записывает в поток 2 байтовое значение char
     * writeDouble(double v)        - записывает в поток 8 байтовое значение double
     * writeFloat(float v)          - записывает в поток 4 байтовое значение float
     * writeInt(int v)              - записывает в поток целочисленное значение 
     * writeLong(long v)            - записывает в поток значение long
     * writeShort(int v)            - записывает в поток значение short
     * writeUTF(String str)         - записывает в поток строку в кодировке UTF-8
     * 
     * DataInputStream - действует противоположным образом, т.е. считывает с потока примитивные данные. 
     * 
     */
    public static void main(String[] args){
        Person tom = new Person("Tom", 30, 1.82, false);
        /*
         * запись в файл
         */
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("Docs/DataOutputStreamDoc.txt"))){
            dos.writeUTF(tom.name);
            dos.writeInt(tom.age);
            dos.writeDouble(tom.height);
            dos.writeBoolean(tom.married);
            out.println("Данные записаны в файл.");
            for (char f: tom.buffOfChar){
                dos.writeChar(f);
            }
        }catch(Exception ex){
            out.println(ex.getMessage());
        }

        /*
         * считывание из файла 
         */
        try(DataInputStream dis = new DataInputStream(new FileInputStream("Docs/DataOutputStreamDoc.txt"))){
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean married = dis.readBoolean();
            out.printf("Name: %s    Age: %d     Married: %b", name, age, married);
        }catch(Exception ex){
            out.println(ex.getMessage());
        }

    }
}

class Person{
    public String name; 
    public int age; 
    public double height; 
    public boolean married; 
    char[] buffOfChar = {'h', 'e', 'l', 'l', 'o'};

    Person(String name, int age, double height, boolean married){
        this.name = name; 
        this.age = age;
        this.height = height; 
        this.married = married;
    }

}
