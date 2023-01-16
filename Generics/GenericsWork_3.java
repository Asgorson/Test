public class GenericsWork_3 {
    public static void main(String args[]){

        Printer printer = new Printer(); 

        String[] people = {"Tom", "Maria", "Ivan"}; 
        int Pamount = people.length; 
        Integer[] numbers  = {100, 200, 300}; 
        int Namount = numbers.length; 
        printer.<String, Integer>print(people, Pamount);
        printer.<Integer, Integer>print(numbers, Namount); 

        Printer LaserJet = new Printer("123_321", 1000);
        Printer LaserJet2000 = new Printer(12343, 1000); 
        System.out.println(LaserJet.getAcc());
        System.out.println(LaserJet2000.getAcc());
    }
}


class Printer{

    private String account;
    private int sum;

    Printer(){}

    <T>Printer(T account, int sum){             //Конструкторы также как и методы используют универсальные параметры.
                                                //Все то же самое.
        this.account= account.toString(); 
        this.sum=sum;

    }
    
    public <T, S> void print(T[] items, S Free ){ //Обобщенные методы также используют универсальные параметры.
                                                  //Только при определении метода универсальные параметры указываются 
                                                  //после всех модификаторов и перед типом возвращаемого значения
        for(T item: items){
            System.out.printf("%s\t", item);
        }
        System.out.println(Free); 
    }

    public String getAcc(){
        return account;
    }
}