import java.util.concurrent.locks.*;

public class Multithreading_13 {
    /*
     * Условия в блокировках 
     * 
     * Данные блокировки аналогичны блокировкам wait, notify, notifyAll в synchronized методах.
     * await     - оиждает, пока не будет выполнено определенное условие и пока другой поток не вызовет метод signal/signalAll
     * signal    - сигнализирует о том, что поток, у которого ранее был вызван метод await, может продолжать работу. 
     * signalAll - сигнализирует всем потокам, у которых ранее был вызван метод await. 
     */
    public static void main(String[] args){

        SomeStore someStore = new SomeStore(); 
        Producer_ prod = new Producer_(someStore);
        Consumer_ cons = new Consumer_(someStore);
        new Thread(prod).start();
        new Thread(cons).start();

    }
    
}

class SomeStore{
    private int product = 0;
    ReentrantLock locker; 
    Condition condition; 

    SomeStore(){
        locker = new ReentrantLock(); // Создание блокировки 
        condition = locker.newCondition(); // Получение условия, связанного с блокировкой 
    }
    
    public void get(){
        locker.lock();
        try{
            while(product<1){
                condition.await();
            }
            product--;
            System.out.println("Покупатель купил один товар: ");
            System.out.println("Товаров на складе: " + product);
            condition.signalAll();  // Сигнал к продолжению работы у потока, в котором ранее был вызван метод await()
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            locker.unlock();
        }
    }

    public void put(){
        locker.lock();
        try{
            while(product>3){
                condition.await();
            }
            product++;
            System.out.println("Производитель добавил один товар: ");
            System.out.println("Товаров на складе: " + product);
            condition.signalAll();  // Сигнал к продолжению работы у потока, в котором ранее был вызван метод await()
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            locker.unlock();
        }
    }

}

class Producer_ implements Runnable{
    
    SomeStore someStore; 

    Producer_(SomeStore someStore){
        this.someStore = someStore; 
    }

    public void run(){
        for(int i=1; i<6; i++){
            someStore.put();
        }
    }
}

class Consumer_ implements Runnable{

    SomeStore someStore; 

    Consumer_(SomeStore someStore){
        this.someStore = someStore;
    }

    public void run(){
        for(int i=1; i<6; i++){
            someStore.get();
        }
    }
}