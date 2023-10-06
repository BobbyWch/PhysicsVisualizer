package physics.engine.model;

public interface Durative {
    /**
     * @return true如果持续时间结束了，在apply()后调用
     */
    boolean tick();

    /**
     * @return 剩余的持续时间
     */
    int durTicks();
}
