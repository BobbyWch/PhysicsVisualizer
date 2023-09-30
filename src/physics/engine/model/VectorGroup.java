package physics.engine.model;

import java.util.LinkedList;

public class VectorGroup<T extends Vector2> {
    public final LinkedList<T> vectors=new LinkedList<>();
    private final T sum;
    private boolean modified;
    public VectorGroup(T sum){
        this.sum=sum;
    }
    public void add(T vector){
        vectors.add(vector);
        modified=true;
    }
    public void remove(T vector){
        vectors.remove(vector);
        modified=true;
    }
    public T getSum(){
        if (modified){
            sum.clear();
            for (T e:vectors){
                sum.add(e);
            }
            modified=false;
        }
        return sum;
    }
}
