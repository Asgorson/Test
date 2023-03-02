public class Multithreading_7 {
    /*
     * Синхронизация потоков
     * synchronized() - метод, который создает монитор, в котором работает только один поток. Остальные находятся в режиме ожидания и не могут работать с 
     * другими синхр. методами того же объекта (см. Записи по синхронизации).
     * Может показаться, что метод synchronized() идентичен методу join(), однако это не так. В первом случае ограничивается работа с синхр. методом, с которым может работать 
     * только один поток, однако с остальными методами объекта другие потоки могут работать. Во втором же случае метод join() ставит поток в режим ожидания, пока другой поток 
     * полностью не завершит свою работу. 
     */
    public static void main(String[] args){

        CommonResource comResource = new CommonResource();

        System.out.println("Main thread started...");
        new Thread(new CountThread(comResource), "Thread_1").start();
        new Thread(new CountThread(comResource), "Thread_2").start();
        new Thread(new CountThread(comResource), "Thread_3").start();
        System.out.println("Main thread finished...");

        /*
         * Данный блок кода, очищает терминал, поддерживающий ANSI кодировку
         */
        //System.out.print("\033[H\033[2J");
        //System.out.flush();

        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Данная команда очищает терминал CMD
    }
}

class CommonResource{

    int x;
    String someStr = " ";
    /*
     * В данном случае используются два синхронизированных метода, чтобы показать, что в один момент времени в одном объекте может быть занят только один метод одним потоком
     */
    synchronized public void syncMethod(){                      
        x = 1;  
        for(int i=0; i<5; i++){
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try{
                Thread.sleep(100);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    synchronized public void secondSyncMethod(){
        
        for(int i=0; i<5; i++){
            someStr = someStr + "*";
            System.out.printf("%s %s \n", Thread.currentThread().getName(), someStr);
            try{
                Thread.sleep(100);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
    }
    /*
     * Поток, который выполнил работу с синхронизирующими методами, может параллельно выполнять работу с обычным методом, в одно время с потоком, который работает с синхр. методом
     */
    public void someMethod(){
        for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName() + " execute someMethod");
            try{
                Thread.sleep(100);
            }catch(Exception ex){

            }
           
        }   
    }
}

class CountThread implements Runnable{

    CommonResource comRes;

    CountThread(CommonResource comRes){

        this.comRes=comRes;
    }

    public void run(){
        comRes.syncMethod();
        comRes.secondSyncMethod();
        comRes.someMethod();
    }
}
