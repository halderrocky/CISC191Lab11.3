package edu.sdccd.cisc191.generics;

import java.util.HashSet;

public class HashSetConsumer {
    private HashSet<String> set;

    public HashSetConsumer(HashSet<String> set) {
        this.set = set;
    }

    public boolean consume(String item) {
        return set.remove(item); // Remove the item and return true if it was present
    }
}
