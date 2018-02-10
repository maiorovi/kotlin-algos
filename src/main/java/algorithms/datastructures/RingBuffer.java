package algorithms.datastructures;

public class RingBuffer<T> {
    private T[] arr;

    private int size;
    private int writepos = 0;
    private int available = 0;

    public RingBuffer(int size) {
        this.size = size;
        arr = (T[]) new Object[size];
    }

    public void put(T key) {
        if (writepos >= size) {
            writepos = 0;
        }

        arr[writepos++] = key;
        if (available < size) {
            available++;
        }
    }

    public T get() {
        if (available == 0) {
            return null;
        }
        int readpos = writepos - available;
        if (readpos < 0) {
            readpos += size;
        }

        available--;

        return arr[readpos];
    }

    public int available() {
        return available;
    }
}
