package physics.engine;

import physics.engine.model.Vector2;
import physics.engine.model.Velocity;
import physics.engine.objs.Circle;
import physics.engine.objs.MassPoint;
import physics.engine.world.World;

import javax.swing.*;
import java.awt.*;

public class TestUI {
    public static void main(String[] args) {
        consoleTest();
    }
    public static void consoleTest(){
        Vector2 l1=new Vector2(10,-30.1);
        Vector2 l2=new Vector2(60,-30);
        Vector2 point=new Vector2(10,-30.1);
        System.out.println(Util.getLocation(l1,l2,point));
    }
    public static void uiTest() throws InterruptedException {
        JFrame frame=new JFrame();
        frame.setSize(600,600);
        World world=new World();
        world.setTickTime(0.017);
        Circle circle=new Circle(new Vector2(100,100));
        circle.r=50;
        circle.addVelocity(Velocity.newXY(1,1));
        world.addObject(circle);

        circle=new Circle(new Vector2(500,500));
        circle.r=100;
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
