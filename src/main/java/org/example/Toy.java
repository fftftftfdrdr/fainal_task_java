package org.example;

public class Toy {
    private String id;
    private String name;
    private int weight;

    public Toy(String id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
