public class GenericsLimitation_1 { //ограничение обобщений
                                    //Когда мы указываем универсальный параметр у обобщений, то по умполчанию он может
                                    //представлять любой тип. Однако иногда необходимо, чтобы параметр соответствовал 
                                    //только некоторму ограниченному набору типов. В этом случае прменяются ограничения,
                                    //который позволяют указать базовый клсс, которому должен соответсвовать параметр. 
    public static void main(String[] args){
        TankAccount Account_1 = new TankAccount("Id_1", 1000); 
        TankAccount Account_2 = new TankAccount("Id_2", 2000);
        TankTransaction<TankAccount> Transaction_1 = new TankTransaction<TankAccount>(Account_1, Account_2, 500); 
        //TankTransaction<ShipsAccount> Trans_2 = new TankTransaction(); //приведет к ошибке, так как указан неверный тип 
        Transaction_1.execute(); 
        Transaction_1 = new TankTransaction<TankAccount>(Account_2, Account_1, 100); 
        Transaction_1.execute(); 
        
    }
    
}

class ShipsAccount{ //тестовый тип, который пытается провести транзакцию в "мире танков"

}


class TankAccount{

    private String id;
    private int sum; 

    TankAccount(String id, int sum){
        this.id = id; 
        this.sum = sum; 
    }
    public String getId(){
        return id; 
    }
    public int getSum(){
        return sum;
    }
    public void setSum(int sum){
        this.sum = sum; 
    }
}

class TankTransaction<T extends TankAccount>{ //в качестве универсального параметра передается объект определенного класса
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