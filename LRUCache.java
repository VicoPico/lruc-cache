import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Full LRU cache implementation using LinkedHashMap.
 * - accessOrder=true maintains recency
 * - removeEldestEntry handles automatic eviction
 */
class LRUCache {

  private final int capacity;
  private final Map<Integer, Integer> cache;

  LRUCache(int capacity) {
    this.capacity = capacity;

    this.cache =
      new LinkedHashMap<>(capacity, 0.75f, true) {
        // Automatically remove least recently used entry
        @Override
        protected boolean removeEldestEntry(
          Map.Entry<Integer, Integer> eldest
        ) {
          return size() > LRUCache.this.capacity;
        }
      };
  }

  // Returns value if present; access updates recency
  int get(int key) {
    return cache.getOrDefault(key, -1);
  }

  // Inserts or updates value; eviction happens automatically if needed
  void put(int key, int value) {
    cache.put(key, value);
  }

  // Debug helper to print cache state (LRU -> MRU order)
  void readCache() {
    for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
      System.out.println(
        "Key: " + entry.getKey() + ", Value: " + entry.getValue()
      );
    }
  }
}
