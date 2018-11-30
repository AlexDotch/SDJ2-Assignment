package assignment3.arraymap;

import java.util.List;

public interface MapADT<K, V> {

    public void put(K key, V value);
    public V get(K key);
    public boolean containsKey(K key);
    public boolean containsValue(V value);
    public int size();
    public boolean isEmpty();
    public List<K> keyList();
    public List<V> valueList();
    public V remove(K key);
    public boolean remove(K key, V value);
    public boolean replace(K key, V value);
}
