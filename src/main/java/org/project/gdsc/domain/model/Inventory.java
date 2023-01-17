package org.project.gdsc.domain.model;
import java.util.Collections;
import jakarta.persistence.GeneratedValue;
import java.util.List;

import jakarta.persistence.GenerationType;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
