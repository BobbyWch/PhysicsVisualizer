package physics.engine.objs;

import javafx.scene.canvas.GraphicsContext;
import physics.engine.Util;
import physics.engine.model.Vector2;

import java.awt.*;

public class Polygon extends MotionObject{
    public final Vector2[] points;

    /**
     * 注意点应该是连续的
     */
    public Polygon(Vector2... points) {
        super(Util.getCenter(points));
        this.points=points;
    }

    @Override
    public boolean contains(Vector2 point) {
        Vector2 p1 = this.points[0];
        Vector2 p2 = this.points[1];
        double last = Util.getLocation(point, p1, p2);
        int size = this.points.length;
        for (int i = 1; i < size; i++) {
            p1 = p2;
            p2 = this.points[(i + 1) == size ? 0 : i + 1];
            if (point.equals(p1)) {
                return true;
            }
            if (last * Util.getLocation(point, p1, p2) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean covers(BaseObject p){
        for (Vector2 point:this.points){
            if (p.contains(point)) return true;
        }
        return false;
    }
    @Override
    public void paint(Graphics2D g) {
        int size= points.length;
        for (int i=0;i< size;i++){
            if (i+1==size) g.drawLine((int) points[i].x, (int) points[i].y, (int) points[0].x, (int) points[0].y);
            else g.drawLine((int) points[i].x, (int) points[i].y, (int) points[i+1].x, (int) points[i+1].y);
            g.drawString(center.x+","+center.y, (int) center.x, (int) center.y);
        }
    }

    @Override
    public void drawFx(GraphicsContext context) {
        int size= points.length;
        Vector2 point=points[points.length-1];
        context.moveTo(point.x,point.y);
        for (int i=0;i< size;i++){
            point=points[i];
            context.lineTo(point.x,point.y);
        }
    }

    @Override
    public void move(double dx, double dy) {
        for (Vector2 p:points){
            p.add(dx,dy);
        }
        if (Util.checkCover(world.getObjects(),this)) {
            for (Vector2 p:points){
                p.add(-dx,-dy);
            }
            System.out.println("no move");
        }else center.add(dx,dy);
    }
}
