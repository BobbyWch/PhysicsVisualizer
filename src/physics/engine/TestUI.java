package physics.engine;

import physics.engine.model.Vector2;
import physics.engine.model.Velocity;
import physics.engine.objs.Circle;
import physics.engine.objs.MassPoint;
import physics.engine.world.World;

import javax.swing.*;
import java.awt.*;

public class TestUI {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame=new JFrame();
        frame.setSize(600,600);
        World world=new World();
        world.setTickTime(0.017);
        Circle circle=new Circle(new Vector2(100,100));
        circle.r=50;
        circle.addVelocity(new Velocity(1.7*Math.PI,1));
        world.addObject(circle);

        circle=new Circle(new Vector2(300,300));
        circle.r=100;
        circle.addVelocity(new Velocity(0.3*Math.PI,0.3));
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
