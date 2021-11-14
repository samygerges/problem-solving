import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

    Lock lock;
    AtomicInteger incr = new AtomicInteger(0);

    public Account(){
        lock = new ReentrantLock();
    }

    void debit(DollarAmount amount){

    }

    void credit(DollarAmount amount){

    }

    DollarAmount getBalance() {
        return null;
    }
}
