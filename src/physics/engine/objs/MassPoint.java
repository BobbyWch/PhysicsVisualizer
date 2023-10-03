package physics.engine.objs;

import physics.engine.model.Vector2;

import java.awt.*;

/**
 * 质点
 */
public class MassPoint extends MotionObject implements CanPaint{
    public MassPoint(Vector2 pos) {
        super(pos);
    }

    @Override
    public boolean contains(Vector2 point) {
        return false;
    }

    @Override
    public void paint(Graphics2D g) {
        g.fillOval((int) center.x, (int) center.y,5,5);
    }

    @Override
    public void move(double dx, double dy) {
        center.x+=dx;
        center.y+=dy;
    }
}
