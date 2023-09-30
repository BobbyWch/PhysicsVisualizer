package physics.engine.scene;

public class Scene {
    private double tickTime=0.01;//单位：s
    public void tick(){

    }
    public void setTickTime(double time){
        this.tickTime=time;
    }

    public double getTickTime() {
        return tickTime;
    }
    
}
