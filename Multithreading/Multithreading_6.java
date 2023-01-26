public class Multithreading_6 {
    /*
     * Прервывание процесса при помощи метода interrupt()
     */
    public static void main(String[] args){

        Thread somePr = new Thread(new someProc(),"someThread");
        System.out.printf("Main thread started ...\n");
        somePr.start();
        try{
            Thread.sleep(5000);
            somePr.interrupt();
            Thread.sleep(1000);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Main thread finished ...");
    }
    
}

class someProc implements Runnable{

    /*someProc(String name){
        super(name);
    }*/

    public void run(){

        int counter = 0;
        System.out.printf("Thread %s started ... \n", Thread.currentThread().getName());
        /*while(!Thread.currentThread().isInterrupted()){
            try{                                
                Thread.sleep(500);
            }catch(Exception ex){                           // Если, при использовании констр. try, catch не использовать break, цикл не завершится, так как,
                ex.printStackTrace();                       // при перехвате исключения, статус потока сбрасывается, и метод isInterrupted() до сих пор будет возвращать false.
                break;
            }                                               // Или можно занести весь цикл в конструкцию try, catch
         
            System.out.println("Loop: " + counter++);       
        }*/
           
        try{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("Loop: " + counter++);
                Thread.sleep(500);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
             
        System.out.printf("Thread %s finished ... \n", Thread.currentThread().getName());
    }
}