package physics.engine.model;

import physics.engine.objs.BaseObject;
import physics.engine.objs.MotionObject;

public class Velocity extends Vector2 implements CanInteract,Durative{
    public int duration=-1;//单位：tick  -1表示无限
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
    public void apply(MotionObject object) {
        object.move(this.x,this.y);
        if (duration!=-1){
            if (--duration==0) {
                object.removeVelocity(this);
            }
        }
    }
}
