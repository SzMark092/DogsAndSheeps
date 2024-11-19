import java.util.concurrent.locks.ReentrantLock;

public class Farm {
    private Block[][] field;
    private final ReentrantLock lock;
        private boolean movementfinished;
        
        Farm(int size){
            field=new Block[size][size];
            lock = new ReentrantLock();
        }
    
        public Block getBlock(Vector coord){
            return field[coord.x][coord.y];
        }
        public void setBlock(Vector coord,Block newBlock){
            field[coord.x][coord.y]=newBlock;
        }
    
        public void lock(){
            lock.lock();
        }
        public void unLock(){
            lock.unlock();
        }
    
        public boolean isOccupied(Vector nextPosition) {
            return getBlock(nextPosition).CanBePassed();        
        }
    
        public int getZoneNumber(Vector position){
            return ((position.x-2)/3)*((position.y-2)/3);
        }
    
        public void changeMovementFinished(){
            movementfinished=!movementfinished;
        }

        public boolean getMovementFinished(){
            return movementfinished;
        }
}