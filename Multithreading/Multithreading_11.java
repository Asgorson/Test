import java.util.concurrent.*;

public class Multithreading_11 {

    /*
     * Phaser - позволяет синхронизировать потоки, представляющие отдельную фазу или стадию выполнения общего действия.
     * 
     * Конструкторы:
     * Phaser(Phaser parent, int parties). int parties - количество потоков, которые должны выполнять все фазы действия. Phaser parent - родительский объект. 
     *  
     * Методы: 
     * register() - регистрирует участника, который выполняет фазы и возвращает номер текущей фазы - обычно фаза 0.
     * arrive() - сообщает, что участник завершил фазу и возвращает ее номер. 
     * arriveAndAwaitAdvance() - аналогично arrive(), но заставляет phaser ожидать завершения фазы остальными участниками.
     * arriveAndDeregister() - сообщает о завершении всех фаз учатсником и снимает его с регистрации. Возвращает номер текущей фазы или отрицательное число, если синхронизатор 
     *                          phaer завершил работу. 
     * getPhase() - возвращает номер текущей фазы. 
     * 
     */
    public static void main(String[] args){

        Phaser phaser = new Phaser(2);
        new Thread(new PhaseThread(phaser, "PhaseThread_1")).start(); 
        new Thread(new PhaseThread(phaser, "PhaseThread_2")).start(); 

        /*
         * ожидается завершение 0 фазы
         */
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " заверешена");
        
        /*
         * ожидается завершение 1 фазы
         */
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " заверешена");

        /*
         * ожидается завершение 2 фазы
         */
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " заверешена");

        phaser.arriveAndDeregister();
    }
}

class PhaseThread implements Runnable{

    Phaser phaser; 
    String name; 

    PhaseThread(Phaser phaser, String name){
        this.phaser = phaser;
        this.name = name; 
        phaser.register();          //Регистрация участника
    }

    public void run(){
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();         //сообщается, что первая фаза завершена

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();         //сообщается, что вторая фаза завершена

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndDeregister();         //сообщается, что фазы звершены и удаляет участников
        
    }
}