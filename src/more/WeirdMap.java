package more;
import java.util.Collection;
import java.util.List;

public interface WeirdMap<K, O, C extends Collection<O>> {

    public void put(K key, C collection);

    public C get(K key);

    public List<O> concat(List<O> a, List<O> b);
}
