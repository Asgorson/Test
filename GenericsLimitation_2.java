public class GenericsLimitation_2{

    public static void main(String[] args){ // В качестве ограничений могут выступать и другие обобщения, 
                                            // которые сами могут иметь ограничения. 

        TankAccount<String> TankAkk_1 = new TankAccount<String>("1234", 1000);
        TankAccount<String> TankAkk_2 = new TankAccount<String>("4443", 1500); 
        TankTransaction<TankAccount<String>>  Trans_1 = new TankTransaction<TankAccount<String>>(TankAkk_1, TankAkk_2, 300);
        Trans_1.execute();
        Trans_1  = new TankTransaction<TankAccount<String>>(TankAkk_2, TankAkk_1, 200);
        Trans_1.execute();
    }   

}

class TankAccount<T>{

    private T id;
    private int sum; 

    TankAccount(T id, int sum){
        this.id = id; 
        this.sum = sum; 
    }
    public T getId(){
        return id; 
    }
    public int getSum(){
        return sum;
    }
    public void setSum(int sum){
        this.sum = sum; 
    }
}

class TankTransaction<T extends TankAccount<String>>{
    private T from; 
    private T to; 
    private int sum;

    TankTransaction(T from, T to, int sum){
        this.from = from; 
        this.to = to; 
        this.sum = sum; 
    }

    public void execute(){
        if(from.getSum()>sum){
            from.setSum(from.getSum()-sum);
            to.setSum(to.getSum()+sum);
            System.out.printf("Account %s: %d \nAccount %s: %d \n", from.getId(), from.getSum(), to.getId(), to.getSum());
        }else {
            System.out.printf("Operation is invalid.");
        }
    }
}