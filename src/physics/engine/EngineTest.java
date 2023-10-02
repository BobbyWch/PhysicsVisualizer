package physics.engine;

import physics.engine.model.Vector2;
import physics.engine.model.Velocity;
import physics.engine.objs.MassPoint;
import physics.engine.world.World;

public class EngineTest {
    public static void main(String[] args) throws InterruptedException {
        World world=new World();
        MassPoint point=new MassPoint(new Vector2(10,10));
        point.addVelocity(new Velocity(Math.atan2(1,2),Math.sqrt(5)));
        world.addObject(point);
        world.setTickTime(0.001);
        world.runTicksAndWait(100,null);
        System.out.println(point.center);
    }
}
