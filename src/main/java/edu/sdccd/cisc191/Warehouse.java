package edu.sdccd.cisc191;

import java.util.ArrayList;
import java.util.List;

/**
 * A Warehouse receives, stores and ships Items.
 *
 * Adapted from Tasha Frankie and Allan Schougaard
 */
public class Warehouse
{
    /**
     * storage is managed as one big stack, where items are laid on top of each other
     */
    private final List<Item> storage = new ArrayList<>();

    public synchronized int getNumberOfItemsInStock()
    {
        return storage.size();
    }

    /**
     * Store item at the front of the list
     *
     * @param item the item to store in the Warehouse
     */
    public synchronized void receive(Item item)
    {
        storage.add(item);
        notifyAll(); // Notify any waiting consumers that an item has been added
    }

    /**
     * Remove an item from the collection and make the tests pass
     *
     * @return the item that was retrieved from storage
     * @throws OutOfStockException if there are no items to ship
     */
    public synchronized Item ship() throws OutOfStockException
    {
        if (storage.isEmpty()) {
            throw new OutOfStockException();
        }
        return storage.remove(storage.size() - 1); // Last-in first-out
    }
}