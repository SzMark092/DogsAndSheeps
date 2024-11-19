public class Vector {
    public int x;
    public int y;
    public Vector(int newX,int newY){
        x=newX;
        y=newY;
    }

    public Vector Add(Vector v){
            return new Vector(x+v.x, y+v.y);
    }
}
