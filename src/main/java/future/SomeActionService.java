package future;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class SomeActionService {

    private Map<Integer, String> storage = new ConcurrentHashMap();

    {
        storage.put(0, "Heartstone");
        storage.put(1, "World of Warcraft");
        storage.put(2, "Warcraft 3 The Frozen Throne");
        storage.put(3, "Dota 2");
        storage.put(4, "Starcraft 2");
    }

    public String doAction() {
        Random rnd = new Random();

        try {
            Thread.sleep((Math.abs(rnd.nextInt()) % 4000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return storage.getOrDefault(Math.abs(rnd.nextInt()) % 5, "Unknown");
    }
}
