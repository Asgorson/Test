// позволяют уйти от жесткого определения используемых типов. 
public class GenericsWork {
    public static void main(String args[]){
        
        Account<String> acc_1 = new Account<String>("2345", 5000); 
        String Acc_1_id = acc_1.getId(); 
        System.out.printf("Account (string) id: %s\n", Acc_1_id); 

        Account<Integer> acc_2 = new Account<Integer>(2345, 6000);
        int Acc_2_id = acc_2.getId(); 
        System.out.printf("Account (int) id: %d\n", Acc_2_id);
        
    }
}

class Account <T>{  // <T> - универсальный параметр. В него можно подставить любой тип данных. 
                    // в угловых скобках <может быть любое название>. Через запятую, можно указать еще
                    // несколько универсальных параметров.
    private T id;  
    private int sum; 

    Account(T id, int sum){
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



 