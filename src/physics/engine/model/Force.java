package physics.engine.model;

import physics.engine.objs.BaseObject;

public class Force extends Vector2 implements CanInteract{
    //受力物体
    BaseObject ForceOn;
    //力的大小
    double size;
    @Override
    public void apply(BaseObject object) {

    }
}
