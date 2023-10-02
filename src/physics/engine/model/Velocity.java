package physics.engine.model;

import physics.engine.objs.BaseObject;

public class Velocity extends Vector2 implements CanInteract{

    public static Velocity newDirection(double rad, double size){
        Velocity v=new Velocity(rad);
        v.times(size);
        return v;
    }
    public static Velocity newXY(double Vx, double Vy){
        Velocity v=new Velocity();
        v.add(Vx,Vy);
        return v;
    }
    public Velocity(){
    }
    private Velocity(double rad){
        super(rad);
    }
    @Override
    public void apply(BaseObject object) {
        object.center.add(this);
    }
}
