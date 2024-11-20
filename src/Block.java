public class Block {
    String name;
    Block(){
        name=".";
    }
    Block(String name){
        this.name=name;
    }
    public boolean CanBePassed(){
        return true;
    }

    public String toString(){
        return name;
    }
}