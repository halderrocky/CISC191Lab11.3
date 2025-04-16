package edu.sdccd.cisc191.generics;

import java.util.HashMap;

public class HashMapProducer {
    private HashMap<String, String> map;

    public HashMapProducer(HashMap<String, String> map) {
        this.map = map;
    }

    public void produce(String key, String value) {
        map.put(key, value); // Add or update the key with the provided value
    }
}
