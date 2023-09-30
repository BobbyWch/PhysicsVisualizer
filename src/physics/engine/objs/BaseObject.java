package physics.engine.objs;

import physics.engine.model.Vector2;
import physics.engine.model.VectorGroup;

import java.util.HashMap;

public class BaseObject {
    protected double mass;//单位：kg
    public int id;
    public final Vector2 pos;

    public BaseObject(Vector2 pos) {
        this.pos = pos;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
