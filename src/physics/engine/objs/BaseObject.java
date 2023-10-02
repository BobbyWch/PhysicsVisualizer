package physics.engine.objs;

import physics.engine.model.Vector2;

public abstract class BaseObject implements CanPaint{
    protected double mass;//单位：kg
    public int id;
    public final Vector2 center;

    public BaseObject(Vector2 center) {
        this.center = center;
    }

    public void rotate(double rad, double x, double y) {
        this.center.rotate(rad, x, y);
    }

    public void rotate(double rad){
        this.center.rotate(rad);
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public abstract boolean contains(Vector2 point);
}
