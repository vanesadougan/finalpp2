import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<Class<?>, Class<?>> mapa = new HashMap<>();//Mapa de clases,

    public void add (Class<?> a, Class<?> b) {//Le digo exportable y en exportable guarda csv portable.
        mapa.put(a, b);

    }

    public <T> T get(Class<T> a) {

        try {
            return (T) mapa.get(a).newInstance();
        } catch (Exception e) {
            return null;
        }
    }


}

