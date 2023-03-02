import java.util.concurrent.*;

public class Multithreading_9 {
    /*
     * Работа с семафомрами
     * Класс Semaphore - еще одно средство синхронизации для доступа нескольких потоков к одному ресурсу. Предоставление доступа осуществляется по счетчику и порядку доступа 
     *                   Semaphore(int permits, boolean fair). Permits - определяет количество потоков, которые могут работать с общим ресурсом, при этом счетчик уменьшается на 1 
     *                   с подлючением одного потока. Если счетчик равен нулю, то поток блокируется и ожиадет разрешения счетчика(пока он не увеличится на единицу). 
     *                   Fair - определяет будут ли потоки иметь доступ в том порядке, в каком они запросили доступ(true) или в случайном(false).   
     * Метод acquire -   используется для получения разрешиения у семафора. Если одно acquire(), если несколько acquire(int permits). После вызова этого метода, пока поток 
     *                   не получил разрешения, он блокируется.
     * Метод release -   вызывается после окончания работы с ресурсом. Если одно release(), если несколько release(int permits).
     * 
     */
    public static void main(String[] args){

        Semaphore someSemaphore = new Semaphore(1);
        ComResource ComRes = new ComResource();
        Thread thread_1 = new Thread(new someThreadClass(ComRes, someSemaphore, "Thread_1"));
        Thread thread_2 = new Thread(new someThreadClass(ComRes, someSemaphore, "Thread_2"));
        Thread thread_3 = new Thread(new someThreadClass(ComRes, someSemaphore, "Thread_3"));
        thread_1.start();
        thread_2.start();
        thread_3.start();
    }
}

class ComResource{
    int x = 0;

    public void permitMethod(){

    }
}

class someThreadClass implements Runnable{

    ComResource comRes;
    Semaphore someSem; 
    String name; 

    someThreadClass(ComResource comRes, Semaphore someSem, String name){

        this.comRes = comRes;
        this.someSem = someSem;
        this.name = name;
    }

    public void run(){
        
        try{
            System.out.println(name + " ожидает разрешения");
            someSem.acquire();
            comRes.x = 1;
            for(int i=0; i<5; i++){
                System.out.println(this.name + ": " + comRes.x);
                comRes.x++;
                Thread.sleep(500);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(name + " освобождает разрешение");
        someSem.release();
    }
}