import java.util.concurrent.TimeUnit;

public class Dog extends Moveable implements Runnable {

    Dog(String name){
        super(name);
    }

    @Override
    public void run() {
        while(movementFinished){
            move();
        }
    }

    @Override
    protected boolean move() {
        try {
            Thread.sleep(2000);
            Vector movingDirection=getDirection();
            Vector currentPosition = coordinates;
            Vector nextPosition = currentPosition.Add(movingDirection);
            farm.lock();
            if (farm.getMovementFinished()){
                return true;
            }
            if (!farm.getBlock(nextPosition).CanBePassed()||farm.getZoneNumber(nextPosition)==4){
                return false;
            }
            farm.setBlock(nextPosition, this);
            farm.setBlock(currentPosition, new Block());
            coordinates=nextPosition;    
        }catch(Exception e){
                //TODO: handle error pls
        }finally{
            farm.unLock();
        }
        return false;
    }

    @Override
    protected Vector getDirection() {
        Vector newDirection = new Vector(0, 0);
        generateX(newDirection);
        generateY(newDirection);
        return newDirection;
    }
    
}
