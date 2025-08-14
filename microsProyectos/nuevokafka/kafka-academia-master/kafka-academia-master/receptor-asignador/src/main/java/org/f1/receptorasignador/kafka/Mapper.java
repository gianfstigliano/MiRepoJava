package org.f1.receptorasignador.kafka;

public interface Mapper<K, V , D> {

    D toDTO(K key, V value);

}

