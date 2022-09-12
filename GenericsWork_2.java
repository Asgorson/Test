public class GenericsWork_2 {

    public static void main(String args[]){

        AccountTable<String> Acc_1 = new Account_s("123", 3400); 
        Account_s Acc_2 = new Account_s("1243", 2000); 
        System.out.printf("Acc_1 data: %s\n", Acc_1.getId());       
        System.out.printf("Acc_2 data: %s\n", Acc_2.getId());  

        
        Clients Clnts_1 = new Clients(123,1200);
        AccountTable<Integer> Clnts_2 = new Clients(1234, 3200);

        //использование обобщенного класса 
        Bank<String> acc_1 = new Bank<String>("war123", 30000);
        Bank<Integer> acc_2 = new Bank<Integer>(551122, 40000);
        AccountTable<Integer> acc_3 = new Bank<Integer>(123, 4000); //другой вариант объявления 
        String row = acc_1.getId(); 
        System.out.printf("String id is: %s\n", row); 
        int row2 = acc_2.getId(); 
        System.out.printf("Integer id is: %d\n", row2); 

    }
    
}

interface AccountTable<G>{ //В этом случае реализован вариант, когда при реализации для универсального параметра 
                           //интерфейса задается конктретный тип. Класс, реализующий интерфейс, жестко привязан к этому типу
                           //Использование обобщенного интерфейса позволяет разным классам, использующим его, 
                           //использовать свои типы данных. Ниже представлено два примера. 
                           //Это первый вариант. 
                           //Второй вариант - определение обобщенного класса, который также использует тот же универсальный
                           // параметр. 

    G getId();
    void setSum(int sum); 

}

class Clients implements AccountTable<Integer>{ //Использование жесткой привязки к типу. 
    private int id; 
    private int sum; 

    Clients (int id, int sum){
        this.id = id; 
        this.sum = sum; 
    }

    public Integer getId(){
        return id; 
    }

    public void setSum(int sum){
        this.sum = sum; 
    }
}

class Account_s implements AccountTable<String>{ //Использование жесткой привязки к типу. 
    
    private String id; 
    private int sum; 

    Account_s (String id, int sum){
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

class Bank<Gg> implements AccountTable<Gg>{ //Определение обобщенного класса, который тоже использует 
                                            //универсальный параметр. 
    
    private Gg id;
    private int sum;

    Bank(Gg id, int sum){
        this.id = id; 
        this.sum = sum; 
    }

    public Gg getId(){
        return id;
    }

    public int getSum(){
        return sum; 
    }

    public void setSum(int sum){
        this.sum = sum; 
    }

}