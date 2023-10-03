package physics.engine.model;

import physics.engine.objs.BaseObject;
import physics.engine.objs.MotionObject;

/**
 * 可以与对象交互的属性
 */
public interface CanInteract {
    void apply(MotionObject object);
}
