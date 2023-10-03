package physics.engine;

import org.dyn4j.Epsilon;
import physics.engine.model.Vector2;
import physics.engine.model.VectorGroup;
import physics.engine.model.Velocity;
import physics.engine.objs.Circle;
import physics.engine.objs.MassPoint;
import physics.engine.objs.RectObject;
import physics.engine.world.World;

import javax.swing.*;
import java.awt.*;

public class TestUI {
    public static void main(String[] args) throws InterruptedException {
        uiTest();
    }
    public static void consoleTest(){
        System.out.println(Util.getCenter(new Vector2(25,10),new Vector2(5,10),new Vector2(10,20),new Vector2(20,20)));
    }
    public static void uiTest() throws InterruptedException {
        JFrame frame=new JFrame();
        frame.setSize(600,600);
        World world=new World();
        world.setTickTime(0.017);
        Circle circle=new Circle(new Vector2(100,100),50);
        circle.addVelocity(Velocity.newXY(0.3,0.3));
        Velocity v=Velocity.newXY(2,0);
        v.duration=80;
        circle.addVelocity(v);
        world.addObject(circle);

        RectObject rect=new RectObject(new Vector2(10,10),new Vector2(10,40),new Vector2(20,40),new Vector2(20,10));
        rect.addVelocity(Velocity.newXY(0.6,0.1));
        world.addObject(rect);

        circle=new Circle(new Vector2(500,500),100);
        circle.addVelocity(Velocity.newXY(-0.8,-0.4));
        world.addObject(circle);
        world.addObject(new MassPoint(new Vector2(200,200)));

        JPanel panel=new JPanel(){
            @Override
            public void paint(Graphics g){
                super.paint(g);
                world.paint(((Graphics2D) g));
            }
        };
        frame.add(panel,BorderLayout.CENTER);
        frame.setVisible(true);
        world.runTicksAndWait(300, new TickListener() {
            @Override
            public void tickEnd() {
                panel.repaint();
            }
        });
    }
}
