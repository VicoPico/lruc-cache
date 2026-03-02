import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Basic cache backed by LinkedHashMap.
 * No LRU behavior yet — just key/value storage.
 */
class LRUCache {

  private final int capacity;
  private final Map<Integer, Integer> cache;

  LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new LinkedHashMap<>();
  }

  // Returns value if present, otherwise -1
  int get(int key) {
    return cache.getOrDefault(key, -1);
  }

  // Inserts or updates value (no eviction yet)
  void put(int key, int value) {
    cache.put(key, value);
  }
}
