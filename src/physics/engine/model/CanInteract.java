package physics.engine.model;

import physics.engine.objs.BaseObject;
import physics.engine.objs.MotionObject;

/**
 * 可以与对象交互的属性
 */
public abstract class CanInteract extends Vector2{
    public CanInteract(){
    }
    public CanInteract(double rad) {
        super(rad);
    }

    public abstract void apply(MotionObject object);
}
