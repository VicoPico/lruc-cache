public class Main {

  public static void main(String[] args) {
    System.out.println("===== LRU CACHE DEMO START =====");
    System.out.println("Capacity = 2\n");

    LRUCache cache = new LRUCache(2);

    System.out.println("PUT (1, 10)");
    cache.put(1, 10);
    cache.readCache();
    System.out.println();

    System.out.println("PUT (2, 20)");
    cache.put(2, 20);
    cache.readCache();
    System.out.println();

    System.out.println("GET (1) -> expect 10");
    System.out.println("Result: " + cache.get(1));
    System.out.println("After GET(1), order should change:");
    cache.readCache();
    System.out.println();

    System.out.println("PUT (3, 30)");
    System.out.println("Capacity exceeded → should evict LRU (key 2)");
    cache.put(3, 30);
    cache.readCache();
    System.out.println();

    System.out.println("GET (2) -> expect -1 (evicted)");
    System.out.println("Result: " + cache.get(2));
    cache.readCache();
    System.out.println();

    System.out.println("PUT (4, 40)");
    System.out.println("Capacity exceeded → should evict LRU (key 1)");
    cache.put(4, 40);
    cache.readCache();
    System.out.println();

    System.out.println("Final GET checks:");
    System.out.println("GET (1) = " + cache.get(1)); // -1
    System.out.println("GET (3) = " + cache.get(3)); // 30
    System.out.println("GET (4) = " + cache.get(4)); // 40
    System.out.println();

    System.out.println("===== LRU CACHE DEMO END =====");
  }
}
