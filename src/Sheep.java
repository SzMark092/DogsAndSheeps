import java.util.concurrent.TimeUnit;

public class Sheep extends Moveable implements Runnable{
    Sheep(String name){
        super(name);
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
            if (!farm.getBlock(nextPosition).CanBePassed()){
                return false;
            }
            
            if (farm.getBlock(nextPosition) instanceof Door){
                farm.setMovementFinished(true);
                return true;
            }

            farm.setBlock(nextPosition, this);
            farm.setBlock(currentPosition, new Block());
            coordinates=nextPosition;  
        }catch(Exception e){
            
        }finally{
            farm.unLock();
        }
        return false;
    }

    @Override
    protected Vector getDirection() {
        Vector direction = new Vector(0, 0); 
        if (isDogOnLeft()) {
            direction.x=1;
        }else if(isDogOnRight()){
            direction.x=-1;
        } else {
            generateX(direction);
        }

        if (isDogOnTop()){
            direction.y=-1;
        }else if(isDogUnder()){
            direction.y=1;
        }else{
            generateY(direction);
        }
    
        return direction;
    }

    private boolean isDogOnLeft(){
         int x = -1;
         int[] ys = {-1,0,1};
         for (int y : ys) {
            if(farm.getBlock(coordinates.Add(new Vector(x, y))) instanceof Dog){
                return true;
            }
         }
         return false;
    }

    private boolean isDogOnRight(){
        int x = 1;
        int[] ys = {-1,0,1};
        for (int y : ys) {
           if(farm.getBlock(coordinates.Add(new Vector(x, y))) instanceof Dog){
               return true;
           }
        }
        return false;
   }

   private boolean isDogOnTop(){
        int y = 1;
        int[] xs = {-1,0,1};
        for (int x : xs) {
        if(farm.getBlock(coordinates.Add(new Vector(x, y))) instanceof Dog){
            return true;
        }
        }
        return false;
    }

    private boolean isDogUnder(){
        int y = -1;
        int[] xs = {-1,0,1};
        for (int x : xs) {
        if(farm.getBlock(coordinates.Add(new Vector(x, y))) instanceof Dog){
            return true;
        }
        }
        return false;
    }

    @Override
    public void run() {
        while (!movementFinished) {
            if (move()){
                break;
            }
        }
    }
    
}