package edu.sdccd.cisc191;

/**
 * Consumers receive a number of Items from a Warehouse
 *
 * Adapted from Tasha Frankie and Allan Schougaard
 */
public class Consumer extends Thread
{
    private final String name;
    private final Warehouse warehouse;
    private final int numberOfItemsToConsume;

    public Consumer(String givenName, Warehouse givenWarehouse, int givenNumberOfItemsToConsume)
    {
        this.name = givenName;
        this.warehouse = givenWarehouse;
        this.numberOfItemsToConsume = givenNumberOfItemsToConsume;
    }

    @Override
    public void run()
    {
        System.out.println(name + " running in Thread: " + Thread.currentThread().getName());

        try {
            for (int i = 0; i < numberOfItemsToConsume; i++) {
                Item item = warehouse.ship(); // Try to ship an item
                System.out.println(name + " consumed " + item);
            }
        } catch (OutOfStockException e) {
            System.out.println(name + " found no items to consume.");
        }

        System.out.println(name + " ended.");
    }
}