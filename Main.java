public class Main {

  public static void main(String[] args) {
    System.out.println("====================================");
    System.out.println("         LRU CACHE DEMO");
    System.out.println("====================================\n");

    int capacity = 2;
    System.out.println("Creating cache with capacity = " + capacity + "\n");

    LRUCache cache = new LRUCache(capacity);

    step("PUT (1, 10)");
    cache.put(1, 10);
    cache.readCache();

    step("PUT (2, 20)");
    cache.put(2, 20);
    cache.readCache();

    step("GET (1)  → Expect 10 (and move 1 to MRU)");
    System.out.println("Result: " + cache.get(1));
    cache.readCache();

    step("PUT (3, 30)  → Expect eviction of key 2 (LRU)");
    cache.put(3, 30);
    cache.readCache();

    step("GET (2)  → Expect -1 (was evicted)");
    System.out.println("Result: " + cache.get(2));
    cache.readCache();

    step("PUT (4, 40)  → Expect eviction of key 1");
    cache.put(4, 40);
    cache.readCache();

    step("Final GET checks");
    System.out.println("GET (1): " + cache.get(1)); // -1
    System.out.println("GET (3): " + cache.get(3)); // 30
    System.out.println("GET (4): " + cache.get(4)); // 40
    cache.readCache();

    System.out.println("\n====================================");
    System.out.println("           DEMO COMPLETE");
    System.out.println("====================================");
  }

  private static void step(String message) {
    System.out.println("\n------------------------------------");
    System.out.println(message);
    System.out.println("------------------------------------");
  }
}
