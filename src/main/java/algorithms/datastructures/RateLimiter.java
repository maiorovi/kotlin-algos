package algorithms.datastructures;

import java.util.concurrent.TimeUnit;

public class RateLimiter {
    private RingBuffer<Long> ringBuffer;
    private int maxRequestsAllowed;

    public RateLimiter(int maxRequestsAllowed) {
        this.maxRequestsAllowed = maxRequestsAllowed;
        ringBuffer = new RingBuffer<>(maxRequestsAllowed);
        ringBuffer.put(System.currentTimeMillis());
    }

    public boolean isAllowed() {
        Long currentTime = System.currentTimeMillis();

        boolean answer = (currentTime - ringBuffer.get()) < TimeUnit.SECONDS.toMillis(1);

        ringBuffer.put(currentTime);

        return !(answer && ringBuffer.available() == maxRequestsAllowed);
    }
}
