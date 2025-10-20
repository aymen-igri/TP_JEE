package com.example.tp2jeejsp.Exo1;

import java.util.ArrayList;
import java.util.List;

public class Visitor {
    private String name;
    private List<String> allVisitors;

    public Visitor() {
        this.allVisitors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAllVisitors() {
        return allVisitors;
    }

    public void setAllVisitors(List<String> allVisitors) {
        this.allVisitors = allVisitors;
    }

    public void addVisitor(String visitor) {
        if (visitor != null && !visitor.trim().isEmpty()) {
            this.allVisitors.add(visitor);
        }
    }

    public int getVisitorCount() {
        return allVisitors.size();
    }

    public boolean isEmpty() {
        return allVisitors.isEmpty();
    }
}
