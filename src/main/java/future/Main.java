package future;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        SomeActionService someActionService = new SomeActionService();

        final String answer = executorService.submit(() -> someActionService.doAction()).get(4, TimeUnit.SECONDS);
        System.out.println(answer);
    }
}
