package com.example.tp2jeejsp.Exo1;

import java.util.ArrayList;
import java.util.List;

public class Visitor {
    private String name;
    private List<String> allVisitors;

    // Constructor
    public Visitor() {
        this.allVisitors = new ArrayList<>();
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name (JSP will use this automatically)
    public void setName(String name) {
        this.name = name;
    }

    // Getter for allVisitors
    public List<String> getAllVisitors() {
        return allVisitors;
    }

    // Setter for allVisitors
    public void setAllVisitors(List<String> allVisitors) {
        this.allVisitors = allVisitors;
    }

    // Method to add a visitor
    public void addVisitor(String visitor) {
        if (visitor != null && !visitor.trim().isEmpty()) {
            this.allVisitors.add(visitor);
        }
    }

    // Method to get visitor count
    public int getVisitorCount() {
        return allVisitors.size();
    }

    // Method to check if list is empty
    public boolean isEmpty() {
        return allVisitors.isEmpty();
    }
}
