public class GenericsLimitation_3 {
    public static void main(String[] args){

        TtankAccount Acc_1 = new TtankAccount("1234", 4000); 
        TtankAccount Acc_2 = new TtankAccount("12345", 6000);
        TtankTransaction<TtankAccount>  trans_1 = new TtankTransaction<TtankAccount>(Acc_1, Acc_2, 3000);
        trans_1.execute();
    }
    
}
class Ships{

}
interface TtankAccountable{ //В качестве ограничений могут выступать интерфейсы. 
                           //Множественные ограничения также можно установить 
    String getId();
    int getSum();
    void setSum(int sum);
} 

class TtankAccount implements TtankAccountable{
    private String id;
    private int sum; 

    TtankAccount(String id, int sum){
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

class TtankTransaction<T extends /*TtankAccount & */TtankAccountable>{ //передаваемый на место унивесального параметра тип должен 
                                                                   //реализовывать данный 
                                                                   //интерфейс. 
                                                                   //Получается поэтому вместо слова implements мы используем  
                                                                   //extends так как в него передается объект класса
                                                                   //в комментах указан вариант множественного ограничения.
                                                                   //В данном случае это означает, что данный класс может работать
                                                                   //только с наследниками класса TtankAccount и объектами 
                                                                   //реализующими интерфейс TtankAccountable

    private T from; 
    private T to; 
    private int sum;

    TtankTransaction(T from, T to, int sum){
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