package physics.engine.model;

import physics.engine.objs.MotionObject;

public class Velocity extends CanInteract implements Durative{
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
    }

    @Override
    public boolean tick() {
        return duration!=-1&&--duration==0;
    }

    @Override
    public int durTicks() {
        return duration;
    }
}
