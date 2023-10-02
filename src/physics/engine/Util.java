package physics.engine;

import physics.engine.model.Vector2;

public class Util {
    /**
     * 负右/上  正左/下  等于0重合
     */
    public static double getLocation(Vector2 point, Vector2 linePoint1, Vector2 linePoint2) {
        return (linePoint2.x - linePoint1.x) * (point.y - linePoint1.y) -
                (point.x - linePoint1.x) * (linePoint2.y - linePoint1.y);
    }
}
