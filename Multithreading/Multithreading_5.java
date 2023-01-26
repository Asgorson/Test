
public class Multithreading_5 {
    /*
     * Прерывание потока на определенное время с использованием логической переменной
     * 
     */
    public static void main(String[] args){
        
        System.out.println("Main thread started...");
        subThread fThread = new subThread("myThread");
        fThread.start();
        try{
            Thread.sleep(6000);         //приостановка главного потока main()
            fThread.disable();
            //Thread.sleep(1000);            
        }catch(Exception ex){
            System.out.println("Thread has been interrupted.");
        }
        System.out.println("Main thread finished...");
    }
}

class subThread extends Thread{

    private boolean isAlive; 

    subThread(String name){
        super(name);
        isAlive = true; 
    }

    public void disable(){
        isAlive = false;
    }

    public void run(){
        
        System.out.printf("%s started ...\n", currentThread().getName());
        int counter = 0;
        while(isAlive){
            System.out.println("Loop " + counter++);
            try{
                Thread.sleep(500);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        System.out.printf("%s finished ...\n", currentThread().getName());
    }
}