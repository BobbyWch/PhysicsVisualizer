package physics.engine;

import physics.engine.model.Vector2;
import physics.engine.objs.BaseObject;
import physics.engine.objs.MotionObject;
import physics.engine.objs.Polygon;

import java.util.Collection;

public class Util {
    /**
     * 机器的浮点数误差
     * 比如对于电脑来说，1+E==1  为true
     */
    public static final double E;
    static {
        double e = 0.5;
        while (1.0 + e > 1.0) {
            e *= 0.5;
        }
        E = e;
    }
    /**
     * 负右/上  正左/下  等于0重合
     * 已测试
     */
    public static double getLocation(Vector2 point, Vector2 linePoint1, Vector2 linePoint2) {
        return (linePoint2.x - linePoint1.x) * (point.y - linePoint1.y) -
                (point.x - linePoint1.x) * (linePoint2.y - linePoint1.y);
    }

    /**
     * 计算一组点的中心
     * 这代码能用就行了
     * 已测试
     * TODO 说真的天天扒代码搞得我有点不好意思了    不过还是浅浅优化了一下性能的
     */
    public static Vector2 getCenter(Vector2... points){
        int size=points.length;
        Vector2 ac = new Vector2();
        int i;
        for (i = 0; i < size; i++) {
            ac.add(points[i]);
        }
        ac.times(1.0 / size);

        Vector2 center = new Vector2(),p1,p2;
        double area = 0.0,triangleArea;
        for (i = 0; i < size; i++) {
            p1 = points[i].copy();
            p2 = (i + 1 < size ? points[i + 1] : points[0]).copy();
            p1.x-=ac.x;
            p1.y-=ac.y;
            p2.x-=ac.x;
            p2.y-=ac.y;
            triangleArea = 0.5 * p1.cross(p2);
            area += triangleArea;
            p1.add(p2);
            p1.times(1.0/3.0);
            p1.times(triangleArea);
            center.add(p1);
        }

        if (Math.abs(area) <= E) {
            return points[0].copy();
        }
        center.add(ac);
        return center;
    }

    public static boolean checkCover(Collection<BaseObject> objects, Polygon thisObj){
        for (BaseObject o:objects){
            if (thisObj.covers(o)) return true;
        }
        return false;
    }
}
