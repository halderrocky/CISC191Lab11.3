package edu.sdccd.cisc191.generics;

import java.util.ArrayList;

public class ArrayListProducer {
    private ArrayList<String> list;

    public ArrayListProducer(ArrayList<String> list) {
        this.list = list;
    }

    public void produce(int i, String string) {
        list.add(i, string); // Add string at the ith position, shifting subsequent elements down
    }
}