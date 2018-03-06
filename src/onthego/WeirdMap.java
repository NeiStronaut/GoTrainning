package onthego;
import java.util.Collection;
import java.util.List;

public interface WeirdMap<K, O, C extends Collection<O>> {

    public void put(K key, C collection);

    public <C> C get(K key);

    public <O> List<O> concat(List<O> a, List<O> b);
}
