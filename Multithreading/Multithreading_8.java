public class Multithreading_8 {
    /*
     * Работа с методами(регулируют работу синхр. метода в мониторе):
     * wait() - освобождает монитор и переводит вызывающий поток в режим ожидания до тех пор, пока другой поток не вызовет метод notify()
     * notify() - возобновляет работу потока, у которого ранее был вызван метод wait()
     * notifyAll() -  возобновляет работу всех потоков, у которых ранее был вызван метод wait()
     */
    public static void main(String[] args){

        Store store = new Store();
        
        Thread someProdThread = new Thread(new Producer(store), "someProdThread");
        Thread someConsThread = new Thread(new Consumer(store), "someConsThread");
        someConsThread.start();
        someProdThread.start();
        
        
    }
    
}

class Store{

    private int product = 0;

    public synchronized void get(){
        while(product<1){
            try{
                wait();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        product--;
        System.out.println("Покупатель купил один товар");
        System.out.println("Товаров на скалде: " + product);
        notify();
    }

    public synchronized void put(){
        while(product>3){
            try{
                wait();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        product++;
        System.out.println("Производитель добавил один товар");
        System.out.println("Товаров на складе " + product);
        notify();
    }
}

class Producer implements Runnable{
    
    Store store;
    
    Producer(Store store){
        this.store = store;
    }

    public void run(){

        for(int i=0; i<6; i++){
            store.put();
            try{
                Thread.sleep(1000);
            }catch(Exception ex){}
            
        }
    }
}

class Consumer implements Runnable{
    
    Store store;

    Consumer(Store store){
        this.store = store;
    }

    public void run(){

        for(int i=0; i<6; i++){
            store.get();
            try{
                Thread.sleep(2000);
            }catch(Exception ex){}
        }
    }
}