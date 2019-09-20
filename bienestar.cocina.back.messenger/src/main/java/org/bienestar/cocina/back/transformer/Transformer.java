package org.bienestar.cocina.back.transformer;

public interface Transformer<T,V> {

	V transform(T origin);
}
