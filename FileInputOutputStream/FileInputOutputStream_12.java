import java.io.*;
import static java.lang.System.out;

public class FileInputOutputStream_12 {
    /*
     * File - класс для работы с файлами и каталогами. Он не работает с потоками, его задача - управление информацией о файлах и каталогах.
     * Конструкторы: 
     * File(String pathToFolder) 
     * File(String pathToFolder, String fileName)
     * File(File folder, String fileName)
     * 
     * Методы:
     * boolean createNewFile() - создает новый файл по пути, который передан в конструктор. Если удачно возвращает true, иначе false. 
     * boolean delete() - удаляет каталог или каталог, который передан в конструктор. 
     * boolean exists() - проверяет, существует ли по указанному пути в коснтрукторе файл или каталог. 
     * String getAbsolutPath() - возвращает абсолютный путь для пути, указанного в конструкторе. 
     * String getName() - возвращает краткое имя файла или каталога. 
     * String getParent() - возвращает имя родительского каталога. 
     * boolean isDerectory() - возвращает true, если по указанному пути находится каталог. 
     * boolean isFile() - возвращает true, если по указанному пути находится файл. 
     * boolean isHidden() - взвращает true, если каталог или файл скрытый. 
     * long length() - возвращает размер файла в байтах 
     * long lastModified() - возвращает время последнего изменения файла или каталога. Значение представляет количество миллисекунд прошедших с начала эпохи Linux. 
     * String[] list() - возвращает массив файлов и подкаталогов, располагающихся в данном каталоге. 
     * File[] listFiles() - возвращает массив файлов и подкаталогов, располагающихся в данном каталоге.
     * boolean mkdir() - создает новый каталог и при удачном создании возвращает значение true. 
     * boolean renameTo() - переименовывает файл или каталог. 
     * 
     */
    public static void main(String[] args){
        /*
         * Работа с каталогами 
         */
        File dir = new File("Docs");
        if(dir.isDirectory()){
            for(File s: dir.listFiles()){
                if(s.isDirectory()){
                    out.println(s.getName() + "\t folder");
                }else if(s.isFile()){
                    out.println(s.getName() + "\t file");
                }else{
                    out.println("\nНеизвестный файл.");
                }
            }
        }
        /*
         * Создание каталога
         */
        File someDir = new File("Docs/NewDir_withFileClass");
        if(someDir.mkdir()){
            out.println("\nКаталог создан.");
        }else{
            out.println("\nТакое имя уже существует.");
        }
        /*
         * Переименование каталога
         */
        File newDirName = new File("Docs/RenamedDir_withFileClass");
        if(someDir.renameTo(newDirName)){
            out.println("\nКаталог переименован.");
        }else{
            out.println("\nТакое имя уже есть.");
        }
        /*
         * Удаление каталога
         */
        if(newDirName.delete()){
            out.println("\nКатлог " + newDirName.getName() + " удален.");
        }else{
            out.println("\nУказанного каталога не существует.");
        }
        /*
         * Работа с файлами
         */
        //сздание каталога
        File someFolder = new File("Docs/FileClassWork");
        if(someFolder.mkdir()){
            out.println("\nФайл " + someFolder.getName() + " создан.");
        }else{
            out.println("\nФвйл с именем " + someFolder.getName() + " уже существует.");
        }
        //создание объекта для нового файла
        File someFile = new File("Docs/FileClassWork/someFile.pdf");
        out.println("\nИмя родительского каталога: " + someFile.getParent());
        if(someFile.exists()){
            out.println("\nФайл существует.");
        }else{
            out.println("\nФайл с именем " + someFile.getName() + " не найден.");
        }
        if(someFile.canRead()){
            out.println("\nФайл доступен для чтения.");
        }else{
            out.println("\nФайл не доступен для чтения.");
        }
        if(someFile.canWrite()){
            out.println("\nФайл доступен для записи.");
        }else{
            out.println("\nФайл не доступен для записи.");
        }
        //непосредственное создание файла 
        try{
            if(someFile.createNewFile()){
                out.println("\nФайл создан");
            }else{
                out.println("\nФайл с таким именем уже существует.");
            }
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
        out.println("\nРазмер файла: " + someFile.length());
        //запись данных в файл, созданный программно
        byte buffer[] = null;
        String someText = new String(" \nХорошему человеку и небо помогает.");
        try{
            buffer = someText.getBytes("Windows-1251"); //в скобках указывается годировка, в которой будет данный текст
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
        try(FileOutputStream outD = new FileOutputStream(someFile, false); BufferedOutputStream outData = new BufferedOutputStream(out)){
            outD.write(buffer);
            out.println("\nДанные записаны.");
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
    }
}
