package physics.engine.objs;

import physics.engine.model.Vector2;

import java.awt.*;

/**
 * 圆（后期开发）
 */
public class Circle extends MotionObject implements CanPaint{
    public double r;
    public Circle(Vector2 pos) {
        super(pos);
    }

    @Override
    public boolean contains(Vector2 point) {
        double xx,yy;
        xx= point.x-center.x;
        yy=point.y-center.y;
        return xx * xx + yy * yy <= r * r;
    }

    @Override
    public void paint(Graphics2D g) {
        g.drawOval((int) center.x, (int) center.y, (int) (2*r), (int) (2*r));
    }
}
