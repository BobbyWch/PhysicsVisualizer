package physics.engine.model;

import physics.engine.objs.BaseObject;

/**
 * 可以与对象交互的属性
 */
public interface CanInteract {
    void apply(BaseObject object);
}
