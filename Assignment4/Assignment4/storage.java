import java.util.*;

public class storage<T> {
    private ArrayList<T> allmats;
    storage(){
        this.allmats = new ArrayList<>();
    }
    public void add(T o) {
            this.allmats.add(o);
    }
    public int size(){
        return allmats.size();
    }
    public T get(int index){
        return (T)this.allmats.get(index);
    }
    
}
