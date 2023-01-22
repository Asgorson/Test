import java.time.*;

public class Multithreading_2 {
    /*
     * Для создания нового потока мы можем создать новый класс, либо наследуя его от класса Thread, либо реализуя в классе 
     * инметрфейс Runnable. 
     * run() - метод, который переопределяется в наследнике класса Thread. В нем содержится тот код, который будет выполнятся в потоке. 
     * start() - метод, который непосредственно запускает метод run().
     * join() - метод, с помощью которого поток, для которого он вызван, завершается до текущего потока. Для всех дочерних потоков надо вызывать метод join()
     */
    public static void main(String[] args){
        LocalTime LocTime = LocalTime.now();
        System.out.println("Main thread started ..." + "Time is: " + LocTime);

        SomeThread someThread = new SomeThread("someThread"); // Данный поток завершится раньше, чем основной поток Main()
        try{
            someThread.start();
            someThread.join(); // если закоментировать данный метод, то глаынй поток завершится раньше этого потока
        }catch(Exception ex){
            ex.printStackTrace();
        }
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

/*
 * Класс, для которого вызывается метод join()
 */
class SomeThread extends Thread{

    SomeThread(String name){
        super(name);
    }

    public void run(){
        LocalTime  LocTime = LocalTime.now();
        System.out.printf("%s started ...\tTime is: %s\n", Thread.currentThread().getName(), LocTime);
        try{
            Thread.sleep(6000);
        } catch(InterruptedException ex) { 
            System.out.println("Thread has been interrupted");
        }
        LocTime = LocalTime.now();
        System.out.printf("%s finished ... \tTime is: %s\n", Thread.currentThread().getName(), LocTime);
    }
}