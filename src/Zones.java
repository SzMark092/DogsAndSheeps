import java.util.ArrayList;
import java.util.List;

public class Zones {
    List<Zone> zones;
    Zones(int xStep, int yStep){
        zones=new ArrayList<Zone>();
        
        for (int i = 0; i < 3; i++) {
            int xStart =i*xStep;
            int xEnd = (i+1)*xStep;
            for (int j = 0; j < 3; j++) {
                zones.add(
                    new Zone(
                    new Vector(xStart, j*yStep),
                    new Vector(xEnd, (j+1)*yStep)
                ));
            }                
        }
    }

    public Zone getZone(int zoneNumber){
        return zones.get(zoneNumber);
    }
}
