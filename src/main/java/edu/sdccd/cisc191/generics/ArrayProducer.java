package edu.sdccd.cisc191.generics;

public class ArrayProducer {
    private String[] array;

    public ArrayProducer(String[] array) {
        this.array = array;
    }

    public void produce(int i, String string) {
        if (array != null && array.length >= i) {
            // Create a new array larger by one element
            String[] newArray = new String[array.length + 1];
            // Copy elements before the index
            System.arraycopy(array, 0, newArray, 0, i);
            // Add new string at the ith position
            newArray[i] = string;
            // Copy elements after the index
            System.arraycopy(array, i, newArray, i + 1, array.length - i);
            array = newArray; // Update the array reference to the new array
        }
    }

    public String[] getArray() {
        return array;
    }
}
