package org.project.gdsc.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
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
}
