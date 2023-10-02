package physics.engine.model;

import physics.engine.objs.BaseObject;

public class Velocity extends Vector2 implements CanInteract{
    public Velocity(){
    }
    public Velocity(double rad, double size){
        super(rad);
        times(size);
    }
    @Override
    public void apply(BaseObject object) {
        object.center.add(this);
    }
}
