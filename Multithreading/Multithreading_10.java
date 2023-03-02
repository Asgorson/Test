import java.util.concurrent.*;

public class Multithreading_10 {

    /*
     * Обмен между потоками. 
     * Exchanger<data_type> -   ласс предназначенный для обмена данными между потоками. Этот класс типизируемый(как и коллекции) и типизируется типом данных, которыми планируется 
     *                          обмениваться. 
     * exchange(data_buffer, timeout, timeunit) -   единственный метод класса, предназначенный для обмена данными между потоками. Имеет три параметра: 1 - буфер, в котором хранятся
     *                                              данные, 2 - время ожидания, 3 - тип временных единиц. Данный метод, передавая данные, также возвращает данные, которые отправил
     *                                              другой поток. Их принимать необязательно. 
     */
    
    public static void main(String[] args){

        Exchanger<String> exch = new Exchanger<String>();
        new Thread(new dataExchanger_1(exch)).start();
        new Thread(new dataExchanger_2(exch)).start();
        //new Thread(new dataExchanger_3(exch)).start(); //Это логично, но для заметки. Обмен данными можно организовать только между двумя потоками. 
    }
}

class dataExchanger_1 implements Runnable{

    Exchanger<String> exch;
    String message;

    dataExchanger_1(Exchanger<String> exch){

        this.exch = exch;
        message = "Hello, world!";
    }

    public void run(){

        try{
            message = exch.exchange(message);
            System.out.println("dataExchanger_1 has received: " + message); 
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

class dataExchanger_2 implements Runnable{

    Exchanger<String> exch;
    String message;

    dataExchanger_2(Exchanger<String> exch){
        this.exch = exch;
        message = "Hello, java!";
    }

    public void run(){
        try{
            message = exch.exchange(message);
            System.out.println("dataExchanger_2 has received: " + message);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

class dataExchanger_3 implements Runnable{
    
    Exchanger<String> exch;
    String message;

    dataExchanger_3(Exchanger<String> exch){
        this.exch = exch;
        message = "Good morning!";
    }

    public void run(){
        try{
            exch.exchange(message);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
