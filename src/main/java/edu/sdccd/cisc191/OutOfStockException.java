package edu.sdccd.cisc191;

/**
 * The class is used when a Warehouse does not have any Items in stock.
 *
 * Adapted from Tasha Frankie and Allan Schougaard
 */
public class OutOfStockException extends Exception
{
    public OutOfStockException() {
        super("No items in stock.");
    }
}