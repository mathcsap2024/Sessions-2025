package Concurency.Semaphore;

public class APSemaphore {

    int maxPermits;
    int permits;
    protected final Object watcher = new Object();

    public APSemaphore(int permits, int initialPermit) {
        maxPermits=permits;
        this.permits=initialPermit;
    }

    public APSemaphore(int permits) {
        this(permits, permits);
    }

    public APSemaphore() {
        this(1);
    }

    public void acquire() {
        synchronized (watcher) {
            while (permits==0) {
                try {
                    watcher.wait();
                } catch (InterruptedException e) {
                }
            }
            permits--;
        }
    }

    public void release() {
        synchronized (watcher) {
            if(permits<maxPermits) {
                permits++;
            }
            watcher.notifyAll();
        }
    }
}
