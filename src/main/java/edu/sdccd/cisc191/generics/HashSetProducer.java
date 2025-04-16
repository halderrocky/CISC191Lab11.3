package edu.sdccd.cisc191.generics;

import java.util.HashSet;

public class HashSetProducer {
    private HashSet<String> set;

    public HashSetProducer(HashSet<String> set) {
        this.set = set;
    }

    public boolean produce(String item) {
        return set.add(item); // Add the item, returns false if already present
    }
}
