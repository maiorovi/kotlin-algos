package algorithms.future;

import com.sun.xml.internal.ws.util.CompletedFuture;
import future.SomeActionService;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class CompletableFutureCreatingTest {

    @Test
    public void completed() throws ExecutionException, InterruptedException {
        final CompletableFuture<Integer> answer = CompletableFuture.completedFuture(42);

        final int fortyTwo = answer.get();

        System.out.println(fortyTwo);
    }

    @Test
    public void supplyAsync() throws ExecutionException, InterruptedException {
        SomeActionService someActionService = new SomeActionService();

        final CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> someActionService.doAction(), Executors.newFixedThreadPool(10));

        future.thenAccept(System.out::println);

        System.out.println("Test ends here");
        Thread.sleep(5000);
    }

    @Test
    public void thenApply() throws InterruptedException {
        SomeActionService someActionService = new SomeActionService();

        final CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> someActionService.doAction(), Executors.newFixedThreadPool(10));

        future.thenApply(s -> s.length()).thenAccept(System.out::println);

        System.out.println("Test ends here");
        Thread.sleep(5000);
    }

    @Test
    public void either() throws InterruptedException {
        SomeActionService someActionService = new SomeActionService();
        final CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> someActionService.doAction());

        CompletableFuture.supplyAsync(() -> someActionService.doAction())
                .applyToEither(f1, Function.identity())
                .thenAccept(System.out::println);

        Thread.sleep(5000);
    }
}
