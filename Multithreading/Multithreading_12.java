import java.lang.invoke.TypeDescriptor;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Multithreading_12 {
    /*
     * Блокировки - ReentrantLock, является, по сути, альтернативой оператору Synchronized 
     * Суть блокировки: поток проверяет не занят ли общий ресурс, если нет, поток накладывает блокировку и использует ресурс. После работы с общим ресурсом блокировка снимается. 
     * Если ресурс заблокирован, поток ожидает его освобождения. 
     * Для работы с блокировками используется класс ReentralLock, который в свою очередь использует интерфейс Lock.
     * Интерфейс Lock использует следующие методы:
     * 
     * lock()                                         -     ожидает, пока не будет получена блокировка 
     * lockinterruptibly() throws InterruptExcception -     ожидает, пока не будет получена блокировка, если поток не прерван 
     * tryLock()                                      -     пытается получить блокировку, если блокировка получена, то возвращает true. Если не получена, то возвращает false. 
     *                                                      В отличие от lock() не ожидает получения блокировки, если она недоступна
     * unlock()                                       -     снимает блокировку
     * Condition newCondition()                       -     возвращает объект Condition, который связан с текущей блокировкой  
     */
    public static void main(String[] args){

        GeneralResource someRes = new GeneralResource();
        ReentrantLock locker = new ReentrantLock();  //создание блокировщика
        
        for(int i=0; i<5; i++){
            Thread t = new Thread(new SomeFlow(someRes, locker));
            t.setName("Thread_" + i);
            t.start();
        }
    }
}

class GeneralResource {

    int x = 0;
}

class SomeFlow implements Runnable{

    GeneralResource someGenRes; 
    ReentrantLock locker; 

    SomeFlow(GeneralResource someGenRes, ReentrantLock locker){
        this.someGenRes = someGenRes;
        this.locker = locker;
    }

    public void run(){
        locker.lock(); // блокировка доступа к общему ресурсу, если он свободен, иначе ожидание снятия блокировки и последующая блокировка. 
        try{
            someGenRes.x = 1;
            for(int i=0; i<5; i++){
                System.out.println(Thread.currentThread().getName() + "\tValue: " + someGenRes.x);
                someGenRes.x++;
                Thread.sleep(200);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            locker.unlock(); //снятие блокировки
        }
    }
}