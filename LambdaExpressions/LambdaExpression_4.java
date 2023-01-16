public class LambdaExpression_4 {

    /*
     * Ссылки на конструкторы. 
     * Так же как и в примере LabdaExpressions_3 мы можем использовать конструкторы.
     */
    public static void main(String[] args){

        UserBuilder UB = User::new;
        User user_1 = UB.create("Tom");
        System.out.println("Name is: " + user_1.getName());
    }
}

interface UserBuilder{

    User create(String name);    
    
}

class User{
    private String name; 

    User(String name){
        this.name = name;
    }

    String getName(){
        return name; 
    }

}