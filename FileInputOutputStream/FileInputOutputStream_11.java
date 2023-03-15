import java.io.*;
import static java.lang.System.out;


public class FileInputOutputStream_11 {
    /*
     * Сериализация -   представляет собой процесс записи состояния объкта в поток. Процесс извлечения или восстановления состояния объкта из потока - Десериализация. 
     *                  Она необходимо, когда работа идет с объектами. 
     * Среиализировать можно только те объекты, которые реализуют интерфейс Serializable. Он не имеет методов, а служит указателем на то, что данный объкт может быть сриализирован.
     * 
     * ObjectOutputStream - класс, который используется для сериализации объектов. Он записывает данные в поток.
     *  
     * Конструктор: 
     * ObjectOutputStream(OutputStream out)
     * 
     * Методы:
     * close() - закрытие потока 
     * flush() - очищение потока и сброс его содержимого в выходной поток
     * write(byte [] buff) - записывает в поток массив байтов
     * write(int val) - записывает в поток один младший байт из val
     * writeBoolean(boolean val) - записывает в поток значение boolean
     * writeByte(int val) - записывает в поток один младший байт из val
     * writeChar(int val) - записывает в поток значение типа char, представленное целочисленным значением 
     * writeDouble(double val) - записывает в поток значение типа double
     * writeFloat(float val) - записывает в поток значение типа float
     * writeInt(int val) - записывает целочисленное значение int
     * writeLong(long val) - записывает значение типа long
     * writeShort(int val) - записывает значение типа short
     * writeUTF(String val) - записывает в поток строку в кодировке UTF-8
     * writeObject(Object obj) - записывает в поток отдельный объект
     * 
     */
    public static void main(String[] args){

        String path = "Docs/ObjectOutputStreamDoc.txt";
        
        try(ObjectOutputStream outData = new ObjectOutputStream(new FileOutputStream(path))){
            PersonData person = new PersonData("Asgor", 25, 78);
            outData.writeObject(person);
            out.println("Данные записаны.");
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
        

        /*
         * OjectOutputStream - класс производит десериализацию. Методы точно такие же как и выше. + один метод:
         * skipBytes(int len) - пропускает при чтении несколько байт, количество которых равно len.
         */

         try(ObjectInputStream inData = new ObjectInputStream(new FileInputStream(path))){
            PersonData p = (PersonData)inData.readObject();
            out.println("Чтение данных.");
            out.printf("Name: %s \tAge: %d \tHeight: %d", p.name, p.age, p.height);
         }catch(Exception ex){
            out.println(ex.getMessage());
         }
    }
}

class PersonData implements Serializable{
    private static final long serialVersionUID = 1L;    // Идентификатор класса, также записывается в файл при сериализации, автоматически складывается по на основе содержимого. 
                                                        // Необходимо определять. Если в класс, который имеет некоторый UID, внести изменения, то провести десериализацию не 
                                                        // получится, выскочит ошибка несоответствия(вследствие того, что это происходит на основе содержимого, другое содиржимое
                                                        // -> другой UID).
                                                        // Если, например, у класса ниже закомментить поле serialVersionUID, провести сериализацию данного объекта, потом добавить 
                                                        // в класс еще одно поле и провевсти десериализацию, выскочит ошибка. (Примечание. В данном примере после сериализации 
                                                        // надо закоментить первый try{}catch(){})
    /*
     * По умолчанию сериализуются все поля, однако, если необходимо какие-то поля исключить из данного процесса, необходимо объявить их с идентификатором transient.
     */
    String name; 
    int age,
        height;
    transient boolean married;  //пример исключения поля из процесса сериализации с помощью метода transient.


    PersonData(String name, int age, int height){
        this.name = name; 
        this.age = age;
        this.height = height;
    }

    String getName(){
        return name;
    }
    int age(){
        return age;
    }
    int height(){
        return height;
    }
}
