package physics.engine.objs;

import physics.engine.model.Vector2;

import java.awt.*;

/**
 * 矩形
 */
public class RectObject extends MotionObject{
    public RectObject(Vector2 pos) {
        super(pos);
    }

    @Override
    public boolean contains(Vector2 point) {
        return false;
    }

    @Override
    public void paint(Graphics2D g) {

    }
}
