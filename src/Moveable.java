import java.util.Random;

public abstract class Moveable extends Block  {
    protected static boolean movementFinished;
    public  Vector coordinates;
    protected Farm farm;

    protected abstract boolean move();
    protected abstract Vector getDirection();

    protected void generateX(Vector v){
        Random rand = new Random();
        v.x=rand.nextInt(3)-3;
    }

    protected void generateY(Vector v){
        Random rand = new Random();

        do {            
            v.y=rand.nextInt(3)-3;
        } while (v.x+v.y==0);
    }
}
