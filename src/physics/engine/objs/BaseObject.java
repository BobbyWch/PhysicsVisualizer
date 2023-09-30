package physics.engine.objs;

public class BaseObject {
    protected double mass;//单位：kg

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
