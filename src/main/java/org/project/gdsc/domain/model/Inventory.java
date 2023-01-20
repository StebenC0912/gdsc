package org.project.gdsc.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
public class Inventory {
    private int id;
    private int height;
    private int weight;
    private int width;
    private List<InventoryItem> inventoryItem;
    public double capacity() {
        double totalInventoryItemVolumn = 0;
        for (InventoryItem inventoryItem : inventoryItem)
            totalInventoryItemVolumn += inventoryItem.volumn();
        return volumn() - totalInventoryItemVolumn;
    }
    public double volumn() {
        return height * width * weight;
    }
    public List<InventoryItem> getInventInventoryItems() {
        return Collections.unmodifiableList(inventoryItem);
    }

    public void checkIn(InventoryItem inventoryItem) {
        if (inventoryItem.volumn() > capacity()) {
            throw new RuntimeException("Insufficient capacity");
        }
    }

    public void setId(int id) {
        if (id < 0) {
            throw new RuntimeException("Id must be greater than 0");
        }
        this.id = id;
    }

    public void setHeight(int height) {
        if (height < 0) {
            throw new RuntimeException("Height must be greater than 0");
        }
        this.height = height;
    }

    public void setWeight(int weight) {
        if (weight < 0) {
            throw new RuntimeException("Weight must be greater than 0");
        }
        this.weight = weight;
    }

    public void setWidth(int width) {
        if (width < 0) {
            throw new RuntimeException("Width must be greater than 0");
        }
        this.width = width;
    }

    public void setInventoryItem(List<InventoryItem> inventoryItem) {
        this.inventoryItem = inventoryItem;
    }
}
