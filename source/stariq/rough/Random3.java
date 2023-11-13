package stariq.rough;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Random3 {

    public static void main(String[] args) {

    }
}

/** Question 3 implementation template */
final class PriceHolder {

    Map<String, BigDecimal> entityPrice;
    Map<String, Boolean> entityPriceChange;
    private ReentrantLock lockObj = new ReentrantLock();
    private Condition priceChangedCondition = lockObj.newCondition();

    public PriceHolder() {
        entityPrice = new HashMap<>();
        entityPriceChange = new HashMap<>();
    }

    /** Called when a price ‘p’ is received for an entity ‘e’ */
    public synchronized void putPrice(String e, BigDecimal p) {
        entityPrice.put(e, p);
        // TODO: confirm requirements:
        // - if getPrice(e) is never called, should the default be false?
        // - if the new entity price is the same as the last one, does it count as price changed?
        entityPriceChange.put(e, true);
        priceChangedCondition.signal();
    }

    /** Called to get the latest price for entity ‘e’ */
    public synchronized BigDecimal getPrice(String e) {
        if(entityPrice.containsKey(e)) {
            entityPriceChange.put(e, false);
            return entityPrice.get(e);
        }
        return null;
    }

    /**
     * Called to determine if the price for entity ‘e’ has
     * changed since the last call to getPrice(e).
     */
    public synchronized boolean hasPriceChanged(String e) {
        return entityPriceChange.getOrDefault(e, false);
    }

    /**
     * Returns the next price for entity ‘e’. If the price has changed since the last
     * call to getPrice() or waitForNextPrice(), it returns immediately that price.
     * Otherwise it blocks until the next price change for entity ‘e’.
     */
    public BigDecimal waitForNextPrice(String e) throws InterruptedException {
        if(hasPriceChanged(e)) {
            return getPrice(e);
        }
        priceChangedCondition.await();

        return null;
    }
}
