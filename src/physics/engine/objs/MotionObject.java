package physics.engine.objs;

import physics.engine.model.Ticking;
import physics.engine.model.Vector2;
import physics.engine.model.VectorGroup;
import physics.engine.model.Velocity;

public abstract class MotionObject extends BaseObject implements Ticking {
    protected final VectorGroup<Velocity> velocity=new VectorGroup<>(new Velocity());
    public MotionObject(Vector2 pos) {
        super(pos);
    }

    public void addVelocity(Velocity v){
        velocity.add(v);
    }
    public void removeVelocity(Velocity v){
        velocity.remove(v);
    }
    public abstract void move(double dx, double dy);

    @Override
    public void tick() {
        velocity.apply(this);
    }

    @Override
    public void prepareTicking() {
        velocity.getSum();//pre run
    }
}
