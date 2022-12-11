import java.time.*;

public class Multithreading_2 {
    /*
     * Для создания нового потока мы можем создать новый класс, либо наследуя его от класса Thread, либо реализуя в классе 
     * инметрфейс Runnable. 
     */
    public static void main(String[] args){
        LocalTime LocTime = LocalTime.now();
        System.out.println("Main thread started ..." + "Time is: " + LocTime);
        new JThread("JThread").start();
        for(int i=0; i<6; i++){
            new JThread("JThread" + i).start(); //он запускает метод run()
        }
        LocTime = LocalTime.now();
        System.out.println("Main thread finished ..." + "Time is: " + LocTime);
    }
}

class JThread extends Thread{
    
    JThread(String name){
        super(name);
    }

    public void run(){

        LocalTime LocTime = LocalTime.now();
        System.out.printf("%s started ...\tTime is: %s\n", Thread.currentThread().getName(), LocTime);
        try{
            Thread.sleep(5000);
        } catch(InterruptedException ex) { 
            System.out.println("Thread has been interrupted");
        }
        LocTime = LocalTime.now();
        System.out.printf("%s finished ... \tTime is: %s\n", Thread.currentThread().getName(), LocTime);
    }
}