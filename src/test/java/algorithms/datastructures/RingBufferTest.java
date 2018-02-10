package algorithms.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


public class RingBufferTest {

    RingBuffer<Integer> ringBuffer = new RingBuffer<>(10);

    @Before
    public void setUp() throws Exception {
        ringBuffer = new RingBuffer<>(10);
    }

    @Test
    public void ringBufferAllowsOneReadOfIncertedItem() {
        ringBuffer.put(5);

        assertThat(ringBuffer.get())
                .isEqualTo(5);
    }

    @Test
    public void afterNoAvailableElementsInBufferReturnsNull() {
        assertThat(ringBuffer.get()).isNull();
    }

    @Test
    public void returnsTheOldestInsertedElement() {
        IntStream.range(0, 10).forEach(ringBuffer::put);

        assertThat(ringBuffer.get()).isEqualTo(0);
    }

    @Test
    public void readsTheOldestElementEvenAfterTheCycle() {
        IntStream.range(0, 14).forEach(ringBuffer::put);

        assertThat(ringBuffer.get()).isEqualTo(4);
    }
}