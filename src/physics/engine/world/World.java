package physics.engine.world;

import physics.engine.objs.BaseObject;

import java.util.LinkedList;

public class World {
    private double tickTime=0.01;//单位：s
    private final LinkedList<BaseObject> objects=new LinkedList<>();
    public void tick(){

    }
    public void addObject(BaseObject o){
        objects.add(o);
    }
    public void removeObject(BaseObject o){
        objects.remove(o);
    }

    public void setTickTime(double time){
        this.tickTime=time;
    }

    public double getTickTime() {
        return tickTime;
    }
    
}
