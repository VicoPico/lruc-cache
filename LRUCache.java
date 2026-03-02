import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Enables access-order so that recently accessed
 * entries move to the end of the map.
 */
class LRUCache {

  private final int capacity;
  private final Map<Integer, Integer> cache;

  LRUCache(int capacity) {
    this.capacity = capacity;

    // accessOrder=true makes get()/put() update recency
    this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
  }

  // Accessing a key updates its recency
  int get(int key) {
    return cache.getOrDefault(key, -1);
  }

  void put(int key, int value) {
    cache.put(key, value);
  }
}
