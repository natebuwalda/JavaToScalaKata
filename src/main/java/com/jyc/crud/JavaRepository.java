package com.jyc.crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaRepository {

    private Map<String, List<String>> datastore = new HashMap<String, List<String>>();

    public Integer insert(String key, List<String> items) {
        datastore.put(key, items);
        return items.size();
    }

    public List<String> find(String key) {
        return datastore.get(key);
    }

    public Integer update(String key, List<String> items) {
        List<String> existing = datastore.get(key);
        existing.addAll(items);
        datastore.put(key, existing);

        return items.size();
    }

    public Integer remove(String key, List<String> items) {
        List<String> existing = datastore.get(key);
        for (String item : items) {
            if (existing.contains(item)) {
                existing.remove(item);
            }
        }
        datastore.put(key, existing);

        return items.size();
    }
}
