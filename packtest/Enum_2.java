package packtest;
//Перечисления могут использоваться в классах для хранения данных
public class Enum_2 {
    public static void main(String args[]){

        BookBase BookB = new BookBase("Дмитрий Глуховский", "Метро 2033",BookGanre.FANTASTIC);
        BookB.ShowData();

        System.out.printf("Книга (%s) автора (%s) имеет жанр (%s)\n", BookB.BookName, BookB.AuthorName, BookB.Ganre);
        
        //Методы перечислений
        // метод values() выводит массив всех констант перечисления
        BookGanre book[] = BookGanre.values();
        for (BookGanre s : book){
            System.out.printf("%s\n", s);
        }

        // метод ordinal() выводит порядковый номер константы. 
        System.out.printf("Ordinal scale of constant (%s): %s\n", BookGanre.NOVEL,BookGanre.NOVEL.ordinal());
        
        // работа с полями и методами enum
        Color TextColor = Color.RED;
        System.out.printf("Color (%s) code is: %s; Ordinal scale is: %s \n", TextColor, TextColor.GetCode(), TextColor.ordinal());
        
        //работа с методами отдельных констант
        Operation Sum = Operation.SUM; 
        System.out.printf("Result of (%s) operation: (%s)\n", Sum, Sum.action(4, 5));
    }
    
}

class BookBase{
    public String AuthorName; 
    public String BookName; 
    BookGanre Ganre; // хранит данные

    BookBase(String AuthorName, String BookName, BookGanre Ganre){
        this.AuthorName = AuthorName; 
        this.BookName = BookName;
        this.Ganre = Ganre;
    }
    public void ShowData(){
        System.out.printf("Book (%s) of (%s) has (%s) ganre.\n", BookName, AuthorName, Ganre);
    }
}

enum BookGanre{
    NOVEL, 
    FANTASY,
    FANTASTIC
}

//Перечисления, как и обычные классы, могут определять конструкторы, поля и методы.
enum Color{
    RED("#FF0000"),
    BLUE("#0000FF"),
    WHITE("#00FF00");

    private String code ;

    Color(String code){ // конструктор по умолчанию приватный
        this.code=code; 
    }
    public String GetCode(){
        return code; 
    }
}

//Отдельные константы могут иметь методы
enum Operation{

    SUM{
        public int action(int x, int y){
            return x+y;
        }
    },
    DIF{
        public int action(int x, int y){
            return x-y;
        }
    },
    /*SUB{
        public float action2(float x, float y){ только один абстрактный метод
            return x/y;
        }
    },*/
    MUL{
        public int action(int x, int y){
            return x*y; 
        }
    };
    public abstract int action(int x, int y); 
    //public abstract float action2(float x, float y); 

}