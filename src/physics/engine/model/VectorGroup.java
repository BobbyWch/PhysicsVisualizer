package physics.engine.model;

import physics.engine.objs.MotionObject;

import java.util.Iterator;
import java.util.LinkedList;

public class VectorGroup<T extends CanInteract> {
    public final LinkedList<T> vectors=new LinkedList<>();
    public final LinkedList<Durative> durs=new LinkedList<>();
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
            durs.clear();
            for (T e:vectors){
                sum.add(e);
                if (e instanceof Durative d) {
                    if (d.durTicks()!=-1) durs.add(d);
                }
            }
            modified=false;
        }
        return sum;
    }

    public void apply(MotionObject object) {
        sum.apply(object);
        Iterator<Durative> iterator=durs.iterator();
        Durative d;
        while (iterator.hasNext()){
            d=iterator.next();
            if (d.tick()) {
                iterator.remove();
                for (T vector:vectors){
                    if (vector==d) sum.add(-vector.x,-vector.y);
                }
            }
        }
    }
}
