///////////////////////////////////////
// Осуществление полного копирования //
///////////////////////////////////////

                                                                                     //Airplane airplane_1 ------>   Airplane
                                                                                     //                           ****************
                                                                                     //                           *     name     *       YawPitchRoll
                                                                                     //                           ****************       ************
                                                                                     //                           * YawPitchRoll *-----> * someData *
                                                                                     //                           ****************       ************
                                                                                     //                                                        
                                                                                     //                                                       
                                                                                     //                                                       
                                                                                     //Airplane airplane_2 ------>   Airplane                  
                                                                                     //                           ****************
                                                                                     //                           *     name     *       YawPitchRoll
                                                                                     //                           ****************       ************
                                                                                     //                           * YawPitchRoll *-----> * someData *
                                                                                     //                           ****************       ************
public class ReferenceTypeAndCloningObjects_{

    public static void main(String[] args){
        try{
            Computer PC_1 = new Computer("Asus", "RTX2040");
            Computer PC_2 = PC_1.clone();
            PC_2.setVDName("AMD560");
            System.out.println("Data of PC_1: " + PC_1.getVDName());
            System.out.println("Data of PC_2: " + PC_2.getVDName());
        }catch (CloneNotSupportedException ex ){
            System.out.println("Cloneable is not implemented.");
        }
        
    }
}

class Computer implements Cloneable {

    private String name; 
    private VideoCard VD; 

    public Computer(String name, String VDName){
        this.name = name;
        this.VD = new VideoCard(VDName);
    }

    public String getName(){
        return name; 
    }
    public void setName(String name){
        this.name = name; 
    }
    public void setVDName(String name){
        VD.setName(name);
    }
    public String getVDName(){
        return VD.getName();
    }

    public Computer clone() throws CloneNotSupportedException{
        Computer PC_1 = (Computer) super.clone(); 
        PC_1.VD = (VideoCard) VD.clone();
        return PC_1; 
    }

}
class VideoCard implements Cloneable{
    private String modelName;

    public VideoCard(String modelName){
        this.modelName = modelName; 
    }

    public String getName(){
        return modelName;
    }
    public void setName(String modelName){
        this.modelName = modelName;
    }
    public VideoCard clone() throws CloneNotSupportedException{
        return (VideoCard) super.clone();
    }
}