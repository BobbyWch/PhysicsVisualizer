package physics.engine.model;

public interface Ticking {
    void tick();

    /**
     * 运行前的预处理，比如合并矢量
     */
    void prepareTicking();
}
