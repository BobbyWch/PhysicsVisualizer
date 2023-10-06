package physics.engine.model;

/**
 * 二维矢量，也可以作为坐标对象
 */
public class Vector2 {
    public static final Vector2 X=new Vector2(1,0);
    public static final Vector2 Y=new Vector2(0,1);
    public double x;
    public double y;
    public Vector2(){
        this(0,0);
    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param rad 与x轴夹角，0~PI
     */
    public Vector2(double rad){
        x=StrictMath.cos(rad);
        y=StrictMath.sin(rad);
    }

    /**
     * 矢量叠加
     */
    public void add(Vector2 vector){
        x+= vector.x;
        y+= vector.y;
    }
    public void add(double x,double y){
        this.x+=x;
        this.y+=y;
    }

    /**
     * 放大/缩小
     * @param t 倍数
     */
    public void times(double t){
        x*=t;
        y*=t;
    }
    /**
     * 旋转
     */
    public void rotate(double theta) {
        double cos = StrictMath.cos(theta);
        double sin = StrictMath.sin(theta);
        double x = this.x;
        double y = this.y;
        this.x = x * cos - y * sin;
        this.y = x * sin + y * cos;
    }
    /**
     * 在坐标系中旋转
     */
    public void rotate(double theta, double x, double y) {
        this.x -= x;
        this.y -= y;
        this.rotate(theta);
        this.x += x;
        this.y += y;
    }

    /**
     * 叉乘
     */
    public double cross(Vector2 vector) {
        return this.x * vector.y - this.y * vector.x;
    }

    public double length(){
        return Math.sqrt(this.x*this.x+this.y*this.y);
    }

    public double squaredLength(){
        return this.x*this.x+this.y*this.y;
    }
    public double rad(){
        return StrictMath.atan2(this.y, this.x);
    }

    public Vector2 copy(){
        return new Vector2(this.x, this.y);
    }
    public void clear(){
        this.x=this.y=0;
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
