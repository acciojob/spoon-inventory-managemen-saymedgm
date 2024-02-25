package com.driver;

import java.util.HashMap;
import java.util.Map;

public class SpoonInventory {
    public Map<String, Spoon> spoonMap;

    public SpoonInventory() {
        this.spoonMap = new HashMap<>();
    }

    public void addSpoonType(String name, int quantity) {
        Spoon spoon = new Spoon(name, quantity);
        spoonMap.put(name, spoon);
        System.out.println(name + " added to the inventory with quantity: " + quantity);
    }

    public int retrieveSpoonDetails(String name) {
        if (spoonMap.containsKey(name)) {
            return spoonMap.get(name).getQuantity();
        } else {
            throw new IllegalArgumentException("Spoon type not found: " + name);
        }
    }

    public int computeTotalSpoons() {
        int totalSpoons = spoonMap.values().stream().mapToInt(Spoon::getQuantity).sum();
        System.out.println("Total number of spoons in the inventory: " + totalSpoons);
        return totalSpoons;
    }
}