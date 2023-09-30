package physics.engine.objs;

public class BaseObject {

    protected double mass;//单位：kg
    public int id;

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
