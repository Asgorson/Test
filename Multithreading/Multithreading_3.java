import java.time.*;

public class Multithreading_3 {
    /*
     * Другой способ создания потока - реализация интерфейса runnable, в котором присутствует один мето run()
     */
    public static void main(String[] args){

        LocalTime someTime = LocalTime.now();
        System.out.println("Main thread started...\tTime is: " + someTime);
        Thread st = new Thread(new sThread(), "someThread");
        st.start();
        System.out.println("Main thread finished...\tTime is: " + someTime);
    }
}

class sThread implements Runnable{
    
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
