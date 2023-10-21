package physics.engine.objs;

import javafx.scene.canvas.GraphicsContext;
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
        g.drawString(center.x+","+center.y, (int) center.x, (int) center.y);
    }

    @Override
    public void drawFx(GraphicsContext context) {

    }

    @Override
    public void move(double dx, double dy) {
        center.add(dx,dy);
    }
}
