package edu.sdccd.cisc191.generics;

import java.util.Arrays;

public class ArrayConsumer {
    private String[] array;

    public ArrayConsumer(String[] array) {
        this.array = array;
    }

    public String consume() {
        if (array != null && array.length > 0) {
            String consumedElement = array[0];
            // Create a new array smaller by one element and shift elements left
            String[] newArray = new String[array.length - 1];
            System.arraycopy(array, 1, newArray, 0, newArray.length);
            array = newArray; // Update the array reference to the new array
            return consumedElement; // Return the removed element
        }
        return null; // or throw exception based on requirements
    }

    public String[] getArray() {
        return array;
    }
}