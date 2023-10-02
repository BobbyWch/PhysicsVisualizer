package physics.engine.world;

import physics.engine.TickListener;
import physics.engine.model.Ticking;
import physics.engine.objs.BaseObject;
import physics.engine.objs.CanPaint;

import java.awt.*;
import java.util.LinkedList;

public class World implements CanPaint {
    private double tickTime=0.01;//单位：s
    private final LinkedList<BaseObject> objects=new LinkedList<>();
    private final LinkedList<Ticking> tickings=new LinkedList<>();
    public void runTicksAndWait(int tickNum, TickListener l) throws InterruptedException {
        int delay= ((int) (tickTime * 1000));
        for (Ticking t:tickings){
            t.prepareTicking();
        }
        long t1=System.currentTimeMillis(),t2;
        for (int i=0;i<tickNum;i++){
            tick();
            t2=System.currentTimeMillis();
            if (l!=null) l.tickEnd();
            if (t2-t1<delay){
                Thread.sleep(delay-t2+t1);
            }
            t1=t2;
        }
    }
    private void tick(){
        for (Ticking t:tickings){
            t.tick();
        }
    }
    public void addObject(BaseObject o){
        objects.add(o);
        if (o instanceof Ticking t) tickings.add(t);
    }
    public void removeObject(BaseObject o){
        objects.remove(o);
        if (o instanceof Ticking t) tickings.remove(t);
    }

    public void setTickTime(double time){
        this.tickTime=time;
    }

    public double getTickTime() {
        return tickTime;
    }

    @Override
    public void paint(Graphics2D g) {
        for (BaseObject o:objects) o.paint(g);
    }
}
