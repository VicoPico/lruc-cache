import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU cache using LinkedHashMap in access-order mode.
 */
class LRUCache {

  private final int capacity;
  private final Map<Integer, Integer> cache;

  LRUCache(int capacity) {
    this.capacity = capacity;

    // accessOrder=true: get()/put() update recency
    // removeEldestEntry: evict least recently used when capacity exceeded
    this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > LRUCache.this.capacity;
      }
    };
  }

  int get(int key) {
    return cache.getOrDefault(key, -1);
  }

  void put(int key, int value) {
    cache.put(key, value);
  }

  void readCache() {
    for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
      System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }
  }
}