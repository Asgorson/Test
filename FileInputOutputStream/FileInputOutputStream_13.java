import static java.lang.System.out;
import java.io.*;
import java.util.zip.*;

public class FileInputOutputStream_13 {
    /*
     * Работа с ZIP - архивами. 
     * Запись ZIP - архива. 
     * 
     * ZipOutputStream - класс необходимый для создания архива. 
     * 
     * Конструктор:
     * ZipOutputStream(OutputStream out)
     * 
     * Для записи файла в архив, для каждого файла создается объект ZipEntry, в конструктор которго передается имя архивируемого файла. 
     * 
     * Метод:
     * putNextEntry() - метод, необходимый для добавлвения ZipEntry в архив. 
     * 
     * 
     * ZipInputStream - класс для разархивирования архива. 
     * 
     * Конструктор:
     * ZipInputStream(OutputStream out)
     * 
     * Для чтения файла из архива, для каждого файла создается объект ZipEntry, в конструктор которго передается имя архивируемого файла. 
     * 
     * Метод: 
     * getZipEntry() - метод, необходимый для вывода ZipEntry из архива. 
     *  
     */
    public static void main(String[] args){
        String  zipPath = "Docs/Archives",
                zipName =  zipPath + "/newZipArchive.zip", 
                fileName = "Docs/FileClassWork/someFile.txt";

        // создание каталога, в котором хранятся архивы
        File newFolder = new File(zipPath);
        if(newFolder.mkdir()){
            out.println("\nКаталог " + newFolder.getName() + " создан.");
        }else{
            out.println("\nКаталог с таким именем уже существует.");
        }
        try(ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipName)); FileInputStream input = new FileInputStream(fileName)){
            ZipEntry zip_1 = new ZipEntry(fileName);
            zipOut.putNextEntry(zip_1);
            // считывание данных в массив 
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            // добавление содержимого к архиву
            zipOut.write(buffer, 0, buffer.length);
            // закрытие потока
            zipOut.closeEntry();
            out.println("\nАрхив создан.");
        }catch(Exception ex){
            out.println(ex.getMessage());
        }

        // разархивирование файла

        try(ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipName))){
            ZipEntry zip_1; 
            int n = 0;
            String name;
            byte[] buffer;

            while((zip_1 = zipIn.getNextEntry())!=null){
                name = zip_1.getName();
                buffer = zipIn.readAllBytes();
                out.printf("\nИмя файла: %s \tРазмер: %d", name, buffer.length);
                FileOutputStream zipOut = new FileOutputStream(zipPath + "/unzippedFile_" + n + ".txt");
                // распаковка
                zipOut.write(buffer);
                zipOut.flush();
                zipIn.closeEntry();
                zipOut.close();
            }

        }catch(Exception ex){
            out.println(ex.getMessage());
        }
    }   
}
