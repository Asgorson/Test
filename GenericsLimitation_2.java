public class GenericsLimitation_2{

    public static void main(String[] args){ // В качестве ограничений могут выступать и другие обобщения, 
                                            // которые сами могут иметь ограничения. 

        TankAccount_<String> TankAkk_1 = new TankAccount_<String>("1234", 1000);
        TankAccount_<String> TankAkk_2 = new TankAccount_<String>("4443", 1500); 
        TankTransaction_<TankAccount_<String>>  Trans_1 = new TankTransaction_<TankAccount_<String>>(TankAkk_1, TankAkk_2, 300);
        Trans_1.execute();
        Trans_1  = new TankTransaction_<TankAccount_<String>>(TankAkk_2, TankAkk_1, 200);
        Trans_1.execute();
    }   

}

class TankAccount_<T>{

    private T id;
    private int sum; 

    TankAccount_(T id, int sum){
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

class TankTransaction_<T extends TankAccount_<String>>{
    private T from; 
    private T to; 
    private int sum;

    TankTransaction_(T from, T to, int sum){
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