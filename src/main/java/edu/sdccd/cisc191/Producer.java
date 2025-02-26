package edu.sdccd.cisc191;

/**
 * Producers create a number of new Items and send them to a Warehouse
 *
 * Adapted from Tasha Frankie and Allan Schougaard
 */
public class Producer extends Thread
{
    private final String name;
    private final Warehouse warehouse;
    private final int numberOfItemsToProduce;

    public Producer(String givenName, Warehouse givenWarehouse, int givenNumberOfItemsToProduce)
    {
        this.name = givenName;
        this.warehouse = givenWarehouse;
        this.numberOfItemsToProduce = givenNumberOfItemsToProduce;
    }

    @Override
    public void run()
    {
        System.out.println(name + " running in Thread: " + Thread.currentThread().getName());

        for (int i = 0; i < numberOfItemsToProduce; i++) {
            Item item = new Item(); // Create a new item
            warehouse.receive(item); // Send it to the warehouse
            System.out.println(name + " produced " + item);
        }

        System.out.println(name + " ended.");
    }
}