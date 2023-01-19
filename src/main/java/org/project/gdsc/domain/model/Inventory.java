package org.project.gdsc.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
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
