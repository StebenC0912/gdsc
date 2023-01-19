package org.project.gdsc.infrastructure.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.project.gdsc.domain.model.InventoryItem;

@Getter
@Setter
@AllArgsConstructor
public class InventoryItemEntities {
   private String name;
   private int height;
    private int width;
    private int weight;
    private InventoryEntity inventory;

    public InventoryItemEntities(InventoryItem inventoryItem) {
        this.name = inventoryItem.getName();
        this.height = inventoryItem.getHeight();
        this.width = inventoryItem.getWidth();
        this.weight = inventoryItem.getWeight();
    }
}
