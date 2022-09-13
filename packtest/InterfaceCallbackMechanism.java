//Интерфейсы в механизме обратного вызова
package packtest;

public class InterfaceCallbackMechanism {
    public static void main(String args[]){
        Button button = new Button(new ButtonClickHandler()); 
        button.click(); 
        button.click(); 
        button.click(); 


        //Механизм обратного вызова в виде анонимных объектов
    }
}

interface EventHandler{

    void execute(); 
}

class ButtonClickHandler implements EventHandler{

    public void execute(){
        System.out.printf("Кнопка нажата.\n");  
    }

}

class Button{

    EventHandler handler;

    Button(EventHandler action){
        this.handler = action;
    }
    public void click(){
        handler.execute();
    }
}