package org.project.gdsc.domain.model;

public class InventoryItem {
    private String name;
    private int height;
    private int weight;
    private int width;

    public double volumn() {
        return height * weight * width;
    }
}
