package Assignment1;

interface MyDictionary<K , V>{
    public void add(K key , V value);
    public void delete(K key);
    public V getValue(K key);
    public void sortedList();
    public void sortedListByKeys(K key1 , K key2);
}