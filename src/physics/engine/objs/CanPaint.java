package physics.engine.objs;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public interface CanPaint {
    void paint(Graphics2D g);
    void drawFx(GraphicsContext context);
}
