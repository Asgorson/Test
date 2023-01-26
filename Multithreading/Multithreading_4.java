import java.time.*;

public class Multithreading_4 {
    /*
     * Пример работы многопоточного программирования
     */
    public static void main(String[] args){

        Thread_1 fThread = new Thread_1("First thread");
        Thread_2 sThread = new Thread_2("Second thread");
        LocalTime someTime = LocalTime.now();

        System.out.println("Main thread started. Time: " + someTime);
        fThread.start();
        //System.out.println("\t");
        sThread.start();
        try{                                         //чтобы главнй поток завершался в конце, необходимо после инициализации дочерних потоков использовать метод join()
            sThread.join();                         
        }catch(Exception ex){                        
            ex.printStackTrace();
        }
        someTime = LocalTime.now();
        System.out.println("\nMain thread finished. Time: " + someTime);

    }
}

class Thread_1 extends Thread{
    
    Thread_1(String name){
        super(name);
    }
    public void run(){
       
        for(int i=0; i<40; i++){
            LocalTime LocTime = LocalTime.now();
            System.out.printf("%d\t%s\tTime: %s\n", i, Thread.currentThread().getName(), LocTime);
            try{
                Thread.sleep(100);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}

class Thread_2 extends Thread{

    Thread_2(String name){
        super(name);
    }

    public void run(){
        
        for(int i=0; i<40; i++){
            LocalTime LocTime = LocalTime.now();
            System.out.printf("%d\t%s\tTime: %s\n", i, Thread.currentThread().getName(), LocTime);
            try{
                Thread.sleep(100);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }   
    }
}
