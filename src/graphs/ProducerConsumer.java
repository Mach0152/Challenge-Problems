package graphs;

import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ProducerConsumer {

    Queue<String> strings;
    Lock lock = new ReentrantLock();
    Lock event;

    public boolean produce(){
        String string = randomString();
        lock.lock();
        strings.add(string);
        if (strings.size() == 1) event.notify();
        lock.unlock();
    }

    public String consume() {
        String string = null;
        lock.lock();
        string = strings.poll();
        lock.unlock();
        if(string == null){
            event.wait();
            lock.lock();
            string = strings.poll();
            lock.unlock();
        }
        return string;

    }
}
